package m2.e1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.*;

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
        final List<Future<Set<GoField>>> futures = new ArrayList<>();
        final Set<GoField> finalGoField = new CopyOnWriteArraySet<>();

        // END #1
        // BEGIN (write your solution here) #2
        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {
                if (currentField.figures[x][y] != null) {
                    continue;
                }
                final GoField newField = new GoField(currentField);
                newField.figures[x][y] = nextFigure;
                if (this.isCurrentFieldFinal()) {

                    finalGoField.add(newField);
                }

                final GraphBuilder graphBuilder = new GraphBuilder(
                        executorService,
                        nextFigure,
                        newField,
                        deepLevel + 1);
                if (isAsync()) {
                    final Future<Set<GoField>> future = executorService.submit(graphBuilder);
                    futures.add(future);
                } else {
                    finalGoField.add((GoField) graphBuilder.call());

                }
            }

        }
        if (!futures.isEmpty())  {
            for (Future<Set<GoField>> future : futures) {
                try {
                    finalGoField.add((GoField) future.get());
                } catch (InterruptedException | ExecutionException e) {
                    throw new RuntimeException(e);
                }
            }

        }

        // END #2
        // BEGIN (write your solution here) #3



        // END #3
        // BEGIN (write your solution here) #4
        return finalGoField;


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
