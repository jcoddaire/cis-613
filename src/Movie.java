public class Movie implements IMovie {

	private String name;
	private int rating;
	private Category category;

	public Movie(String name, int rating, Category category) {
		this.name = name;
		this.rating = rating;
		if (rating < 0) {
			this.rating = 0;
		}
		this.category = category;
	}

	public Category getCategory() {
		return category;
	}

	public String getName() {
		return name;
	}

	public int getRating() {
		return rating;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == this) {
			return true;
		}
		if (!(obj instanceof Movie)) {
			return false;
		}
		Movie m = (Movie) obj;
		return this.name.equals(m.getName()) && this.rating == m.getRating()
					&& this.category.equals(m.getCategory());
	}
	
	@Override
	public int hashCode() {
		int result = 17;
		result = 31 * result + rating;
		result = 31 * result + name.hashCode();
		result = 31 * result + category.hashCode();
		return result;
	}

}
