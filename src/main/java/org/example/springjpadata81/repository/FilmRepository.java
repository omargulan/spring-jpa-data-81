package org.example.springjpadata81.repository;

import org.example.springjpadata81.model.Film;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FilmRepository  extends JpaRepository<Film, Long> {
    //List<Film> findFilmsByTitleAndMpa(String title, Integer mpa);
    List<Film> findFilmsByTitleAndMpa(String title, Integer mpa);

    List<Film> findByRatingBetween(double ratingAfter, double ratingBefore);

    @Query("""
            select f from Film f
            where (:title is null or lower(f.title) like lower(concat('%', :title, '%')))
             and (:mpa is null or f.mpa = :mpa)
             and (:minRating is null  or f.rating >= :minRating)
             and (:maxRating is null or f.rating <=:maxRating)
             and (:genre is null or f.genre = :genre)""")
    List<Film> search(String title, Integer mpa, Double minRating, Double maxRating, String genre);


}
