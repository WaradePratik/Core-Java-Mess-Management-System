package custom_exception;

public class IdNotFoundException extends Exception {
	public IdNotFoundException(String str) {
		super(str);
	}
}
