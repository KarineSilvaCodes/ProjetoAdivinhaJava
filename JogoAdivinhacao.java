import java.util.Scanner;

public class JogoAdivinhacao {

    public static void main(String[] args) {
        Jogo meuJogo = new Jogo();

        Scanner leitor = new Scanner(System.in);
        String respostaDoJogo;

        System.out.println("Eu pensei em um número entre 1 e 100.");
        System.out.println("Você tem 10 tentativas.");

        while (true) {
            System.out.print("Qual seu palpite? ");
            int palpite = leitor.nextInt();

            respostaDoJogo = meuJogo.fazerPalpite(palpite);

            if (respostaDoJogo.equals("ACERTOU")) {
                System.out.println("Parabéns! Você acertou!");
                break;
            }

            if (respostaDoJogo.equals("PERDEU")) {
                System.out.println("Que pena! Você usou todas as suas tentativas.");
                int numeroCerto = meuJogo.getNumeroSecreto();
                System.out.println("O número secreto era: " + numeroCerto);
                break;
            }

            if (respostaDoJogo.equals("MUITO_BAIXO")) {
                System.out.println("Muito baixo!");
            }

            if (respostaDoJogo.equals("MUITO_ALTO")) {
                System.out.println("Muito alto!");
            }

            int tent = 10 - meuJogo.getNumeroDeTentativas();
            System.out.println("(Você tem " + tent + " tentativas restantes)");
        }

        leitor.close();
    }
}