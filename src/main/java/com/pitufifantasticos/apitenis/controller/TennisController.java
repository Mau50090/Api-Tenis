package com.pitufifantasticos.apitenis.controller;

import com.pitufifantasticos.apitenis.entity.Tennis;
import com.pitufifantasticos.apitenis.service.TennisService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/tennis")

public class TennisController {
    
    @Autowired
    private TennisService tennisService;

    @PostMapping
    public ResponseEntity<?> create (@RequestBody Tennis tennis){
        
        return ResponseEntity.status(HttpStatus.CREATED).body(tennisService.save(tennis));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> read (@PathVariable Long id){

        Optional<Tennis> oTennis = tennisService.findById(id);

        if(!oTennis.isPresent()){
            return ResponseEntity.notFound().build();
        }else{
            return ResponseEntity.ok(oTennis);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update (@RequestBody Tennis tennisDetails, @PathVariable Long id){

        Optional<Tennis> tennis = tennisService.findById(id);
        
        if(!tennis.isPresent()){
            return ResponseEntity.notFound().build();
        }

        tennis.get().setColor(tennisDetails.getColor());
        tennis.get().setMarca(tennisDetails.getMarca());
        tennis.get().setNombre(tennisDetails.getNombre());
        tennis.get().setTalla(tennisDetails.getTalla());

        return ResponseEntity.status(HttpStatus.CREATED).body(tennisService.save(tennis.get()));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete (@PathVariable Long id){

        if(!tennisService.findById(id).isPresent()){
            return ResponseEntity.notFound().build();
        }

        tennisService.deleteById(id);

        return ResponseEntity.ok().build();
    }

    @GetMapping
    public List<Tennis> readAll(){
        List<Tennis> tennis = StreamSupport.stream(tennisService.fundAll().spliterator(), false).collect(Collectors.toList());

        return tennis;
    }
}
