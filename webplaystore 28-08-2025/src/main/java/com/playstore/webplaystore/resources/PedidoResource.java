package com.playstore.webplaystore.resources;

import com.playstore.webplaystore.entities.Pedido;
import com.playstore.webplaystore.repositories.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pedidos")
public class PedidoResource {

    @Autowired
    private PedidoRepository repository;

    @GetMapping
    public ResponseEntity<List<Pedido>> findAll() {
        List<Pedido> list = repository.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pedido> findById(@PathVariable Long id) {
        Pedido obj = repository.findById(id).orElse(null);
        if (obj == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping
    public ResponseEntity<Pedido> insert(@RequestBody Pedido obj) {
        Pedido saved = repository.save(obj);
        return ResponseEntity.ok().body(saved);
    }

    @GetMapping("/{id}/total")
    public ResponseEntity<Double> getTotal(@PathVariable Long id) {
        Pedido obj = repository.findById(id).orElse(null);
        if (obj == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok().body(obj.totalDaCompra());
    }
}
