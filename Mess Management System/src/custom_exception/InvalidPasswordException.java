package custom_exception;

public class InvalidPasswordException extends Exception {
	public InvalidPasswordException(String str) {
		super(str);
	}
}
