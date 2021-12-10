import java.util.ArrayList;
import java.util.Objects;

// Criação da classe com herança da Superclasse Pessoa
public class Padaria extends Estabelecimento {

    // Propriedades do objeto
    private String hrFuncionamento;
    private ArrayList<Receita> receitas = new ArrayList<>();

    // Construtor
    public Padaria(
        int id,
        String nome,
        String dataAbertura,
        int idEndereco,
        String cep,
        String rua,
        String numero,
        String bairro,
        String cidade,
        String hrFuncionamento
    ){
        super(id, nome, dataAbertura, idEndereco, cep, rua, numero, bairro, cidade); // Informando que os dados descritos vem da superclasse Estabelecimento
        this.hrFuncionamento = hrFuncionamento;
    }

    // Criação dos setters e getters
    public void setHrFuncionamento(String hrFuncionamento) {
        this.hrFuncionamento = hrFuncionamento;
    }

    public String getHrFuncionamento() {
        return this.hrFuncionamento;
    }

    public void setReceitas(Receita receita) {
        this.receitas.add(receita);
        receita.setPadarias(this);
    }

    public ArrayList<Receita> getReceitas() {
        return this.receitas;
    }

    // Método que verifica se o objeto existe (é igual)
    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Padaria)) {
            return false;
        }
        Padaria padaria = (Padaria) o;
        return Objects.equals(this.getId(), padaria.getId());
    }

    // Cria um hashcode 'assinatura' para o objeto (transforma os dados em binário e após, transforma em código)
    @Override
    public int hashCode() {
        return Objects.hash(hrFuncionamento);
    }

    // Altera o método padrão da classe para retornar os dados informados
    @Override
    public String toString() {
        String ret = "\n========== Padaria " + this.getId() + " ==========" +
            "\n Nome: " + this.getNome() +
            "\n Data da abertura: " + this.getDataAbertura() +
            "\n Horário de funcionamento: " + this.getHrFuncionamento() +
            "\n Endereço: " + this.getEndereco() +
            "\n\n========== RECEITAS ==========";

            for (Receita receita : this.receitas) {
                ret += "\n   " + receita.toString();
            }

        return ret;
    }

}