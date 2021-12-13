package model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Objects;

public class Treinamento {
    
    private int id;
    private Date data;
    private String detalhes;
    private Golfinho golfinho;

    private final static String url = "jdbc:mysql://localhost:3306/Zoologico?useTimezone=true&serverTimezone=UTC";
    private final static String user = "root";
    private final static String password = "";
    
    public Treinamento(int idGolfinho, Date data, String detalhes) {
        this.data = data;
        this.detalhes = detalhes;
        this.golfinho = new Golfinho(
            idGolfinho
        );
    }

    public Treinamento(Date data, String detalhes) {
        this.data = data;
        this.detalhes = detalhes;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
    

    public Golfinho getGolfinho() {
        return golfinho;
    }

    public void setGolfinho(Golfinho golfinho) {
        this.golfinho = golfinho;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Treinamento)) {
            return false;
        }
        Treinamento treinamento = (Treinamento) o;
        return Objects.equals(this.getId(), treinamento.getId());
    }

    // Cria um hashcode 'assinatura' para o objeto (transforma os dados em binário e após, transforma em código)
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    // Altera o método padrão da classe para retornar os dados informados
    @Override
    public String toString() {
        return
            "\n========== Treinamento " + this.getId() + " ==========" +
            "\n Golfinho: " + golfinho.getNome() +
            "\n Data: " + this.getData() +
            "\n Detalhes: " + this.getDetalhes();

    }

    public static void insertTreinamento(Treinamento treinamento) {
        try {
            Connection con = DriverManager.getConnection(url, user, password);

            PreparedStatement pTreinamento = con.prepareStatement("INSERT INTO Treinamento (golfinho_id, data, detalhes) VALUES (?,?,?)",
                PreparedStatement.RETURN_GENERATED_KEYS
            );

            pTreinamento.setInt(1, treinamento.getGolfinho().getId());
            pTreinamento.setDate(2, treinamento.getData());
            pTreinamento.setString(3, treinamento.getDetalhes());

            if(pTreinamento.executeUpdate() > 0) {
                ResultSet rsTreinamento = pTreinamento.getGeneratedKeys();
                rsTreinamento.next();
                int idTreinamento = rsTreinamento.getInt(1);

                ResultSet queryJaula = con.createStatement().executeQuery("SELECT * FROM treinamento WHERE id = " + idTreinamento);
                queryJaula.next();

            }
            con.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
