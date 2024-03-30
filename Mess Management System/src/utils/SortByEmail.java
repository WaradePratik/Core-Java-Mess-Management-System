package utils;

import java.util.Comparator;

import com.mess.Mess;

public class SortByEmail implements Comparator<Mess>{

	@Override
	public int compare(Mess o1, Mess o2) {
		return o1.getEmail().compareTo(o2.getEmail());
	}

}
