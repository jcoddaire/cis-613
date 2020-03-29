import java.util.*;

public class MovieList {

	private List<IMovie> movies = new ArrayList<IMovie>();
	private List<IMovieListObserver> listeners = new ArrayList<IMovieListObserver>();

	public void addListener(IMovieListObserver listener) {
		if (!listeners.contains(listener)) {
			listeners.add(listener);
		}
	}

	public void addMovie(IMovie movie) throws DuplicateMovieException {
		if (movie == null) {
			return;
		}
		if (movies.contains(movie)) {
			throw new DuplicateMovieException("Movie is already in the list");
		}
		movies.add(movie);
		notifyListenersMovieAdded(movie);
	}

	public boolean removeMovie(IMovie movie) {
		if (movie == null || !movies.contains(movie)) {
			return false;
		}
		movies.remove(movie);
		notifyListenersMovieRemoved(movie);
		return true;
	}

	public int size() {
		return movies.size();
	}

	public boolean contains(IMovie movie) {
		return movies.contains(movie);
	}

	public Iterator<IMovie> iterator() {
		return movies.iterator();
	}

	private void notifyListenersMovieAdded(IMovie movie) {
		for (IMovieListObserver listener : listeners) {
			listener.movieAdded(movie);
		}
	}

	private void notifyListenersMovieRemoved(IMovie movie) {
		for (IMovieListObserver listener : listeners) {
			listener.movieRemoved(movie);
		}
	}
}
