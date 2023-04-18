package com.example.lab_spring_cinema.repositories;

import com.example.lab_spring_cinema.models.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository  extends JpaRepository<Movie, Integer> {
}
