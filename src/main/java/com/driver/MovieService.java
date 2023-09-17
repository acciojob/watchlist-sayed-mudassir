package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {
    @Autowired
    MovieRepository movieRepository;
    public String addMovie(Movie movie) {
        movieRepository.addMovie(movie);
        return "success";

    }

    public String addDirector(Director director) {
        movieRepository.addDirector(director);
        return "success";
    }

    public String addMovieDirectorPair(String movie, String director) {
        movieRepository.addMovieDirectorPair(movie,director);
        return "success";
    }

    public Movie getMovieByName(String name) {
        return movieRepository.getMovieByName(name);
    }

    public Director getDirectorByName(String name) {
        return movieRepository.getDirectorByName(name);
    }

    public List getMoviesByDirectorName(String director) {
        return movieRepository.getMoviesByDirectorName(director);
    }

    public List findAllMovies() {
        return movieRepository.findAllMovies();
    }

    public String deleteDirectorByName(String director) {
        movieRepository.deleteDirectorByName(director);
        return "success";
    }

    public String deleteAllDirectors() {
         movieRepository.deleteAllDirectors();
         return "success";

    }
}
