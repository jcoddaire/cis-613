public interface IMovie {
	
	// returns movie name
	String getName();

	// returns movie rating
	int getRating(); // 0 - 5; 0 -> not rated

	// returns movie category
	Category getCategory();
}
