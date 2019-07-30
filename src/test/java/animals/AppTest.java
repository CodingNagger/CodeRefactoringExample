package animals;

import animals.model.AnimalFactory;
import org.junit.Test;
import org.mockito.InOrder;

import java.io.PrintStream;

import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.mock;

public class AppTest {
    @Test
    public void run_printsWhatsExpected() {
        PrintStream mockedInputStream = mock(PrintStream.class);
        InOrder orderChecker = inOrder(mockedInputStream);
        App app = new App(AnimalFactory.instance(), mockedInputStream);

        app.run();

        orderChecker.verify(mockedInputStream)
            .println("There are 2 land animals. Their average position above sea is 12 meters.");
        orderChecker.verify(mockedInputStream)
            .println("The Doggo has an average position above sea is 10 meters.");
        orderChecker.verify(mockedInputStream)
            .println("The Spider has an average position above sea is 2 meters.");
        orderChecker.verify(mockedInputStream)
            .println("There are 2 sea animals. Their average position above sea is -20100 meters.");
        orderChecker.verify(mockedInputStream)
            .println("The Blue Fish has an average position above sea is -100 meters.");
        orderChecker.verify(mockedInputStream)
            .println("The Kraken has an average position above sea is -20000 meters.");
        orderChecker.verify(mockedInputStream)
            .println("There are 1 coding animals. Their average position above sea is 69 meters.");
        orderChecker.verify(mockedInputStream)
            .println("The Coding Nagger has an average position above sea is 69 meters.");
    }
}
