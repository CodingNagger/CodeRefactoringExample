package animals;

import animals.model.AnimalFactory;
import org.junit.Test;
import org.mockito.InOrder;

import java.io.PrintStream;

import static org.mockito.Mockito.*;

public class SeaAnimalPrinterTest {
    @Test
    public void print_printsWhatWeExpect() {
        PrintStream mockedInputStream = mock(PrintStream.class);
        InOrder orderChecker = inOrder(mockedInputStream);
        SeaAnimalPrinter printer = SeaAnimalPrinter.instance(AnimalFactory.instance(), mockedInputStream);

        printer.print();

        orderChecker.verify(mockedInputStream).println("There are 2 land animals. Their average position above sea is -20100 meters.");
        orderChecker.verify(mockedInputStream).println("The Blue Fish has an average position above sea is -100 meters.");
        orderChecker.verify(mockedInputStream).println("The Kraken has an average position above sea is -20000 meters.");
    }
}
