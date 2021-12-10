import java.util.Objects;

// Criação da classe
public class Endereco {

    // Propriedades do objeto
    private int idEndereco;
    private String cep;
    private String rua;
    private String numero;
    private String bairro;
    private String cidade;

    // Construtor
    public Endereco(
        int idEndereco,
        String cep,
        String rua,
        String numero,
        String bairro,
        String cidade
    ){
        this.idEndereco = idEndereco;
        this.cep = cep;
        this.rua = rua;
        this.numero = numero;
        this.bairro = bairro;
        this.cidade = cidade;
    }

    // Criação dos setters e getters
    public void setIdEndereco(int idEndereco) {
        this.idEndereco = idEndereco;
    }

    public int getIdEndereco() {
        return this.idEndereco;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getCep() {
        return this.cep;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getRua() {
        return this.rua;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getNumero() {
        return this.numero;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getBairro() {
        return this.bairro;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getCidade() {
        return this.cidade;
    }

    // Método que verifica se o objeto existe (é igual)
    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Endereco)) {
            return false;
        }
        Endereco endereco = (Endereco) o;
        return Objects.equals(idEndereco, endereco.idEndereco);
    }

    // Cria um hashcode 'assinatura' para o objeto (transforma os dados em binário e após, transforma em código)
    @Override
    public int hashCode() {
        return Objects.hash(idEndereco, cep, rua, numero, bairro, cidade);
    }

    // Altera o método padrão da classe para retornar os dados informados
    @Override
    public String toString() {
        return
            "\n Cep: " + this.getCep() +
            "\n Rua: " + this.getRua() +
            "\n Número: " + this.getNumero() +
            "\n Bairro: " + this.getBairro() +
            "\n Cidade: " + this.getCidade();
    }
}