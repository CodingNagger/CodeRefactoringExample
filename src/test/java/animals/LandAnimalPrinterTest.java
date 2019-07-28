package animals;

import animals.model.AnimalFactory;
import org.junit.Test;
import org.mockito.InOrder;

import java.io.PrintStream;

import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.mock;

public class LandAnimalPrinterTest {
    @Test
    public void print_printsWhatWeExpect() {
        PrintStream mockedInputStream = mock(PrintStream.class);
        InOrder orderChecker = inOrder(mockedInputStream);
        LandAnimalPrinter printer = LandAnimalPrinter.instance(AnimalFactory.instance(), mockedInputStream);

        printer.print();

        orderChecker.verify(mockedInputStream).println("There are 2 land animals. Their average position above sea is 12 meters.");
        orderChecker.verify(mockedInputStream).println("The Doggo has an average position above sea is 10 meters.");
        orderChecker.verify(mockedInputStream).println("The Spider has an average position above sea is 2 meters.");
    }
}
