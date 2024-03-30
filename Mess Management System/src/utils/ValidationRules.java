package utils;
import java.time.LocalDate;
import java.util.DuplicateFormatFlagsException;
import java.util.HashMap;
import java.util.Map;

import com.mess.*;

import custom_exception.DuplicateCustomerId;
import custom_exception.IdNotFoundException;
import custom_exception.InvalidDateException;
import custom_exception.InvalidEmailException;
import custom_exception.InvalidPasswordException;
import custom_exception.InvalidPhoneNoException;
public class ValidationRules {
	//validate plan
	
	public static Plan validatePlan(String plan) {
		return Plan.valueOf(plan.toUpperCase());
	}
	
	//validate date
	
	public static LocalDate parseAndValidateDate(String date) throws InvalidDateException{
		LocalDate regDate=LocalDate.parse(date);
		if(regDate.isBefore(LocalDate.now())) {
			throw new InvalidDateException("Invalid date");
		}
		else return regDate;
	}
	
	//validate mobile number
	
	public static String validateMobileNumber(String phoneNo) throws InvalidPhoneNoException{
		String pattern="^1?([1-9])(\\d{9})";
		if(phoneNo.matches(pattern)) {
			return phoneNo;
		}
		else
			throw new InvalidPhoneNoException("Invalid phone number");
	}
	//check duplicate customer
	
	public static int checkDuplicateCustomer(int custId,Map<Integer, Mess> customer) throws DuplicateCustomerId {
		if(customer.containsKey(custId)) {
			throw new DuplicateCustomerId("Duplicate customer id!!!!");
		}
		return custId;
	}
	
	//validate email
	
	public static String validateEmail(String email) throws InvalidEmailException{
		String pattern="[A-Z0-9a-z._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}";
		if(email.matches(pattern)) {
			return email;
		}
		else
			throw new InvalidEmailException("Invalid email Format");
	}
	
	//last date
	
	public static LocalDate lastDate(LocalDate date,Map<Integer, Mess>map) {
		LocalDate lastDate = null;
		for(Mess m: map.values()) {
			if(m.getPlan()==Plan.valueOf("MONTHLY")) {
				lastDate=date.plusMonths(1);
			}
			if(m.getPlan()==Plan.valueOf("QUARTERLY")) {
				lastDate=date.plusMonths(3);
			}
			if(m.getPlan()==Plan.valueOf("HALFYEAR")) {
				lastDate=date.plusMonths(6);
			}
			if(m.getPlan()==Plan.valueOf("YEAR")) {
				lastDate=date.plusMonths(12);
			}
		}
		return lastDate;
	}
	
	//remove customer
	
	public static void removeCustomer(int id,Map<Integer, Mess>map) throws IdNotFoundException{
		if(map.containsKey(id)) {
			map.remove(id);
		}
		else
			throw new IdNotFoundException("Id Not Present");
	}
	
	//Sign in
	
	public static void validateSignIn(String email,String password,Map<Integer, Mess>map)throws InvalidEmailException,InvalidPasswordException {
		for(Mess m:map.values()) {
			if(m.getEmail().equals(email)) {
				if(m.getPasssword().equals(password)) {
					System.out.println("Successful login");
				}
				else {
					throw new InvalidPasswordException("Wrong Password");
				}
			}
			else {
				throw new InvalidEmailException("Wrong Password");
			}
		}
	}
	
	//change password
	
	public static void cahngePassword(String email,String password,String newPAssword,Map<Integer, Mess>map)throws InvalidEmailException,InvalidPasswordException {
		for(Mess m:map.values()) {
			if(m.getEmail().equals(email)) {
				if(m.getPasssword().equals(password)) {
					m.setPasssword(newPAssword);
					System.out.println("Password Changed Successfuly");
				}
				else {
					throw new InvalidPasswordException("Wrong Password");
				}
			}
			else {
				throw new InvalidEmailException("Wrong Password");
			}
		}
	}
	
	//validate all
	
	public static Mess validateAll(int customerId, String firstName, String lastName, String email, String passsword, String address,
			String registerDate, String phoneNo, String plan,Map<Integer, Mess>map) throws DuplicateCustomerId,InvalidEmailException,InvalidDateException,InvalidPhoneNoException{
		int id=checkDuplicateCustomer(customerId, map);
		LocalDate regDate=parseAndValidateDate(registerDate);
		String phone=validateMobileNumber(phoneNo);
		Plan p=validatePlan(plan);
		double fees=p.getFees();
		String email1=validateEmail(email);
		Mess m= new Mess(id, firstName, lastName, email1, passsword, address, regDate,null, phone, p,fees);
		Map<Integer, Mess>ms=new HashMap<>();
		ms.put(m.getCustomerId(), m);
		LocalDate lastDate=lastDate(regDate, ms);
		m.setLastDate(lastDate);
		return m;
	}
}
