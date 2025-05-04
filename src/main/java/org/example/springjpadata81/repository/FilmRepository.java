package org.example.springjpadata81.repository;

import org.example.springjpadata81.model.Film;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FilmRepository  extends JpaRepository<Film, Long> {
    List<Film> findFilmsByTitleAndMpa(String title, int mpa);

    List<Film> findByRatingBetween(double ratingAfter, double ratingBefore);


}
