package org.example.springjpadata81.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "films")
@Getter
@Setter
public class Film {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private Double rating;

    private String genre;

    @Column(name="release_year")
    private Integer releaseYear;

    private Integer mpa;
}
