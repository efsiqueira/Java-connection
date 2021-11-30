import java.util.Objects;

// Criação da classe
public class Estabelecimento {
    
    // Propriedades do objeto
    private int id;
    private String nome;
    private String dataAbertura;
    private Endereco endereco;

    protected Estabelecimento(
        int id,
        String nome,
        String dataAbertura,
        int idEndereco,
        String cep,
        String rua,
        String numero,
        String bairro,
        String cidade
    ){
        this.id = id;
        this.nome = nome;
        this.dataAbertura = dataAbertura;
        this.endereco = new Endereco( // Relação com a classe Endereço e passando suas propriedades
            idEndereco,
            cep,
            rua,
            numero,
            bairro,
            cidade
        );
    }

    // Criação dos setters e getters
    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return this.nome;
    }

    public void setDataAbertura(String dataAbertura) {
        this.dataAbertura = dataAbertura;
    }

    public String getDataAbertura() {
        return this.dataAbertura;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Endereco getEndereco() {
        return this.endereco;
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
        return padaria.hashCode() == this.hashCode();//Objects.equals(this.getCep(), padaria.getCep());
    }

    // Cria um hashcode 'assinatura' para o objeto (transforma os dados em binário e após, transforma em código)
    @Override
    public int hashCode() {
        return Objects.hash(id, nome, dataAbertura, endereco);
    }

    // Altera o método padrão da classe para retornar os dados informados
    @Override
    public String toString() {
        return
            "Nome: " + this.getNome() +
            "\nEndereço: " + this.getEndereco() + "\n";
    }

}