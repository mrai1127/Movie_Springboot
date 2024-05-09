package com.rai.movies.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rai.movies.model.Movie;
import com.rai.movies.service.MovieService;
import com.rai.movies.service.MovieService.MovieNotFoundException;

@RestController
@RequestMapping("/api/movie")
public class MovieController {

	@Autowired
	private MovieService movieService;

	@PostMapping("/")
	public String saveMovie(@RequestBody Movie movie) {
		movieService.saveMovie(movie);
		return "movie has been save";

	}

	@GetMapping
	public ResponseEntity<List<Movie>> getAllMovie() {
		return new ResponseEntity<List<Movie>>(movieService.allMovies(), HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Movie> updateMovie(@RequestBody Movie movie, @PathVariable("id") int movieId) throws MovieNotFoundException {
		return new ResponseEntity<Movie>(movieService.findById(movie, movieId), HttpStatus.OK);
	}	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteMovie(@PathVariable("id") int movieId) throws MovieNotFoundException{
		movieService.deleteMovie(movieId);
		return new ResponseEntity<String>("Movie has been deleted", HttpStatus.OK);
	}
}
