package model.entities;

import java.io.Serializable;
import java.util.Objects;

public class Produto implements Serializable {

    private int id;
    private String nome;
    private double preco;
    private String uom;
    private int quantidade;

    private Categoria categoria;

    public Produto(int id, String nome, double preco, String uom, int quantidade, Categoria categoria) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
        this.uom = uom;
        this.quantidade = quantidade;
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return "Produto: " +
                "id: " + id +
                ", nome: '" + nome + '\'' +
                ", preco: " + preco +
                ", codigo UOM: '" + uom + '\'' +
                ", quantidade: " + quantidade +
                ", categoria: " + categoria +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Produto produto = (Produto) o;
        return id == produto.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String getUom() {
        return uom;
    }

    public void setUom(String uom) {
        this.uom = uom;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
}
