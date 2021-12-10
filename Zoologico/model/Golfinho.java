package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Objects;
import java.util.Scanner;

public class Golfinho extends Animal {
    
    private int treinamento;
    private final static String url = "jdbc:mysql://localhost:3306/Zoologico?useTimezone=true&serverTimezone=UTC";
    private final static String user = "root";
    private final static String password = "";

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
            "\n========== Leão " + this.getId() + " ==========" +
            "\n Nome: " + this.getNome() +
            "\n Treinamento: " + this.getTreinamento() +
            "\n Jaula: " + this.getJaula();

    }
    //

    public static void selectGolfinho() {
        try {
            Connection con = DriverManager.getConnection(url, user, password);
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery("SELECT * FROM Golfinho g LEFT JOIN Jaula j ON (g.id = j.jaula_id)");
            while(rs.next()) {
                Golfinho golfinho = new Golfinho(
                    rs.getInt("id"),
                    rs.getString("nome"), 
                    rs.getInt("treinamento"),
                    rs.getInt("jaula_id"),
                    rs.getString("descricao")
                );
                System.out.println(golfinho);
                
                con.close();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void insertGolfinho(Golfinho golfinho) {
        try {
            Connection con = DriverManager.getConnection(url, user, password);
            PreparedStatement stm = con.prepareStatement(
                "INSERT INTO Golfinho (nome, treinamento, jaula_id) VALUES (?,?,?)",
                PreparedStatement.RETURN_GENERATED_KEYS);
            
            stm.setString(1, golfinho.getNome());
            stm.setInt(2, golfinho.getTreinamento());

            if(stm.executeUpdate() > 0) {
                ResultSet rs = stm.getGeneratedKeys();

                if(rs.next()) {
                    ResultSet queryRs = con.createStatement().executeQuery("SELECT * FROM Golfinho WHERE id = " + rs.getInt(1));
                    queryRs.next();
                    System.out.println(new Golfinho(
                        queryRs.getString("nome"),
                        queryRs.getInt("jaula_id"),
                        queryRs.getString("descricao"),
                        queryRs.getInt("treinamento")                        
                    ));
                }
            }
            con.close();

            System.out.println("\nDados inseridos com sucesso!");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /*public static Leao getLeaoInsert(Scanner scan) {
        System.out.print("Informe o nome do leão: ");
        String nome = scan.next();
        System.out.print("Informe a alimentação do leão: ");
        int alimentacao = scan.nextInt();
        System.out.print("Informe os visitantes do leão: ");
        int visitantes = scan.nextInt();
        System.out.print("Informe a jaula: ");
        String descricao = scan.next();

        return new Leao(
            nome,
            descricao,
            alimentacao,
            visitantes
        );
    }*/

    public static void updateGolfinho(Golfinho golfinho) {
        try {
            Connection con = DriverManager.getConnection(url, user, password);
            Statement stm = con.createStatement();
            stm.execute("UPDATE Golfinho SET "
                + " nome = '" + golfinho.getNome() + "'"
                + ", alimentacao = '" + golfinho.getTreinamento());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static Golfinho getGolfinhoUpdate(Scanner scan) throws Exception {
        try {
            Golfinho golfinho = Golfinho.getGolfinho(scan);
            System.out.println("Informe o nome do Golfinho: ");
            String nome = scan.next();
            if(nome.length() > 0) {
                golfinho.setNome(nome);
            }
            System.out.println("Informe o tempo de treinamento do golfinho: ");
            int treinamento = scan.nextInt();
            golfinho.setTreinamento(treinamento);
            return golfinho;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public static Golfinho getGolfinho(Scanner scan) throws Exception {
        try {
            System.out.println("Informe o Id de alteração/exclusão: ");
            int id = scan.nextInt();
            Connection con = DriverManager.getConnection(url, user, password);
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery("SELECT * FROM golfinho WHERE id = " + id);

            if(!rs.next()) {
                throw new Exception("Id inválido!");
            }
            return new Golfinho(
                rs.getInt("id"),
                rs.getString("nome"),
                rs.getInt("treinamento"),
                rs.getInt("jaula_id"),
                rs.getString("descricao")
            );
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public static void deleteGolfinho(Golfinho golfinho) {
        try {
            Connection con = DriverManager.getConnection(url, user, password);
            Statement stm = con.createStatement();
            stm.execute("DELETE FROM golfinho "
                + " WHERE id = " + golfinho.getId());
            
            System.out.println("\nDados excluídos com sucesso!");
            con.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static Golfinho idGolfinho(int id) throws Exception {
        try {
            Connection con = DriverManager.getConnection(url, user, password);
            ResultSet rs = con.createStatement().executeQuery("SELECT * FROM golfinho WHERE id = " + id);
            rs.next();
            Golfinho golfinho = new Golfinho(
                rs.getInt("id"),
                rs.getString("nome"),
                rs.getInt("treinamento"),
                rs.getInt("jaula_id"),
                rs.getString("descricao")
            );
            return golfinho;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

}
