package m2.e1;

import org.jetbrains.annotations.NotNull;

import java.util.Arrays;

public class GoField {

    static final int FIELD_SIZE = 3;

    final Figure[][] figures =  new Figure[FIELD_SIZE][FIELD_SIZE];

    GoField(){} // Standard constructor

    // BEGIN (write your solution here) Maybe you want to write a custom field constructor?

    public GoField(GoField currentGoField) {
        //System.arraycopy(currentGoField.figures,0, this.figures, currentGoField.figures.length);
        for (int i = 0; i < FIELD_SIZE; i++) {
            for (int j = 0; j < FIELD_SIZE; j++) {
                this.figures[i][j] = currentGoField.figures[i][j];
            }
        }
    }

    // END

    @Override//Необходимо для работы Set.
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        GoField goField = (GoField) o;

        return Arrays.deepEquals(figures, goField.figures);

    }

    @Override //Необходимо для работы Set.
    public int hashCode() {
        return Arrays.deepHashCode(figures);
    }

    @Override//Может поможет в отлове багов.
    public String toString() {
        return "GoField{figures=" + Arrays.deepToString(figures) + '}';
    }
}