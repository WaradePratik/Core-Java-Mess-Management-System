package custom_exception;

public class InvalidDateException extends Exception {
	public InvalidDateException(String str) {
		super(str);
	}
}
