class Carro extends Veiculo{

    private int numeroDePortas;  // Representa o número de portas do carro.

    public Carro(String marca, String modelo, int ano, int numeroDePortas) {
        super(marca, modelo, ano);
        this.numeroDePortas = numeroDePortas;
    }

    public int getNumeroDePortas() {
        return numeroDePortas;
    }

    public void setNumeroDePortas(int numeroDePortas) {
        this.numeroDePortas = numeroDePortas;
    }

    public void exibirDetalhes() {
        System.out.println("Marca: " + getMarca() + ", Modelo: " + getModelo() + ", Ano: " + getAno() + ", Numero de Portas: " + getNumeroDePortas());
    }
}