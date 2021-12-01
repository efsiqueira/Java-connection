import java.util.ArrayList;
import java.util.Objects;

// Criação da classe
public class Receita {
    
    // Propriedades do objeto
    private int idReceita;
    private String nome;
    private String etapas;
    private int nrEtapas;
    private double valor;
    private ArrayList<Padaria> padarias = new ArrayList<>(); // Relação com a classe Padaria (arraylist pois pode receber mais de um objeto da classe)
    private ArrayList<Mercado> mercados = new ArrayList<>();
    private ArrayList<Cliente> clientes = new ArrayList<>();
    private Chef chef; // Relação com a classe Chef

    // Construtor
    public Receita(
        int idReceita,
        String nome,
        String etapas,
        int nrEtapas,
        double valor,
        Chef chef
    ){
        this.idReceita = idReceita;
        this.nome = nome;
        this.etapas = etapas;
        this.nrEtapas = nrEtapas;
        this.valor = valor;
        chef.setReceitas(this);
    }

    // Criação dos setters e getters
    public void setIdReceita(int idReceita) {
        this.idReceita = idReceita;
    }

    public int getIdReceita() {
        return this.idReceita;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return this.nome;
    }

    public void setEtapas(String etapas) {
        this.etapas = etapas;
    }

    public String getEtapas() {
        return this.etapas;
    }

    public void setNrEtapas(int nrEtapas) {
        this.nrEtapas = nrEtapas;
    }

    public int getNrEtapas() {
        return this.nrEtapas;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public double getValor() {
        return this.valor;
    }

    public void setChef(Chef chef) {
        this.chef = chef;
    }

    public Chef getChef() {
        return this.chef;
    }

    public void setPadarias(Padaria padaria) {
        this.padarias.add(padaria);
    }

    public ArrayList<Padaria> getPadarias() {
        return this.padarias;
    }

    public void setMercados(Mercado mercado) {
        this.mercados.add(mercado);
    }

    public ArrayList<Mercado> getMercados() {
        return this.mercados;
    }

    public void setClientes(Cliente cliente) {
        this.clientes.add(cliente);
    }

    public ArrayList<Cliente> getClientes() {
        return this.clientes;
    }

    // Método que verifica se o objeto existe (é igual)
    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Receita)) {
            return false;
        }
        Receita receita = (Receita) o;
        return Objects.equals(idReceita, receita.idReceita);
    }

    // Cria um hashcode 'assinatura' para o objeto (transforma os dados em binário e após, transforma em código)
    @Override
    public int hashCode() {
        return Objects.hash(idReceita, nome, etapas, nrEtapas, valor);
    }

    // Altera o método padrão da classe para retornar os dados informados
    @Override
    public String toString() {
        return
            "\n Nome: " + this.getNome() +
            "\n Etapas: " + this.getEtapas() +
            "\n Nº de etapas: " + this.getNrEtapas() +
            "\n Valor: R$ " + this.getValor();
    }
    
}