
public class DataFormatException extends Exception  {

	/**
	 * Constructs a <code>DataFormatException</code> with no detail
	 * message.
	 */
	public DataFormatException() {

	}

	/**
	 * Constructs a <code>DataFormatException</code> with the
	 * specified detail message.
	 *
	 * @param message  the malformed data
	 */
	public DataFormatException(String message) {

		super(message);
	}
}
