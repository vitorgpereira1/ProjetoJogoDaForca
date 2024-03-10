import java.util.Arrays;

public class Word {
    Letter[]  letters;
    String category;

    public Word (String word, String category){
        this.category = category;
        this.letters = new Letter[word.length()];
        for(int i = 0; i < word.length(); i++){
            Character character = word.charAt(i);
            Letter letter = new Letter(character);
            this.letters[i] = letter;
        }
    }

    @Override
    public String toString() {
        String result = "";
        for (int i = 0; i < letters.length; i++){
            result += letters[i].value.toString();
        }
        return result;
    }
}
