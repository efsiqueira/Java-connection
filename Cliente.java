import java.sql.Date;
import java.util.ArrayList;
import java.util.Objects;

// Criação da classe com herança da Superclasse Pessoa
public class Cliente extends Pessoa {

    // Propriedades do objeto (criado em private para ser acessado apenas pela classe)
    private String telefone;
    private ArrayList<Receita> receitas = new ArrayList<>();

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
}