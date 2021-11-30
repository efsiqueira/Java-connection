import java.util.Objects;
import java.sql.Date;

// Criação da classe
public class Pessoa {
    
    // Propriedades do objeto (criado em private para ser acessado apenas pela classe)
    private int id;
    private String nome;
    private String cpf;
    private Date dataNasc;

    // Construtor (em protected para ser acessado apenas pelas subclasses)
    protected Pessoa(
        int id,
        String nome,
        String cpf,
        Date dataNasc
    ){
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.dataNasc = dataNasc;
    }

    protected Pessoa(String nome, String cpf, Date dataNasc) {
        this.nome = nome;
        this.cpf = cpf;
        this.dataNasc = dataNasc;
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

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCpf() {
        return this.cpf;
    }

    public void setDataNasc(Date dataNasc) {
        this.dataNasc = dataNasc;
    }

    public Date getDataNasc() {
        return this.dataNasc;
    }

    // Método que verifica se o objeto existe (é igual)
    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Pessoa)) {
            return false;
        }
        Pessoa pessoa = (Pessoa) o;
        return Objects.equals(id, pessoa.id);
    }

    // Cria um hashcode 'assinatura' para o objeto (transforma os dados em binário e após, transforma em código)
    @Override
    public int hashCode() {
        return Objects.hash(id, nome, cpf, dataNasc);
    }

    // Altera o método padrão da classe para retornar os dados informados
    @Override
    public String toString() {
        return
            "Nome: " + this.getNome() +
            "\nCpf: " + this.getCpf() +
            "\nData de nascimento: " + this.getDataNasc() + "\n";
    }
}