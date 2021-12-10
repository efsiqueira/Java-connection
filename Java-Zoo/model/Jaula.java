package model;

import java.util.Objects;

public class Jaula {
    
    private int id;
    private String descricao;

    public Jaula(
        int id,
        String descricao
    ) {
        this.id = id;
        this.descricao = descricao;
    }

    public Jaula(
        String descricao
    ) {
        this.descricao = descricao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Jaula)) {
            return false;
        }
        Jaula jaula = (Jaula) o;
        return Objects.equals(this.getId(), jaula.getId());
    }

    // Cria um hashcode 'assinatura' para o objeto (transforma os dados em binário e após, transforma em código)
    @Override
    public int hashCode() {
        return Objects.hash(id, descricao);
    }

    // Altera o método padrão da classe para retornar os dados informados
    @Override
    public String toString() {
        return
            "\n========== Jaula " + this.getId() + " ==========" +
            "\n Descrição: " + this.getDescricao();

    }

}
