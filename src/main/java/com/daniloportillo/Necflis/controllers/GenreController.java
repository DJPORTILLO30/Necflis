package com.daniloportillo.Necflis.controllers;

import com.daniloportillo.Necflis.entities.Genre;
import com.daniloportillo.Necflis.repositories.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Date;
import java.util.Optional;

@RestController
@RequestMapping(value = "/generos")
public class GenreController {


    @Autowired
    GenreRepository genreRepository;


    @GetMapping
    @ResponseStatus(code = HttpStatus.OK)
    public Collection<Genre> getAllGenres(){
        Iterable<Genre> genres = genreRepository.findAll();
        return (Collection<Genre>) genres;
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public Genre createGenre(@RequestBody Genre genre , @DateTimeFormat(pattern = "yyyy.MM.ddd") Date date){
        Genre newGenre  = genreRepository.save(genre);
        return newGenre;
    }


    @GetMapping(value = "/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public Genre getGenre(@PathVariable(name = "id") Long id){
        Optional<Genre> genre = genreRepository.findById(id);
        Genre result = null;
        if(genre.isPresent()){
            result = genre.get();
        }
        return result;
    }


    @DeleteMapping(value = "/{id}")
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    public void deleteGenre(@PathVariable(name = "id") Long id){

        genreRepository.deleteById(id);
    }

    @PutMapping(value = "/{id}")
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    public Genre changeGenre(@PathVariable(name = "id") Long id , @RequestBody Genre genre){
        Optional<Genre> data = genreRepository.findById(id);
        if(data.isPresent()){
            Genre actual = data.get();
            actual.setIdGenre(id);
            actual.setName(genre.getName());
            actual.setDescription(genre.getDescription());
            actual.setDateCreated(genre.getDateCreated());
            Genre changedGenre = genreRepository.save(actual);
            return changedGenre;
        }
        return null;
    }

}
