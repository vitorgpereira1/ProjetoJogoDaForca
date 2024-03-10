import java.util.Objects;

public class Letter {
    Character value;
    boolean visible;

    public Letter (Character character){
        this.value = character;
        this.visible = false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Letter letter = (Letter) o;
        return Objects.equals(value, letter.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
    @Override
    public String toString (){
        return value.toString();
    }
}
