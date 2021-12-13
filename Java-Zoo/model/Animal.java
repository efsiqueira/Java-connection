package model;

import java.util.Objects;

public class Animal {
    
    private int id;
    private String nome;
    private Jaula jaula;

    public Animal(int id) {
        this.id = id;
    }

    public Animal(
        int id,
        String nome,
        int idJaula,
        String descricao

    ) {
        this.id = id;
        this.nome = nome;
        this.jaula = new Jaula(
            idJaula,
            descricao
        );
    }

    public Animal(
        String nome,
        int idJaula,
        String descricao

    ) {
        this.nome = nome;
        this.jaula = new Jaula(
            idJaula,
            descricao
        );
    }

    public Animal(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    // Construtor de animal, com nome e descrição da jaula
    public Animal(
        String nome,
        String descricao

    ) {
        this.nome = nome;
        this.jaula = new Jaula(
            descricao
        );
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

    public Jaula getJaula() {
        return this.jaula;
    }

    public void setJaula(Jaula jaula) {
        this.jaula = jaula;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Animal)) {
            return false;
        }
        Animal animal = (Animal) o;
        return Objects.equals(id, animal.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, jaula);
    }

    @Override
    public String toString() {
        return
            "\n Id: " + this.getId() +
            "\n Nome: " + this.getNome() +
            "\n Jaula: " + this.getJaula();
    }

}
