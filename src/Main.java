import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Word[] words = new Word[]{
                new Word("cafe", "comida"),
                new Word("arroz", "comida"),
                new Word("cachorro", "animal")
        };

        Random random = new Random();
        int randomIndex = random.nextInt(words.length);
        Word randomWord = words[randomIndex];

        Player player = new Player(5);
        Game game = new Game(player, randomWord);

        while (GameState.IN_GAME.equals(game.state)) {
            System.out.println("** Jogo da forca **");
            System.out.println();

            System.out.println("Categoria: " + game.word.category);
            System.out.println();

            System.out.println("Vidas: " + game.player.lives);
            System.out.println("Letras usadas: " + game.usedLettersAsString());
            System.out.println();

            System.out.println("A palavra é: " + game.wordAsString());
            System.out.println("Faça uma jogada: ");
            String input = scanner.nextLine();

            Letter letter = new Letter(input.charAt(0));
            game.play(letter);
        }
        if (GameState.WIN.equals(game.state)){
            System.out.println("Você ganhou! A palavra era: " + game.word);
        } else {
            System.out.println("Você perdeu!");
        }
        scanner.close();
    }
}