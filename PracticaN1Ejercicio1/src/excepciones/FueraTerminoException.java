package excepciones;

public class FueraTerminoException extends Exception {

	private static final long serialVersionUID = 1L;

	public FueraTerminoException(String message) {
		super(message);
	}
}
