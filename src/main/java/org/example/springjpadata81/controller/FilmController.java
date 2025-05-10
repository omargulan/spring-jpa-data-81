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
    public List<Film> findByParam(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) Integer mpa,
            @RequestParam(required = false) Double min,
            @RequestParam(required = false) Double max,
            @RequestParam(required = false) String genre){
        return filmRepository.search(name, mpa, min, max, genre);
    }

//    @GetMapping("/find-in-range")
//    public List<Film> findByRating(){
//        return filmRepository.findByRatingBetween(min, max);
//    }
}
