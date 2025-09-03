package com.playstore.webplaystore.entities;

import jakarta.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dataCompra;
    private String statusDaCompra;

    @ManyToMany
    @JoinTable(
        name = "pedido_produto",
        joinColumns = @JoinColumn(name = "pedido_id"),
        inverseJoinColumns = @JoinColumn(name = "produto_id")
    )
    private List<Produto> produtos;

    public Pedido() {}

    public Pedido(Long id, Date dataCompra, String statusDaCompra, List<Produto> produtos) {
        this.id = id;
        this.dataCompra = dataCompra;
        this.statusDaCompra = statusDaCompra;
        this.produtos = produtos;
    }

    public Double totalDaCompra() {
        return produtos.stream().mapToDouble(Produto::getPreco).sum();
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Date getDataCompra() { return dataCompra; }
    public void setDataCompra(Date dataCompra) { this.dataCompra = dataCompra; }

    public String getStatusDaCompra() { return statusDaCompra; }
    public void setStatusDaCompra(String statusDaCompra) { this.statusDaCompra = statusDaCompra; }

    public List<Produto> getProdutos() { return produtos; }
    public void setProdutos(List<Produto> produtos) { this.produtos = produtos; }
}
