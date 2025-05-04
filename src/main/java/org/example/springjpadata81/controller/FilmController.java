package org.example.springjpadata81.controller;

import lombok.RequiredArgsConstructor;
import org.example.springjpadata81.model.Film;
import org.example.springjpadata81.repository.FilmRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/films")
public class FilmController {
    private final FilmRepository filmRepository;

    @GetMapping("/search")
    public List<Film> findByName(@RequestParam String name, @RequestParam int mpa){
        return filmRepository.findFilmsByTitleAndMpa(name, mpa);
    }

    @GetMapping("/find-in-range")
    public List<Film> findByRating(@RequestParam(required = false) double min, @RequestParam double max){
        return filmRepository.findByRatingBetween(min, max);
    }
}
