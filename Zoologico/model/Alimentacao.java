package model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Objects;

public class Alimentacao {

    private int id;
    private Date data;
    private String detalhes;
    private Leao leaoId;

    private final static String url = "jdbc:mysql://localhost:3306/Zoologico?useTimezone=true&serverTimezone=UTC";
    private final static String user = "root";
    private final static String password = "";

    public Alimentacao (
        int id,
        Date data,
        String detalhes,
        Leao leaoId
    ) {
        this.id = id;
        this.data = data;
        this.detalhes = detalhes;
        this.leaoId = leaoId;

    }

    public void setId (int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getDetalhes() {
        return detalhes;
    }

    public void setDetalhes(String detalhes) {
        this.detalhes = detalhes;
    }

    public Leao getLeao() {
        return leaoId;
    }

    public void setLeao(Leao leaoId) {
        this.leaoId = leaoId;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Alimentacao)) {
            return false;
        }
        Alimentacao alimentacao = (Alimentacao) o;
        return Objects.equals(id, alimentacao.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, data, detalhes, leaoId);
    }

    @Override
    public String toString() {
        return
            "\n Id: " + this.getId() +
            "\n Data: " + this.getData() +
            "\n Detalhes: " + this.getDetalhes() +
            "\n Id leão: " + this.getLeao();
    }

}