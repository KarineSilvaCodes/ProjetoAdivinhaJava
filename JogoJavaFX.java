import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.lang.NumberFormatException;

public class JogoJavaFX extends Application {

    private Jogo meuJogo= new Jogo();

    @Override
    public void start(Stage primaryStage) {

        primaryStage.setTitle("Jogo de Adivinhação");

        Label labelInstrucao = new Label("Eu pensei em um número (1-100).");

        Label labelResultado = new Label("Você tem 10 chances. Boa sorte!");

        TextField campoPalpite = new TextField();
        campoPalpite.setPromptText("Digite seu palpite aqui"); // fica como um texto fantasma
        campoPalpite.setMaxWidth(200);

        Button botaoAdivinhar = new Button("Adivinhar!");

        VBox layout = new VBox();
        layout.setSpacing(10);
        layout.setAlignment(Pos.CENTER);
        layout.setPadding(new Insets(20));

        layout.getChildren().addAll(labelInstrucao, campoPalpite, botaoAdivinhar, labelResultado);

        botaoAdivinhar.setOnAction( event -> {

            try {
                String textoDoPalpite = campoPalpite.getText();
                int palpite = Integer.parseInt(textoDoPalpite);

                String resposta = meuJogo.fazerPalpite(palpite);

                if (resposta.equals("ACERTOU")) {
                    labelResultado.setText("Parabéns! Você acertou!");
                    labelResultado.setStyle("-fx-text-fill: green; -fx-font-weight: bold;");
                    botaoAdivinhar.setDisable(true);
                    campoPalpite.setDisable(true);

                } else if (resposta.equals("PERDEU")) {
                    int numeroCerto = meuJogo.getNumeroSecreto();
                    labelResultado.setText("Que pena! O número era: " + numeroCerto);
                    labelResultado.setStyle("-fx-text-fill: red; -fx-font-weight: bold;");
                    botaoAdivinhar.setDisable(true);
                    campoPalpite.setDisable(true);

                } else if (resposta.equals("MUITO_BAIXO")) {

                    int restantes = 10 - meuJogo.getNumeroDeTentativas();
                    labelResultado.setText("Muito baixo! Tente um número maior. (" + restantes + " chances)");

                } else if (resposta.equals("MUITO_ALTO")) {

                    int restantes = 10 - meuJogo.getNumeroDeTentativas();
                    labelResultado.setText("Muito alto! Tente um número menor. (" + restantes + " chances)");
                }

                campoPalpite.clear();

            } catch (NumberFormatException e) {

                labelResultado.setText("Erro: Por favor, digite apenas números.");
                labelResultado.setStyle("-fx-text-fill: red;");
            }
        });

        Scene cena = new Scene(layout, 350, 250);
        primaryStage.setScene(cena);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

   