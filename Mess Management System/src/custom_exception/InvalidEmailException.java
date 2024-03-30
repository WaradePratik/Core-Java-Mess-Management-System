package custom_exception;

public class InvalidEmailException extends Exception {
	public InvalidEmailException(String str) {
		super(str);
	}
}
