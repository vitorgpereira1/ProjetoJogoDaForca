public class Game {
    Letter[] usedLetters;
    Player player;
    Word word;

    public Game (Player player, Word word){
        this.player = player;
        this.word = word;
        this.usedLetters = new Letter[26];
    }
    public String usedLettersAsString(){
        String result = "";
        for (int i = 0; i < usedLetters.length; i++){
            if (usedLetters[i] != null){
                result += usedLetters[i].value + ", ";
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

    }
}
