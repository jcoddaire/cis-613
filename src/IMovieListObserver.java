public interface IMovieListObserver {
	
	// A listener/observer object that implements this interface is notified
	// whenever a movie is added to a MovieList object. This notification is done
	// via a call to the movieAdded() implemented in the listener object.
	void movieAdded(IMovie movie);

	// A listener/observer object that implements this interface is notified
	// whenever a movie is removed from a MovieList object. This notification is done
	// via a call to the movieRemoved() implemented in the listener object.
	void movieRemoved(IMovie movie);
	
}
