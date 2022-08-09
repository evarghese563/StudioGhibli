package com.Movie.Ghibli.Controller;

import java.util.List;

// import org.springframework.web.bind.annotation.CrossOrigin;
// import org.springframework.http.ResponseEntity;
// import org.springframework.stereotype.Controller;
// import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.PutMapping;
// import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.PostMapping;
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
    
    // @CrossOrigin(origins = "http://localhost:8080")
    @GetMapping
    public List<Ghibli> getGhiblis() {
        return gr.findAll();
    }

    @GetMapping("/{id}")
    public List<Ghibli> getGhibli(@PathVariable long id) {
        return gr.findById(id);
    }

    
    
    //Work on verification method of API

    // @GetMapping("/{id}")
    // public boolean ghibliExists(@PathVariable Long id){
    //     return gr.existsById(id);
    // }

    // @PutMapping("/{id}")
    // public ResponseEntity updateGhibli(@PathVariable int id, @RequestBody Ghibli ghibli){
    //     Ghibli currentGhibli = gr.findById(id).orElseThrow(RuntimeException::new);
    //     currentGhibli.setTitle(ghibli.getTitle());
    //     currentGhibli.setDirector(ghibli.getDirector());
    //     currentGhibli.setRelease_date(ghibli.getRelease_date());
    //     currentGhibli.setRunning_time(ghibli.getRunning_time());
    //     return ResponseEntity.ok(currentGhibli);
    // }
}




