package utils;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Map;

import com.mess.Mess;

public interface serialization {
	public static void storeCustomerDetails(Map<Integer, Mess>map,String messEntry) throws IOException{
		try(ObjectOutputStream out=new ObjectOutputStream(new FileOutputStream(messEntry))){
			out.writeObject(map);
		}
	}
}
