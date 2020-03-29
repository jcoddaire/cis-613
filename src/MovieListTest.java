import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.easymock.EasyMock.*;

/*
IMPORTANT: Mock Object Usage Pattern with EasyMock:
Step 1: Create instance(s) of mock object(s) needed
Step 2: Set state and record expectations in the mock objects
		(mock is said to be in "Record" mode now)
Step 3: Tell mock(s) that we are beginning the actual testing
		(mock is said to be in "Replay" mode now)
Step 4: Associate mock object(s) with unit under test
		(as parameters to constructor, setter, or other methods);
Step 5: Test - set preconditions and exercise the unit under test
Step 6: Verify expectations in the mock objects
		(verifies everything that was supposed to be called on mock(s) was called)
Step 7: Assert postconditions of the test
*/

public class MovieListTest {

	private MovieList movies;
	private IMovieListObserver mockObserver;

	@BeforeEach
	public void setUp() {
		// Step 1
		mockObserver = mock(IMovieListObserver.class);
		// Portion of Step 5
		movies = new MovieList();
		// Step 4
		movies.addListener(mockObserver);
	}

	// Test for adding one Movie object to "movies"
	// 		IMovie movie = new Movie("Lion King", 4, Category.ANIMATION);
	@Test
	public void testAddMovie() {
		IMovie movie = new Movie("Lion King", 4, Category.ANIMATION);
		
		// Step 2 - TO DO
		mockObserver.movieAdded((movie));
		expectLastCall();

		// Step 3
		replay(mockObserver);
		
		try {
			// Steps 5 and 7
			movies.addMovie(movie);
			assertTrue(movies.contains(movie));
			assertEquals(1, movies.size());
		} catch (DuplicateMovieException ex) {}
		
		// Step 6
		verify(mockObserver);
	}

	// Test for adding same Movie object to "movies" twice
	// 		IMovie movie = new Movie("Lion King", 4, Category.ANIMATION);
	@Test
	public void testAddDuplicateMovie() {
		IMovie movie = new Movie("Lion King", 4, Category.ANIMATION);
		
		// Step 2 - TO DO
		mockObserver.movieAdded((movie));
		expectLastCall();
		
		// Step 3
		replay(mockObserver);
		
		try {
			// Step 5
			movies.addMovie(movie);
			movies.addMovie(movie);
		} catch (DuplicateMovieException ex) {
			// Step 7
			assertTrue(movies.contains(movie));
			assertEquals(1, movies.size());
		}
		
		// Step 6
		verify(mockObserver);
	}

	// Test for adding null object to "movies"
	@Test
	public void testAddNullMovie() {
		// Step 3
		replay(mockObserver);
		
		try {
			// Steps 5 and 7 - TO DO
			IMovie movie = null;
			movies.addMovie(movie);

			assertFalse(movies.contains(movie));
			assertEquals(0, movies.size());

		} catch (DuplicateMovieException ex) {}
		
		// Step 6
		verify(mockObserver);
	}

	// Test for adding one Movie object to "movies" object and then removing it immediately
	// 		IMovie movie = new Movie("Lion King", 4, Category.ANIMATION);
	@Test
	public void testRemoveMovie() {
		IMovie movie = new Movie("Lion King", 4, Category.ANIMATION);
		checkOrder(mockObserver, true);
		
		// Step 2 - TO DO

		mockObserver.movieAdded((movie));
		mockObserver.movieRemoved((movie));
		expectLastCall();

		// Step 3
		replay(mockObserver);
		
		try {
			// Steps 5 and 7
			movies.addMovie(movie);
			assertTrue(movies.removeMovie(movie));
			assertFalse(movies.contains(movie));
			assertEquals(0, movies.size());
		} catch (DuplicateMovieException ex) {}
		
		// Step 6
		verify(mockObserver);
	}

	// Test for removing a non-existing movie from "movies"
	// 		IMovie movie = new Movie("Lion King", 4, Category.ANIMATION);
	@Test
	public void testNonExistingMovie() {
		IMovie movie = new Movie("Lion King", 4, Category.ANIMATION);
		
		// Step 3
		replay(mockObserver);
		
		// Steps 5 and 7 - TO DO
		assertFalse(movies.contains(movie));
		
		// Step 6
		verify(mockObserver);
	}

	// Test for removing null object from "movies"
	@Test
	public void testRemoveNullMovie() {
		IMovie movie = null;
		
		// Step 3
		replay(mockObserver);
		
		// Steps 5 and 7 - TO DO
		assertFalse(movies.removeMovie(movie));
		
		// Step 6
		verify(mockObserver);
	}
}
