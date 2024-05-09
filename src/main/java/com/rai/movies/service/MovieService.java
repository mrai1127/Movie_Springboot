package com.rai.movies.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.stereotype.Service;

import com.rai.movies.model.Movie;
import com.rai.movies.repository.MovieRepository;
import com.rai.movies.service.MovieService.MovieNotFoundException;

@Service
public class MovieService {

	@Autowired
	private MovieRepository movieRepository;

	public Movie saveMovie(Movie movie) {
		movieRepository.save(movie);
		return movie;
	}

	public List<Movie> allMovies() {
		return movieRepository.findAll();
	}

	public Movie findById(Movie movie, int movieId) throws MovieNotFoundException{
		Movie existingMovie = movieRepository.findById(movieId)
				.orElseThrow(() -> new MovieNotFoundException(movieId));
		existingMovie.setImbdbId(movie.getImbdbId());
		existingMovie.setPoster(movie.getPoster());
		existingMovie.setRealeseDate(movie.getRealeseDate());
		existingMovie.setTitle(movie.getTitle());
		existingMovie.setTrailerLink(movie.getTrailerLink());

		movieRepository.save(existingMovie);
		return existingMovie;
	}

	public static class MovieNotFoundException extends Exception {
		public MovieNotFoundException(int movieId) {
			super("movie not found with id: " + movieId);
		}
	}

	public void deleteMovie(int movieId) throws MovieNotFoundException {
		movieRepository.findById(movieId).orElseThrow(() -> new MovieNotFoundException(movieId));
		movieRepository.deleteById(movieId);
		
	}
}
