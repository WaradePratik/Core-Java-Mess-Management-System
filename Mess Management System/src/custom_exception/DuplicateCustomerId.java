package custom_exception;

public class DuplicateCustomerId extends Exception {
	public DuplicateCustomerId(String str) {
		super(str);
	}
}
