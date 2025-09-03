package com.playstore.webplaystore.resources;

import com.playstore.webplaystore.entities.Categoria;
import com.playstore.webplaystore.repositories.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categorias")
public class CategoriaResource {

    @Autowired
    private CategoriaRepository repository;

    @GetMapping
    public ResponseEntity<List<Categoria>> findAll() {
        List<Categoria> list = repository.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Categoria> findById(@PathVariable Long id) {
        Categoria obj = repository.findById(id).orElse(null);
        if (obj == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping
    public ResponseEntity<Categoria> insert(@RequestBody Categoria obj) {
        Categoria saved = repository.save(obj);
        return ResponseEntity.ok().body(saved);
    }
}
