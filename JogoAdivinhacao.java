import java.util.Random;
import java.util.Scanner;

public class JogoAdivinhacao {

    public static void main(String[] args) {
        
    Random gerador = new Random();
    int numeroSecreto = gerador.nextInt(100) + 1;
    Scanner leitor = new Scanner(System.in);
    
    // System.out.println("O número secreto é: " + numeroSecreto);

    int palpite = 0;
    
    System.out.println("Eu pensei em um número entre 1 e 100.");

    do {
        System.out.print("Tente adivinhar qual é: "); 
        palpite = leitor.nextInt();
        
        // 4. A lógica de dicas (Etapa 4) vem para DENTRO do loop
        if (palpite < numeroSecreto) {
            System.out.println("Muito baixo!");
        } else if (palpite > numeroSecreto) {
            System.out.println("Muito alto!");
        }

    } while (palpite != numeroSecreto);
    
    System.out.println("Parabéns! Você acertou!");

}

}