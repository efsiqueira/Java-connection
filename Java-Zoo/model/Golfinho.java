package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Objects;

public class Golfinho extends Animal {
    
    private int treinamento;
    private final static String url = "jdbc:mysql://localhost:3306/Zoologico?useTimezone=true&serverTimezone=UTC";
    private final static String user = "root";
    private final static String password = "";
    
    public Golfinho(int id) {
        super(id);
    }

    public Golfinho(
        int id,
        String nome,
        int treinamento,
        int idJaula,
        String descricao
    ) {
        super(id, nome, idJaula, descricao);
        this.treinamento = treinamento;
    }

    public Golfinho(String nome, int idJaula, String descricao, int treinamento) {
        super(nome, idJaula, descricao);
        this.treinamento = treinamento;
    }

    public Golfinho(String nome, String descricao, int treinamento) {
        super(nome, descricao);
        this.treinamento = treinamento;
    }

    public Golfinho(int id, String nome, int treinamento) {
        super(id, nome);
        this.treinamento = treinamento;
    }

    public int getTreinamento() {
        return treinamento;
    }

    public void setTreinamento(int treinamento) {
        this.treinamento = treinamento;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Golfinho)) {
            return false;
        }
        Golfinho golfinho = (Golfinho) o;
        return Objects.equals(this.getId(), golfinho.getId());
    }

    // Cria um hashcode 'assinatura' para o objeto (transforma os dados em binário e após, transforma em código)
    @Override
    public int hashCode() {
        return Objects.hash(treinamento);
    }

    // Altera o método padrão da classe para retornar os dados informados
    @Override
    public String toString() {
        return
            "\n========== Golfinho " + this.getId() + " ==========" +
            "\n Nome: " + this.getNome() +
            "\n Treinamento: " + this.getTreinamento() +
            "\n Jaula: " + this.getJaula();

    }

    public static Golfinho selectGolfinho(int id) throws Exception {
        try {
            Connection con = DriverManager.getConnection(url, user, password);
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery("SELECT * FROM Golfinho g LEFT JOIN Jaula j ON (j.id = g.jaula_id) WHERE g.id = " + id);
            if(rs.next()) {
                
                Golfinho golfinho = new Golfinho(
                    rs.getInt("id"),
                    rs.getString("nome"),
                    rs.getInt("treinamento"),
                    rs.getInt("jaula_id"),
                    rs.getString("descricao")
                );
                
                con.close();
                return golfinho;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        throw new Exception("Golfinho não encontrado");
    }

    public static void insertGolfinho(Golfinho golfinho) {
        try {
            Connection con = DriverManager.getConnection(url, user, password);

            PreparedStatement pJaula = con.prepareStatement("INSERT INTO Jaula (descricao) VALUES (?)",
                PreparedStatement.RETURN_GENERATED_KEYS
            );

            pJaula.setString(1, golfinho.getJaula().getDescricao());

            if(pJaula.executeUpdate() > 0) {
                ResultSet rsJaula = pJaula.getGeneratedKeys();
                rsJaula.next();
                int idJaula = rsJaula.getInt(1);

                PreparedStatement pGolfinho = con.prepareStatement(
                    "INSERT INTO Golfinho (nome, treinamento, jaula_id) VALUES (?,?,?)",
                    PreparedStatement.RETURN_GENERATED_KEYS
                );
                
                pGolfinho.setString(1, golfinho.getNome());
                pGolfinho.setInt(2, golfinho.getTreinamento());
                pGolfinho.setInt(3, idJaula);

                if(pGolfinho.executeUpdate() > 0) {
                    ResultSet rsGolfinho = pGolfinho.getGeneratedKeys();
                    rsGolfinho.next();
                    int idGolfinho = rsGolfinho.getInt(1);
                    
                    ResultSet queryGolfinho = con.createStatement().executeQuery("SELECT * FROM golfinho WHERE id = " + idGolfinho);
                    queryGolfinho.next();
                    ResultSet queryJaula = con.createStatement().executeQuery("SELECT * FROM jaula WHERE id = " + idJaula);
                    queryJaula.next();

                }
            }
            con.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void updateGolfinho(Golfinho golfinho) {
        try {
            Connection con = DriverManager.getConnection(url, user, password);
            Statement stm = con.createStatement();
            stm.execute("UPDATE Golfinho SET "
                + " nome = '" + golfinho.getNome() + "'"
                + ", treinamento = '" + golfinho.getTreinamento() + "'"
                + " WHERE id = " + golfinho.getId());

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void deleteGolfinho(int id) {
        try {
            Connection con = DriverManager.getConnection(url, user, password);
            Statement stm = con.createStatement();
            stm.execute("DELETE FROM Golfinho "
                + " WHERE id = " + id);
            
            con.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
