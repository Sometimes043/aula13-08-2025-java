package com.playstore.webplaystore.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.playstore.webplaystore.entities.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {}
