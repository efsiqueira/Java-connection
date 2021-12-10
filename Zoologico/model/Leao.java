package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Objects;
import java.util.Scanner;

import view.MostrarLeao;

public class Leao extends Animal {
    
    private int alimentacao;
    private int visitantes;

    private final static String url = "jdbc:mysql://localhost:3306/Zoologico?useTimezone=true&serverTimezone=UTC";
    private final static String user = "root";
    private final static String password = "";

    public Leao(
        int id,
        String nome,
        int idJaula,
        String descricao,
        int alimentacao,
        int visitantes
    ) {
        super(id, nome, idJaula, descricao);
        this.alimentacao = alimentacao;
        this.visitantes = visitantes;
    }

    public Leao(
        String nome,
        String descricao,
        int alimentacao,
        int visitantes
    ) {
        super(nome, descricao);
        this.alimentacao = alimentacao;
        this.visitantes = visitantes;
    }

    public Leao(String nome, int idJaula, String descricao, int alimentacao, int visitantes) {
        super(nome, idJaula, descricao);
        this.alimentacao = alimentacao;
        this.visitantes = visitantes;
    }

    public void setAlimentacao(int alimentacao) {
        this.alimentacao = alimentacao;
    }

    public int getAlimentacao() {
        return this.alimentacao;
    }

    public void setVisitantes(int visitantes) {
        this.visitantes = visitantes;
    }

    public int getVisitantes() {
        return this.visitantes;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Leao)) {
            return false;
        }
        Leao leao = (Leao) o;
        return Objects.equals(this.getId(), leao.getId());
    }

    // Cria um hashcode 'assinatura' para o objeto (transforma os dados em binário e após, transforma em código)
    @Override
    public int hashCode() {
        return Objects.hash(alimentacao, visitantes);
    }

    // Altera o método padrão da classe para retornar os dados informados
    @Override
    public String toString() {
        return
            "\n========== Leão " + this.getId() + " ==========" +
            "\n Nome: " + this.getNome() +
            "\n Alimentação: " + this.getAlimentacao() +
            "\n Visitantes: " + this.getVisitantes() +
            "\n Jaula: " + this.getJaula();

    }

    public static void selectLeao(int id) {
        try {
            Connection con = DriverManager.getConnection(url, user, password);
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery("SELECT * FROM Leao l LEFT JOIN Jaula j ON (j.id = l.jaula_id) WHERE id = " + id);
            while(rs.next()) {
                
                new MostrarLeao(new Leao(
                    rs.getInt("id"),
                    rs.getString("nome"),
                    rs.getInt("jaula_id"),
                    rs.getString("descricao"),
                    rs.getInt("alimentacao"),
                    rs.getInt("visitantes")
                ));
                
                con.close();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void insertLeao(Leao leao) {
        try {
            Connection con = DriverManager.getConnection(url, user, password);

            PreparedStatement pJaula = con.prepareStatement("INSERT INTO Jaula (descricao) VALUES (?)",
                PreparedStatement.RETURN_GENERATED_KEYS
            );

            pJaula.setString(1, leao.getJaula().getDescricao());

            if(pJaula.executeUpdate() > 0) {
                ResultSet rsJaula = pJaula.getGeneratedKeys();
                rsJaula.next();
                int idJaula = rsJaula.getInt(1);

                PreparedStatement pLeao = con.prepareStatement(
                    "INSERT INTO Leao (nome, alimentacao, visitantes, jaula_id) VALUES (?,?,?,?)",
                    PreparedStatement.RETURN_GENERATED_KEYS
                );
                
                pLeao.setString(1, leao.getNome());
                pLeao.setInt(2, leao.getAlimentacao());
                pLeao.setInt(3, leao.getVisitantes());
                pLeao.setInt(4, idJaula);

                if(pLeao.executeUpdate() > 0) {
                    ResultSet rsLeao = pLeao.getGeneratedKeys();
                    rsLeao.next();
                    int idLeao = rsLeao.getInt(1);
                    
                    ResultSet queryLeao = con.createStatement().executeQuery("SELECT * FROM leao WHERE id = " + idLeao);
                    queryLeao.next();
                    ResultSet queryJaula = con.createStatement().executeQuery("SELECT * FROM jaula WHERE id = " + idJaula);
                    queryJaula.next();

                    /*new Leao(
                        queryLeao.getString("nome"),
                        queryJaula.getInt("id"),
                        queryJaula.getString("descricao"),
                        queryLeao.getInt("alimentacao"),
                        queryLeao.getInt("visitantes")
                    );*/
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

    public static void updateLeao(Leao leao) {
        try {
            Connection con = DriverManager.getConnection(url, user, password);
            Statement stm = con.createStatement();
            stm.execute("UPDATE Leao SET "
                + " nome = '" + leao.getNome() + "'"
                + ", alimentacao = '" + leao.getAlimentacao() + "'"
                + ", visitantes = '" + leao.getVisitantes());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static Leao getLeaoUpdate(Scanner scan) throws Exception {
        try {
            Leao leao = Leao.getLeao(scan);
            System.out.println("Informe o nome do Leao: ");
            String nome = scan.next();
            if(nome.length() > 0) {
                leao.setNome(nome);
            }
            System.out.println("Informe a cada quantas horas o leão se alimenta: ");
            int alimentacao = scan.nextInt();
            leao.setAlimentacao(alimentacao);
            System.out.println("Informe a quantidade de visitantes o leão pode receber: ");
            int visitantes = scan.nextInt();
            leao.setVisitantes(visitantes);
            return leao;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public static Leao getLeao(Scanner scan) throws Exception {
        try {
            System.out.println("Informe o Id de alteração/exclusão: ");
            int id = scan.nextInt();
            Connection con = DriverManager.getConnection(url, user, password);
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery("SELECT * FROM leao WHERE id = " + id);

            if(!rs.next()) {
                throw new Exception("Id inválido!");
            }
            return new Leao(
                rs.getInt("id"),
                rs.getString("nome"),
                rs.getInt("jaula_id"),
                rs.getString("descricao"),
                rs.getInt("alimentacao"),
                rs.getInt("visitantes")
            );
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public static void deleteLeao(Leao leao) {
        try {
            Connection con = DriverManager.getConnection(url, user, password);
            Statement stm = con.createStatement();
            stm.execute("DELETE FROM leao "
                + " WHERE id = " + leao.getId());
            
            System.out.println("\nDados excluídos com sucesso!");
            con.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static Leao idLeao(int id) throws Exception {
        try {
            Connection con = DriverManager.getConnection(url, user, password);
            ResultSet rs = con.createStatement().executeQuery("SELECT * FROM leao WHERE id = " + id);
            rs.next();
            Leao leao = new Leao(
                rs.getInt("id"),
                rs.getString("nome"),
                rs.getInt("jaula_id"),
                rs.getString("descricao"),
                rs.getInt("alimentacao"),
                rs.getInt("visitantes")
            );
            return leao;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

}
