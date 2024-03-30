package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Map;

import com.mess.Mess;

public interface deserealization {
	public static Map<Integer, Mess> restoreCustomerDetails(String fileName) throws ClassNotFoundException, IOException{
		try(ObjectInputStream in =new ObjectInputStream(new FileInputStream(fileName))){
			return (Map<Integer, Mess>)in.readObject();
		}
	}
}
