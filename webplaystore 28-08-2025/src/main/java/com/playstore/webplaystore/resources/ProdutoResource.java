package com.playstore.webplaystore.resources;

import com.playstore.webplaystore.entities.Produto;
import com.playstore.webplaystore.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoResource {

    @Autowired
    private ProdutoRepository repository;

    @GetMapping
    public ResponseEntity<List<Produto>> findAll() {
        List<Produto> list = repository.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Produto> findById(@PathVariable Long id) {
        Produto obj = repository.findById(id).orElse(null);
        if (obj == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping
    public ResponseEntity<Produto> insert(@RequestBody Produto obj) {
        Produto saved = repository.save(obj);
        return ResponseEntity.ok().body(saved);
    }
}
