@SuppressWarnings("serial")
public class DuplicateMovieException extends Exception {

	public DuplicateMovieException() {
	}
	
	public DuplicateMovieException(String msg) {
		super(msg);
	}
}
