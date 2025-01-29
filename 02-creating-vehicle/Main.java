public class Main {

    public static void main(String[] args) {
        // Cria um novo carro
        Carro meuCarro = new Carro("BMW", "Unico", 2020, 4);

        // Cria uma nova moto
        Moto minhaMoto = new Moto("Yamaha", "150cc", 2010, true);

        // Exibe detalhes do carro
        meuCarro.exibirDetalhes();

        // Exibe detalhes da moto
        minhaMoto.exibirDetalhes();
    }
}