package com.Movie.Ghibli.Controller;

import java.util.List;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Movie.Ghibli.Data.GhibliRepository;
import com.Movie.Ghibli.GhibObject.Ghibli;


@RestController

@RequestMapping("/ghiblis")
public class RController {

    GhibliRepository gr;

    RController(GhibliRepository ghibliRepository){
        this.gr = ghibliRepository;
    }
    

    @GetMapping
    public List<Ghibli> getGhiblis() {
        return gr.findAll();
    }

    @GetMapping("/{id}")
    public List<Ghibli> getGhibli(@PathVariable long id) {
        return gr.findById(id);
    }


}




