package m2.e1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

public class GraphBuilder implements Callable<Set<GoField>> {

    private final ExecutorService executorService;

    private final Figure nextFigure;

    private final GoField currentField;

    private final int deepLevel;

    public GraphBuilder(
            final ExecutorService executorService,
            final Figure currentFigure,
            final GoField currentField,
            final int deepLevel) {
        this.executorService = executorService;
        this.currentField = currentField;
        this.nextFigure = currentFigure == Figure.WHITE ? Figure.BLACK : Figure.WHITE;
        this.deepLevel = deepLevel;
    }

    @Override
    public Set<GoField> call() {
        // BEGIN (write your solution here) #1

        // END #1
        // BEGIN (write your solution here) #2

        // END #2
        // BEGIN (write your solution here) #3

        // END #3
        // BEGIN (write your solution here) #4

        // END #4
    }

    private boolean isAsync() {
        return deepLevel <= 2;
    }

    private boolean isCurrentFieldFinal() {
        for (Figure[] line : currentField.figures) {
            for (Figure figure : line) {
                if (figure == null) {
                    return false;
                }
            }
        }
        return true;
    }
}
