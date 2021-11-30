import java.util.ArrayList;
import java.util.Objects;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

// Criação da classe com herança da Superclasse Pessoa
public class Chef extends Pessoa{

    // Propriedades do objeto (criado em private para ser acessado apenas pela classe)
    private String especialidade;
    private ArrayList<Receita> receitas = new ArrayList<>();

    private final static String url = "jdbc:mysql://localhost:3306/Java?useTimezone=true&serverTimezone=UTC";
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

    public static void selectChef(ArrayList<Chef> chefs) {
        try {
            for (Chef chef : chefs) {
                System.out.println(chef);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static ArrayList<Chef> getChefSt() throws Exception{
        try {
            Connection con = DriverManager.getConnection(url, user, password);
            Statement stm = con.createStatement();
            ResultSet res = stm.executeQuery("SELECT * FROM Chef;");
            ArrayList<Chef> chefs = new ArrayList<>();
            while (res.next()) {
                chefs.add(
                    new Chef(
                        res.getInt("id"),
                        res.getString("nome"),
                        res.getString("cpf"),
                        res.getDate("dtnasc"),
                        res.getString("especialidade")
                    )
                );
            }
            con.close();
            return chefs;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}