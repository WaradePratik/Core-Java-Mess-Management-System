package custom_exception;

public class InvalidPhoneNoException extends Exception {
	public InvalidPhoneNoException(String str) {
		super(str);
	}
}
