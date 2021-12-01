import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

// Criação da classe com herança da Superclasse Pessoa
public class Cliente extends Pessoa {

    // Propriedades do objeto (criado em private para ser acessado apenas pela classe)
    private String telefone;
    private ArrayList<Receita> receitas = new ArrayList<>();

    private final static String url = "jdbc:mysql://localhost:3306/PadariaJava?useTimezone=true&serverTimezone=UTC";
    private final static String user = "root";
    private final static String password = "";

    // Construtor
    public Cliente(
        int id,
        String nome,
        String cpf,
        Date dataNasc,
        String telefone
    ){
        super(id, nome, cpf, dataNasc); // Informando que os dados descritos vem da superclasse Pessoa
        this.telefone = telefone;
    }

    public Cliente(String nome, String cpf, Date dataNasc, String telefone) {
        super(nome, cpf, dataNasc);
        this.telefone = telefone;
    }

    // Criação dos setters e getters
    public void setTelefone (String telefone) {
        this.telefone = telefone;
    }

    public String getTelefone() {
        return this.telefone;
    }

    public void setReceitas(Receita receita) {
        this.receitas.add(receita);
        receita.setClientes(this);
    }

    public ArrayList<Receita> getReceitas() {
        return this.receitas;
    }

    public Cliente id(int id) {
        setId(id);
        return this;
    }

    public Cliente nome(String nome) {
        setNome(nome);
        return this;
    }

    public Cliente cpf(String cpf) {
        setCpf(cpf);
        return this;
    }

    public Cliente telefone(String telefone) {
        setTelefone(telefone);
        return this;
    }

    // Método que verifica se o objeto existe (é igual)
    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Cliente)) {
            return false;
        }
        Cliente cliente = (Cliente) o;
        return Objects.equals(this.getId(), cliente.getId());
    }

    // Cria um hashcode 'assinatura' para o objeto (transforma os dados em binário e após, transforma em código)
    @Override
    public int hashCode() {
        return Objects.hash(telefone, receitas);
    }

    // Altera o método padrão da classe para retornar os dados informados
    @Override
    public String toString() {
        String ret = "\n========== Cliente " + this.getId() + " ==========" +
            "\n Nome: " + this.getNome() +
            "\n Cpf: " + this.getCpf() +
            "\n Data de nascimento: " + this.getDataNasc() +
            "\n\n========== RECEITAS ==========";

            for (Receita receita : this.receitas) {
                ret += "\n   " + receita.toString();
            }

        return ret;
    }

    public static void SelectCliente() {
        try {
            Connection con = DriverManager.getConnection(url, user, password);
            Statement statement = con.createStatement();
            ResultSet results = statement.executeQuery("SELECT * FROM Cliente");
            while(results.next()) {
                Cliente cliente = new Cliente(
                    results.getInt("id"),
                    results.getString("nome"),
                    results.getString("cpf"),
                    results.getDate("dtnasc"),
                    results.getString("telefone")
                );
                System.out.println(cliente);
            }

            con.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    // Insert
    public static void InsertCliente(Cliente cliente) {
        try {
            Connection con = DriverManager.getConnection(url, user, password);
            PreparedStatement stm = con.prepareStatement(
                "INSERT INTO cliente (nome, cpf, dtnasc, telefone) VALUES (?,?,?,?)",
                PreparedStatement.RETURN_GENERATED_KEYS);
            
            stm.setString(1, cliente.getNome());
            stm.setString(2, cliente.getCpf());
            stm.setDate(3, cliente.getDataNasc());
            stm.setString(4, cliente.getTelefone());

            if(stm.executeUpdate() > 0) {
                ResultSet rs = stm.getGeneratedKeys();

                if(rs.next()) {
                    ResultSet queryRs = con.createStatement().executeQuery("SELECT * FROM cliente WHERE id = " + rs.getInt(1));
                    System.out.println(new Cliente(
                        queryRs.getString("nome"),
                        queryRs.getString("cpf"),
                        queryRs.getDate("dtnasc"),
                        queryRs.getString("telefone")
                    ));
                }
            }
            con.close();

            System.out.println("\nDados inseridos com sucesso!");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static Cliente getClienteInsert(Scanner scan) {
        System.out.print("Informe o nome do cliente: ");
        String nome = scan.next();
        System.out.print("Informe o cpf do cliente: ");
        String cpf = scan.next();
        System.out.print("Informe a data de nascimento do cliente: ");
        String dataNasc = scan.next();
        System.out.print("Informe o telefone do cliente: ");
        String telefone = scan.next();

        return new Cliente(
            nome,
            cpf,
            Date.valueOf(dataNasc),
            telefone
        );
    }

    // Update
    public static void updateClienteSt(Cliente cliente) {
        try {
            Connection con = DriverManager.getConnection(url, user, password);
            Statement stm = con.createStatement();
            stm.execute("UPDATE chef SET "
                + " nome = '" + cliente.getNome() + "'"
                + ", cpf = '" + cliente.getCpf() + "'"
                + ", dtnasc = '" + cliente.getDataNasc() + "'"
                + ", telefone = '" + cliente.getTelefone() + "'"
                + " WHERE id = " + cliente.getId());

            System.out.println("\nDados atualizados com sucesso!");
            con.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static Cliente getClienteUpdate(Scanner scan) throws Exception {
        try {
            Cliente cliente = Cliente.getCliente(scan);
            System.out.println("Informe o nome do cliente: ");
            String nome = scan.next();
            if(nome.length() > 0) {
                cliente.setNome(nome);
            }
            System.out.println("Informe o CPF do cliente: ");
            String cpf = scan.next();
            if(cpf.length() > 0) {
                cliente.setCpf(cpf);
            }
            System.out.println("Informe a data de nascimento do cliente: ");
            String dataNasc = scan.next();
            if(dataNasc.length() > 0) {
                cliente.setDataNasc(Date.valueOf(dataNasc));
            }
            System.out.println("Informe o telefone do cliente: ");
            String telefone = scan.next();
            if(telefone.length() > 0) {
                cliente.setTelefone(telefone);
            }
            return cliente;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public static Cliente getCliente(Scanner scan) throws Exception {
        try {
            System.out.println("Informe o Id de alteração/exclusão: ");
            int id = scan.nextInt();
            Connection con = DriverManager.getConnection(url, user, password);
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery("SELECT * FROM cliente WHERE id = " + id);

            if(!rs.next()) {
                throw new Exception("Id inválido");
            }
            return new Cliente(
                rs.getInt("id"),
                rs.getString("nome"),
                rs.getString("cpf"),
                rs.getDate("dtnasc"),
                rs.getString("telefone")
            );

        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public static void deleteClienteSt(Cliente cliente) {
        try {
            Connection con = DriverManager.getConnection(url, user, password);
            Statement stm = con.createStatement();
            stm.execute("DELETE FROM cliente "
                + " WHERE id = " + cliente.getId());
            
            System.out.println("\nDados excluídos com sucesso!");
            con.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static Cliente idCliente(int id) throws Exception {
        try {
            Connection con = DriverManager.getConnection(url, user, password);
            ResultSet rs = con.createStatement().executeQuery("SELECT * FROM cliente WHERE id = " + id);
            rs.next();
            Cliente cliente = new Cliente(
                rs.getInt("id"),
                rs.getString("nome"),
                rs.getString("cpf"),
                rs.getDate("dtnasc"),
                rs.getString("telefone")
            );
            return cliente;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

}