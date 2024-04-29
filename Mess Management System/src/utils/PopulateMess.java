package utils;
import com.mess.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import static utils.ValidationRules.*;
public class PopulateMess {
	public static List<Mess> populateMess() {
		List<Mess>mess=new ArrayList<>();
		/**
		 * int customerId, String firstName, String lastName, String email, String passsword, String address,
			LocalDate registerDate,LocalDate lastDate, String phoeNo, Plan plan,double fees
		 */
		mess.add(new Mess(111, "sandesh", "patil", "sandesh.dac@iacsd.com", "pass", "akurdi", LocalDate.parse("2023-12-09"),LocalDate.parse("2024-12-09") , "8551913732", Plan.valueOf("YEAR"), 32000));
		mess.add(new Mess(112, "tanmay", "navale", "tanmay.dac@iacsd.com", "pass1", "akurdi", LocalDate.parse("2023-12-09"),LocalDate.parse("2024-12-09") , "8576913732", Plan.valueOf("HALFYEAR"), Plan.HALFYEAR.getFees()));
		mess.add(new Mess(113, "pratik", "warade", "pratik.dac@iacsd.com", "pass12", "akurdi", LocalDate.parse("2024-02-09"),LocalDate.parse("2024-12-09") , "8551910932", Plan.QUARTERLY, Plan.QUARTERLY.getFees()));
		mess.add(new Mess(114, "arjun", "bharara", "arjun.dac@iacsd.com", "pass123", "akurdi", LocalDate.parse("2023-12-09"),LocalDate.parse("2024-12-09") , "9151913732", Plan.MONTHLY, Plan.MONTHLY.getFees()));
		return mess;
	}
}
