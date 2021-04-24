package com.daniloportillo.Necflis.repositories;

import com.daniloportillo.Necflis.entities.Genre;
import org.springframework.data.repository.CrudRepository;

public interface GenreRepository extends CrudRepository<Genre,Long> {
}
