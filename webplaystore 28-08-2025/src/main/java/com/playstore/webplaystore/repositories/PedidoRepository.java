package com.playstore.webplaystore.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.playstore.webplaystore.entities.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {}
