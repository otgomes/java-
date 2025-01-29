class Moto extends Veiculo{

    private boolean temSidecar; // Indica se a moto possui um sidecar.

    public Moto(String marca, String modelo, int ano, boolean temSidecar) {
        super(marca, modelo, ano);
        this.temSidecar = temSidecar;
    }

    public boolean getTemSideCar() {
        return temSidecar;
    }

    public void setTemSideCar(boolean temSidecar) {
        this.temSidecar = temSidecar;
    }

    public void exibirDetalhes() {
        System.out.println("Marca: " + getMarca() + ", Modelo: " + getModelo() + ", Ano: " + getAno() + ", Tem Side Car: " + getTemSideCar());
    }
}