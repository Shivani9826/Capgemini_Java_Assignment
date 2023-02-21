package javaassignment3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class MovieDetailsSortByName implements Comparator<MovieDetails> {
	@Override
	public int compare(MovieDetails movie1, MovieDetails movie2) {
		return movie1.getMovieName().compareTo(movie2.getMovieName());
	}
}

class MovieDetailsSortByActor implements Comparator<MovieDetails> {
	@Override
	public int compare(MovieDetails movie1, MovieDetails movie2) {
		return movie1.getActor().compareTo(movie2.getActor());
	}
}

class MovieDetailsSortByActress implements Comparator<MovieDetails> {
	@Override
	public int compare(MovieDetails movie1, MovieDetails movie2) {
		return movie1.getActress().compareTo(movie2.getActress());
	}
}

class MovieDetailsSortByGenre implements Comparator<MovieDetails> {
	@Override
	public int compare(MovieDetails movie1, MovieDetails movie2) {
		return movie1.getGenre().compareTo(movie2.getGenre());
	}
}

class MovieDetails {

	private String movieName;
	private String actor;
	private String actress;
	private String genre;

	public MovieDetails(String movieName, String actor, String actress, String genre) {
		super();
		this.movieName = movieName;
		this.actor = actor;
		this.actress = actress;
		this.genre = genre;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public String getActor() {
		return actor;
	}

	public void setActor(String actor) {
		this.actor = actor;
	}

	public String getActress() {
		return actress;
	}

	public void setActress(String actress) {
		this.actress = actress;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	@Override
	public String toString() {
		return "MovieDetails -> movieName: " + movieName + ", actor: " + actor + ", actress: " + actress + ", genre: "
				+ genre;
	}

}

class MovieDetailsList {

	ArrayList<MovieDetails> movieList = new ArrayList<>();

	public void sort(ArrayList<MovieDetails> movieDetails, String sortBy) {
		try {
			System.out.println("Sorted movies by " + sortBy);
			Collections.sort(movieList, sortAccordingly(sortBy));
		} catch (NullPointerException nullp) {
			System.out.println("There are no movies in the list.");
		}
	}

	public void printSortedMovieList(ArrayList<MovieDetails> movieDetails, String sortBy) {

		try {
			sort(movieList, sortBy);
			System.out.println("Printing movies sorted by " + sortBy + "\n");
			for (MovieDetails movies : movieList) {
				System.out.println(movies);
			}
		} catch (NullPointerException nullp) {
			System.out.println("Movie Details List is empty \n");
		}
	}

	public void addMovie(MovieDetails movie) {
		movieList.add(movie);
		System.out.println("Movie " + movie.getMovieName() + " added successfully.");
	}

	public void removeMovies(String movieName) {
		boolean isRemoved = false;
		MovieDetails movieToRemove = null;
		for (MovieDetails details : movieList) {
			if (details.getMovieName().equals(movieName)) {
				movieToRemove = details;
				isRemoved = true;

			}
		}
		if (isRemoved) {
			movieList.remove(movieToRemove);
			System.out.println("Removed movie: " + movieName);
		}
		if (isRemoved == false) {
			System.out.println("There is no such movie in the list");
		}

	}

	public void removeAllMovies(List<MovieDetails> movies) {
		try {
			movieList.removeAll(movies);
			System.out.println("Removed all movies mentioned in the list.");
			if (movieList.size() == 0) {
				movieList = null;
			}
		} catch (NullPointerException nullp) {
			System.out.println("There are no movies in the list.");
		}
	}

	public MovieDetails find_movie_By_mov_Name(String movieName) {
		try {
			for (MovieDetails movieDetails : movieList) {
				if (movieDetails.getMovieName().equals(movieName)) {
					return movieDetails;
				}
			}
		} catch (NullPointerException nullp) {
			System.out.println("There are no movies in the list.");
		}
		return null;
	}

	public List<MovieDetails> find_movie_By_Genre(String genre) {
		List<MovieDetails> movieByGenre = new ArrayList<MovieDetails>();
		try {
			for (MovieDetails movies : movieList) {
				if (movies.getGenre().equals(genre)) {
					movieByGenre.add(movies);
				}
			}
		} catch (NullPointerException nullp) {
			System.out.println("There are no movies in the list.");
		}
		return movieByGenre;
	}

	public static Comparator<MovieDetails> sortAccordingly(String sortBy) {

		Comparator<MovieDetails> comp;

		switch (sortBy) {
		case "movie name":
			comp = new MovieDetailsSortByName();
			return comp;

		case "actor":
			comp = new MovieDetailsSortByActor();
			return comp;

		case "actress":
			comp = new MovieDetailsSortByActress();
			return comp;

		case "genre":
			comp = new MovieDetailsSortByGenre();
			return comp;

		default:
			System.out.println("This option is not valid.");
			return null;
		}

	}

}

public class Assignment3Q10 {

	public static void main(String[] args) {

		MovieDetails movieDetails1 = new MovieDetails("Halo", "John Dalton", "Anne Marie", "Action");
		MovieDetails movieDetails2 = new MovieDetails("Abstract", "Abhijeet Singh", "Kristen Montana", "Adventure");
		MovieDetails movieDetails3 = new MovieDetails("Dream come true", "Ayush Patel", "Sunidhi Singh", "Drama");
		MovieDetails movieDetails4 = new MovieDetails("Sindh", "Kartik Singh", "Sakshi Chauhan", "Action");
		MovieDetails movieDetails5 = new MovieDetails("Phantom", "Aman Sharma", "Kriti singh", "Action");

		MovieDetailsList detailsList = new MovieDetailsList();
		detailsList.addMovie(movieDetails1);
		detailsList.addMovie(movieDetails2);
		detailsList.addMovie(movieDetails3);
		detailsList.addMovie(movieDetails4);
		detailsList.addMovie(movieDetails5);

		System.out.println("\nFinding movie by movie name:");
		MovieDetails movieDetail = detailsList.find_movie_By_mov_Name("Phantom");
		System.out.println(movieDetail);

		System.out.println("\nFinding movies by genre:");
		List<MovieDetails> movieDetailsByGenre = detailsList.find_movie_By_Genre("Action");
		for (MovieDetails details : movieDetailsByGenre) {
			System.out.println(details);
		}

		detailsList.printSortedMovieList(detailsList.movieList, "movie name");
		detailsList.removeMovies(movieDetails1.getMovieName());
		detailsList.printSortedMovieList(detailsList.movieList, "movie name");

		detailsList.removeAllMovies(detailsList.movieList);
		detailsList.printSortedMovieList(detailsList.movieList, "actor");

	}

}
