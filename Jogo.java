import java.util.Random;

public class Jogo {

    private int numeroSecreto;
    private int numeroDeTentativas;
    private int maximoDeTentativas;
    private boolean jogoTerminou;

    public Jogo() {
        this.maximoDeTentativas = 10;
        this.numeroDeTentativas = 0;
        this.jogoTerminou = false;

        Random gerador = new Random();
        this.numeroSecreto = gerador.nextInt(100) + 1;
    }

    public String fazerPalpite(int palpite) {
        
        if (this.jogoTerminou) {
            return "O JOGO JÁ TERMINOU.";
        }

        this.numeroDeTentativas++;

        if (palpite == this.numeroSecreto) {
            this.jogoTerminou = true;
            return "ACERTOU";
        }

        if(this.numeroDeTentativas >= this.maximoDeTentativas) {
            this.jogoTerminou = true;
            return "PERDEU";
        }

        if (palpite < this.numeroSecreto) {
            return "MUITO_BAIXO";           
        } else {
            return "MUITO_ALTO";
        }
    }

    public int getNumeroDeTentativas() {
        return this.numeroDeTentativas; 
    }

    public int getNumeroSecreto() {
        if (this.jogoTerminou) {
            return this.numeroSecreto;
        }
        return -1; 
    }
}