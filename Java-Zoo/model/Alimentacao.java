package model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Objects;

public class Alimentacao {

    private int id;
    private Date data;
    private String detalhes;
    private Leao leao;

    private final static String url = "jdbc:mysql://localhost:3306/Zoologico?useTimezone=true&serverTimezone=UTC";
    private final static String user = "root";
    private final static String password = "";

    public Alimentacao (
        int id,
        Date data,
        String detalhes,
        Leao leao
    ) {
        this.id = id;
        this.data = data;
        this.detalhes = detalhes;
        this.leao = leao;

    }

    public Alimentacao(int idLeao, Date data, String detalhes) {
        this.leao = new Leao(idLeao);
        this.data = data;
        this.detalhes = detalhes;
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
        return leao;
    }

    public void setLeao(Leao leao) {
        this.leao = leao;
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
        return Objects.hash(id, data, detalhes, leao);
    }

    @Override
    public String toString() {
        return
            "\n Id: " + this.getId() +
            "\n Data: " + this.getData() +
            "\n Detalhes: " + this.getDetalhes() +
            "\n Id leão: " + this.getLeao();
    }

    public static void insertAlimentacao(Alimentacao alimentacao) {
        try {
            Connection con = DriverManager.getConnection(url, user, password);

            PreparedStatement pAlimentacao = con.prepareStatement("INSERT INTO Alimentacao (leao_id, data, detalhes) VALUES (?,?,?)",
                PreparedStatement.RETURN_GENERATED_KEYS
            );

            pAlimentacao.setInt(1, alimentacao.getLeao().getId());
            pAlimentacao.setDate(2, alimentacao.getData());
            pAlimentacao.setString(3, alimentacao.getDetalhes());

            if(pAlimentacao.executeUpdate() > 0) {
                ResultSet rsAlimentacao = pAlimentacao.getGeneratedKeys();
                rsAlimentacao.next();
                int idAlimentacao = rsAlimentacao.getInt(1);

                ResultSet queryAlimentacao = con.createStatement().executeQuery("SELECT * FROM alimentacao WHERE id = " + idAlimentacao);
                queryAlimentacao.next();

            }
            con.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}