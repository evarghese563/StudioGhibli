package com.Movie.Ghibli.Data;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.Movie.Ghibli.GhibObject.Ghibli;



public interface GhibliRepository extends CrudRepository<Ghibli, Long> {

    
    List<Ghibli> findById(long id);

    List<Ghibli> findAll();

   
}
