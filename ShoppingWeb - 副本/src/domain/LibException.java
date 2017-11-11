package domain;

public class LibException extends RuntimeException {

	/**
	 *   ��Ŀ�쳣������
	 */
	private static final long serialVersionUID = 4090017827735417152L;

	public LibException() {
		super();
	
	}

	public LibException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	
	}

	public LibException(String message, Throwable cause) {
		super(message, cause);

	}

	public LibException(String message) {
		super(message);
		
	}

	public LibException(Throwable cause) {
		super(cause);
	
	}
		
}
