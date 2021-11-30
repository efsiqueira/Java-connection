import java.util.ArrayList;
import java.util.Objects;

// Criação da classe com herança da Superclasse Pessoa
public class Mercado extends Estabelecimento {

    // Propriedades do objeto (criado em private para ser acessado apenas pela classe)
    private String promocoes;
    private ArrayList<Receita> receitas = new ArrayList<>();

    // Construtor
    public Mercado(
        int id,
        String nome,
        String dataAbertura,
        int idEndereco,
        String cep,
        String rua,
        String numero,
        String bairro,
        String cidade,
        String promocoes
    ){
        super(id, nome, dataAbertura, idEndereco, cep, rua, numero, bairro, cidade); // Informando que os dados descritos vem da superclasse Estabelecimento
        this.promocoes = promocoes;
    }

    // Criação dos setters e getters
    public void setPromocoes(String promocoes) {
        this.promocoes = promocoes;
    }

    public String getPromocoes() {
        return this.promocoes;
    }

    public void setReceitas(Receita receita) {
        this.receitas.add(receita);
        receita.setMercados(this);
    }

    public ArrayList<Receita> getReceitas() {
        return this.receitas;
    }

    // Método que verifica se o objeto existe (é igual)
    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Mercado)) {
            return false;
        }
        Mercado mercado = (Mercado) o;
        return Objects.equals(this.getId(), mercado.getId());
    }

    // Cria um hashcode 'assinatura' para o objeto (transforma os dados em binário e após, transforma em código)
    @Override
    public int hashCode() {
        return Objects.hash(promocoes);
    }

    // Altera o método padrão da classe para retornar os dados informados
    @Override
    public String toString() {
        String ret = "\n========== Mercado " + this.getId() + " ==========" +
            "\n Nome: " + this.getNome() +
            "\n Data da abertura: " + this.getDataAbertura() +
            "\n Promoções: " + this.getPromocoes() +
            "\n Endereço: " + this.getEndereco() +
            "\n\n========== RECEITAS ==========";

            for (Receita receita : this.receitas) {
                ret += "\n   " + receita.toString();
            }

        return ret;
    }

}