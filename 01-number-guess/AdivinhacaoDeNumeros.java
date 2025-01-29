package ATV1_PS1;

import java.util.Random;
import java.util.Scanner;

public class AdivinhacaoDeNumeros {
    private int min;
    private int max;
    private int numeroSecreto;
    private int contadorTentativas;
    private Scanner scanner;

    public AdivinhacaoDeNumeros() {
        scanner = new Scanner(System.in);
        contadorTentativas = 0;
    }

    public void iniciarJogo() {
        System.out.println("🎮 Bem-vindo ao Jogo de Adivinhação de Números! 🎮");
        escolherIntervalo();
        gerarNumeroSecreto();
        System.out.println("Eu escolhi um número entre " + min + " e " + max + ". Tente adivinhar!");
        jogar();
    }

    private void escolherIntervalo() {
        min = solicitarNumero("Defina o valor mínimo do intervalo: ");
        max = solicitarNumero("Defina o valor máximo do intervalo: ");

        // Verifica se min é menor que max, caso contrário pede novamente
        while (min >= max) {
            System.out.println("⚠️ O valor mínimo deve ser menor que o valor máximo. Tente novamente.");
            min = solicitarNumero("Defina o valor mínimo do intervalo: ");
            max = solicitarNumero("Defina o valor máximo do intervalo: ");
        }
    }

    private int solicitarNumero(String mensagem) {
        int numero = 0;
        boolean entradaValida = false;

        while (!entradaValida) {
            System.out.print(mensagem);
            String entrada = scanner.next();

            try {
                numero = Integer.parseInt(entrada);
                entradaValida = true;  
            } catch (NumberFormatException e) {
                System.out.println("⚠️ Entrada inválida! Por favor, insira um número inteiro.");
            }
        }

        return numero;
    }


    private void gerarNumeroSecreto() {
        Random random = new Random();
        numeroSecreto = random.nextInt(max - min + 1) + min;
    }

    private void jogar() {
        boolean acertou = false;

        while (!acertou) {
            String tentativa = solicitarTentativa();

            if (tentativa.equalsIgnoreCase("s")) {
                System.out.println("👋 Você saiu do jogo. O número era: " + numeroSecreto);
                break;
            }

            try {
                int tentativaNumero = Integer.parseInt(tentativa);

                if (tentativaNumero < min || tentativaNumero > max) {
                    System.out.println("⚠️ O número deve estar entre " + min + " e " + max + ". Tente novamente.");
                    continue;
                }

                contadorTentativas++;

                if (tentativaNumero < numeroSecreto) {
                    System.out.println("🔼 O número é maior.");
                } else if (tentativaNumero > numeroSecreto) {
                    System.out.println("🔽 O número é menor.");
                } else {
                    acertou = true;
                    System.out.println("🎉 Parabéns! Você adivinhou o número em " + contadorTentativas + " tentativas.");
                }
            } catch (NumberFormatException e) {
                System.out.println("⚠️ Entrada inválida! Por favor, insira um número inteiro ou 's' para sair.");
            }
        }

        if (acertou) {
            System.out.println("🏁 Fim do jogo! Você acertou o número!");
        } else {
            System.out.println("📝 Obrigado por jogar!");
        }
    }


    private String solicitarTentativa() {
        String tentativa = "";
        boolean entradaValida = false;

        while (!entradaValida) {
            System.out.print("\nDigite sua tentativa (ou 's' para sair):  ");
            tentativa = scanner.next();

            if (tentativa.equalsIgnoreCase("s")) {
                entradaValida = true; 
            } else {
                entradaValida = true;
            }
        }

        return tentativa;
    }

    public void fecharScanner() {
        scanner.close();
    }

}