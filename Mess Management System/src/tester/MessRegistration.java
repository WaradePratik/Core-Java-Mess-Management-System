package tester;

import static utils.ValidationRules.*;
import static utils.PopulateMess.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import static utils.serialization.storeCustomerDetails;
import static utils.deserealization.restoreCustomerDetails;
import com.mess.Mess;
import com.mess.Plan;
import utils.SortByEmail;
import utils.serialization;

import static utils.PopulateMess.populateMess;

public class MessRegistration {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			Map<Integer, Mess> map = new HashMap<>();
			boolean exit = false;
			while (exit != true) {
				try {
					System.out.println(
							"0. Exit\n 1. Register\n 2. Display\n 3. Sign In\n 4. Change Password\n 5. Sort\n 6. Set Name\n "
									+ "7. Month Sort\n 8. Count\n 9. Address\n 10. Discount\n 11. Remove\n 12. Serealization\n 13. Desearializtion\n");
					System.out.println("Enter choice");
					switch (sc.nextInt()) {
					case 1:
						System.out.println(
								"Enter customerId, firstName, lastName, email, passsword,  address, registerDate, phoeNo, plan");
						Mess m = validateAll(sc.nextInt(), sc.next(), sc.next(), sc.next(), sc.next(), sc.next(),
								sc.next(), sc.next(), sc.next(), map);
						List<Mess> mList = populateMess();
						for (Mess p : mList) {
							map.put(p.getCustomerId(), p);
						}

						System.out.println("Registration successful!!!");
						break;
					case 2:
						for (Mess mess : map.values()) {
							System.out.println(mess);
						}
						break;
					case 3:
						System.out.println("Enter Email Password");
						validateSignIn(sc.next(), sc.next(), map);
						break;
					case 4:
						System.out.println("Enter Email Password NewPassword");
						cahngePassword(sc.next(), sc.next(), sc.next(), map);
						break;
					case 5:
//						Comparator<Mess>comp=(m1,m2)->{
//							return (m1.getFirstName().compareTo(m2.getFirstName()));
//						};
//						map.values()
//						.stream()
//						.sorted(comp)
//						.forEach(p->System.out.println(p));
						List<Mess> list = new ArrayList<>();
						for (Mess m1 : map.values()) {
							list.add(m1);
						}
						Collections.sort(list, new SortByEmail());
						list.forEach(p -> System.out.println(p));
						break;
					case 6:
//						map.values()
//						.stream()
//						.map(p->p.getFirstName().substring(0, 1).toUpperCase()+p.getFirstName().substring(1))
//						.forEach(p->System.out.println(p));
						map.values().forEach(p -> {
							p.setFirstName(
									p.getFirstName().substring(0, 1).toUpperCase() + p.getFirstName().substring(1));
						});
						System.out.println("Name modified successfuly");
						break;
					case 7:
						map.values().forEach(p -> {
							if (p.getRegisterDate().getMonthValue() == 1) {
								System.out.println(p.getEmail());
							}
						});
						break;
					case 8:
						int count = 0;
						for (Mess mess : map.values()) {
							if (mess.getPlan() == Plan.valueOf("MONTHLY")) {
								count++;
							}
						}
						System.out.println("Total Count= " + count);
						break;
					case 9:
						map.values().forEach(p -> {
							if (p.getAddress().equals("akurdi")) {
								System.out.println(p);
							}
						});
						break;
					case 10:
						for (Mess m1 : map.values()) {
							if (m1.getPlan() == Plan.valueOf("YEAR")) {
								m1.setFees(m1.getFees() - (m1.getFees()) / 5);
							}
						}
						System.out.println("Discount Applied");
						break;
					case 11:
						System.out.println("Enter Id to be Deleted");
						removeCustomer(sc.nextInt(), map);
						System.out.println("Customer removed successfuly");
						break;
					case 12:
						System.out.println("Enter the File Name");
						storeCustomerDetails(map, sc.next());
						System.out.println("Details Store Successfully!!!!");
						break;
					case 13:
						System.out.println("Enter file name");
						Map<Integer, Mess> map1 = restoreCustomerDetails(sc.next());
						map1.values().forEach(p -> System.out.println(p));
						break;
					}

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}

}
