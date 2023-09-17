package com.driver;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

@Repository
public class MovieRepository {
    private Map<String,Movie> movieMap = new HashMap<>();
    private Map<String,Director> directorMap = new HashMap<>();
    private HashMap<String, List<Movie>> directorMovieMapg = new HashMap<>();
    public void addMovie(Movie movie) {
        movieMap.put(movie.getName(),movie);
    }

    public void addDirector(Director director) {
        directorMap.put(director.getName(), director);
    }

    public void addMovieDirectorPair(String movie, String director) {
      Movie movie1 = movieMap.get(movie);
      if(movie1!=null && directorMap.containsKey(director)){
          List<Movie> movieList = directorMovieMapg.getOrDefault(director,new ArrayList<>());
          movieList.add(movie1);
          directorMovieMapg.put(director,movieList);
      }
    }

    public Movie getMovieByName(String name) {
        return movieMap.get(name);
    }

    public Director getDirectorByName(String name) {
        return directorMap.get(name);
    }

    public List getMoviesByDirectorName(String director) {
        List<String> movieName = new ArrayList<>();
        if (directorMovieMapg.containsKey(director)){
            List<Movie> movieList = directorMovieMapg.get(director);
            for (Movie m : movieList){
                movieName.add(m.getName());
            }
        }
        return movieName;
    }

    public List findAllMovies() {
        return new ArrayList(movieMap.keySet());
    }

    public void deleteDirectorByName(String director) {
        if(directorMovieMapg.containsKey(director)){
            List<Movie> movieList = directorMovieMapg.get(director);
            for (Movie m : movieList){
                String n = m.getName();
                movieMap.remove(n);
            }
        }
        directorMovieMapg.remove(director);
        directorMap.remove(director);
    }

    public void deleteAllDirectors() {
        for (List<Movie> movieList : directorMovieMapg.values()){
            for (Movie movie : movieList){
                String movieName = movie.getName();
                movieMap.remove(movieName);
            }
        }
        directorMovieMapg.clear();
        directorMap.clear();
    }
}
