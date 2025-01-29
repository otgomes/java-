abstract class Veiculo{

    private String marca; // Representa a marca do veículo
    private String modelo; // Representa o modelo do veículo
    private int ano; // Representa o ano de fabricação do veículo

    // Construtor
    public Veiculo(String marca, String modelo, int ano) {
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
    }

    // Métodos getters
    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public int getAno() {
        return ano;
    }

    // Métodos setters
    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    // Método abstrato que as subclasses devem implementar
    public abstract void exibirDetalhes();
}