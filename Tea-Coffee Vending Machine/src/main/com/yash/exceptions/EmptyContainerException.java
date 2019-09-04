package main.com.yash.exceptions;

public class EmptyContainerException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public EmptyContainerException() {
		super("Container is empty");
	}

}
