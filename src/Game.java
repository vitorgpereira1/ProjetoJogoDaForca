import java.util.ArrayList;
import java.util.List;

public class Game {
    List<Letter> usedLetters;
    Player player;
    Word word;
    GameState state;

    public Game (Player player, Word word){
        this.player = player;
        this.word = word;
        this.usedLetters = new ArrayList<>();
        this.state = GameState.IN_GAME;
    }
    public String usedLettersAsString(){
        String result = "";
        for (int i = 0; i < usedLetters.size(); i++){
            if (usedLetters.get(i) != null){
                result += usedLetters.get(i).value + ", ";
            }
        }
        return result;
    }

    public String wordAsString (){
        String result = "";
        for (int i = 0; i < word.letters.length; i++){
            if (word.letters[i].visible){
                result += word.letters[i];
            } else {
                result += " _ ";
            }
        }
        return result;
    }

    public void play (Letter letter){
        boolean alreadyUsed = false;
        for (int i = 0; i < usedLetters.size(); i++){
            if (letter.equals(usedLetters.get(i))){
                alreadyUsed = true;
                break;
            }
        }
        if (alreadyUsed){
            return;
        }
        boolean isValidLetter = false;
        for (int i = 0; i < word.letters.length; i++){
            if (letter.equals(word.letters[i])){
                isValidLetter = true;
                word.letters[i].visible = true;
            }
        }
        if (isValidLetter){
            boolean allVisible = true;
            for (int i = 0; i < word.letters.length; i++){
                if (!word.letters[i].visible){
                    allVisible = false;
                }
            }
            if (allVisible){
                state = GameState.WIN;
            }
        } else {
            player.lives --;
            if (player.lives == 0){
                state = GameState.LOSE;
            }
        }
        usedLetters.add(letter);
    }
}
