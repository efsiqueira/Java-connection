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
public class Chef extends Pessoa{

    // Propriedades do objeto (criado em private para ser acessado apenas pela classe)
    private String especialidade;
    private ArrayList<Receita> receitas = new ArrayList<>();

    private final static String url = "jdbc:mysql://localhost:3306/PadariaJava?useTimezone=true&serverTimezone=UTC";
    private final static String user = "root";
    private final static String password = "";

    // Construtor
    public Chef(
        int id,
        String nome,
        String cpf,
        Date dataNasc,
        String especialidade
    ){
        super(id, nome, cpf, dataNasc); // Informando que os dados descritos vem da superclasse Pessoa
        this.especialidade = especialidade;
    }

    public Chef(String nome, String cpf, Date dataNasc, String especialidade) {
        super(nome, cpf, dataNasc);
        this.especialidade = especialidade;
    }

    // Criação dos setters e getters
    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public String getEspecialidade() {
        return this.especialidade;
    }

    public void setReceitas(Receita receita) {
        this.receitas.add(receita);
        receita.setChef(this);
    }

    public ArrayList<Receita> getReceitas() {
        return this.receitas;
    }

    public Chef id(int id) {
        setId(id);
        return this;
    }

    public Chef nome(String nome) {
        setNome(nome);
        return this;
    }

    public Chef cpf(String cpf) {
        setCpf(cpf);
        return this;
    }

    public Chef dtNasc(Date dtNasc) {
        setDataNasc(dtNasc);
        return this;
    }

    public Chef especialidade(String especialidade) {
        setEspecialidade(especialidade);
        return this;
    }

    // Método que verifica se o objeto existe (é igual)
    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Chef)) {
            return false;
        }
        Chef chef = (Chef) o;
        return Objects.equals(this.getId(), chef.getId());
    }

    // Cria um hashcode 'assinatura' para o objeto
    @Override
    public int hashCode() {
        return Objects.hash(especialidade, receitas);
    }

    // Altera o método padrão da classe para retornar os dados informados
    @Override
    public String toString() {
        String ret = "\n========== Chef " + this.getId() + " ==========" +
            "\n Nome: " + this.getNome() +
            "\n cpf: " + this.getCpf() +
            "\n Data de nascimento: " + this.getDataNasc() +
            "\n Especialidade: " + this.getEspecialidade() +
            "\n\n========== RECEITAS ==========";
            
            // Foreach passando por toda a classe Receita para printar as receitas de cada Chef
            for (Receita receita : this.receitas) {
                ret += "\n   " + receita.toString();
            }

        return ret;
    }

    public static void SelectChef() {
        try {
            Connection con = DriverManager.getConnection(url, user, password);
            Statement statement = con.createStatement();
            ResultSet results = statement.executeQuery("SELECT * FROM Chef");
            while(results.next()) {
                Chef chef = new Chef(
                    results.getInt("id"),
                    results.getString("nome"),
                    results.getString("cpf"),
                    results.getDate("dtnasc"),
                    results.getString("especialidade")
                );
                System.out.println(chef);
            }

            con.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void InsertChef(Chef chef) {
        try {
            Connection con = DriverManager.getConnection(url, user, password);
            PreparedStatement stm = con.prepareStatement("INSERT INTO chef "
                            + "(nome, cpf, dtnasc, especialidade) VALUES "
                            + "(?,?,?,?", PreparedStatement.RETURN_GENERATED_KEYS);
            
            stm.setString(1, chef.getNome());
            stm.setString(2, chef.getCpf());
            stm.setDate(3, chef.getDataNasc());
            stm.setString(4, chef.getEspecialidade());

            if(stm.executeUpdate() > 0) {
                ResultSet rs = stm.getGeneratedKeys();

                if(rs.next()) {
                    System.out.println(new Chef(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getString("cpf"),
                        rs.getDate("dtnasc"),
                        rs.getString("especialidade")
                    ));
                }
            }
            con.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static Chef getChefInsert() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Informe o nome do chef: ");
        String nome = scan.nextLine();
        System.out.print("Informe o cpf do chef: ");
        String cpf = scan.nextLine();
        System.out.print("Informe a data de nascimento do chef: ");
        String dataNasc = scan.nextLine();
        System.out.print("Informe a especialidade do chef: ");
        String especialidade = scan.nextLine();
        scan.close();

        return new Chef(
            nome,
            cpf,
            Date.valueOf(dataNasc),
            especialidade
        );
    }

    public static void updateChefSt(Chef chef) {
        try {
            Connection con = DriverManager.getConnection(url, user, password);
            Statement stm = con.createStatement();
            boolean sql = stm.execute("UPDATE chef SET "
                + " nome = '" + chef.getNome() + "'"
                + ", cpf = '" + chef.getCpf() + "'"
                + ", dtnasc = '" + chef.getDataNasc() + "'"
                + ", especialidade = '" + chef.getEspecialidade() + "'"
                + " WHERE id = " + chef.getId());
            if(!sql) {
                System.out.println("Falha na execução");
            }
            con.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static Chef getChefUpdate() throws Exception {
        try {
            Scanner scan = new Scanner(System.in);
            Chef chef = Chef.getChef();
            System.out.println("Informe o nome do chef: ");
            String nome = scan.next();
            if(nome.length() > 0) {
                chef.setNome(nome);
            }
            System.out.println("Informe o CPF do chef: ");
            String cpf = scan.next();
            if(cpf.length() > 0) {
                chef.setCpf(cpf);
            }
            System.out.println("Informe a data de nascimento do chef: ");
            String dataNasc = scan.next();
            if(dataNasc.length() > 0) {
                chef.setDataNasc(Date.valueOf(dataNasc));
            }
            System.out.println("Informe a especialidade do chef: ");
            String especialidade = scan.next();
            if(especialidade.length() > 0) {
                chef.setEspecialidade(especialidade);
            }
            scan.close();
            return chef;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public static Chef getChef() throws Exception {
        try {
            Scanner scan = new Scanner(System.in);
            System.out.println("Informe o Id de exclusão: ");
            int id = scan.nextInt();
            Connection con = DriverManager.getConnection(url, user, password);
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery("SELECT * FROM chef WHERE id = " + id);

            if(!rs.next()) {
                throw new Exception("Id inválido");
            }
            scan.close();
            return new Chef(
                rs.getInt("id"),
                rs.getString("nome"),
                rs.getString("cpf"),
                rs.getDate("dtnasc"),
                rs.getString("especialidade")
            );

        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public static void deleteChefSt(Chef chef) {
        try {
            Connection con = DriverManager.getConnection(url, user, password);
            Statement stm = con.createStatement();
            boolean sql = stm.execute("DELETE FROM chef "
                + " WHERE id = " + chef.getId());
            if(!sql) {
                System.out.println("Falha na execução");
            }
            con.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}