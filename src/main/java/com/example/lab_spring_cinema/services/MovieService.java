package com.example.lab_spring_cinema.services;

import com.example.lab_spring_cinema.models.Movie;
import com.example.lab_spring_cinema.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {

    @Autowired
    MovieRepository movieRepository;

    public List<Movie> getAllMovies(){
        return movieRepository.findAll();
    }

    public void addMovie(String title, double rating, int duration) {
        Movie movie = new Movie(title, rating, duration);
        movieRepository.save(movie);
    }

    public List<Movie> getAllMovies(int maxDuration) {
        List<Movie> movies = getAllMovies();
        movies.removeIf(movie -> movie.getDuration() > maxDuration);
        return movies;
    }

    public Optional<Movie> getMovieById(int id) {
        return movieRepository.findById(id);
    }

//    Extension 1
    public void updateMovieById(int id, String title, double rating, int duration){

    Movie movie = movieRepository.findById(id).get();

    movie.setTitle(title);
    movie.setRating(rating);
    movie.setDuration(duration);

    movieRepository.save(movie);
}

//    Extension 2
    public void deleteMovieById(int id){
        movieRepository.deleteById(id);
    }
}
