package animals;

import animals.model.AnimalFactory;
import org.junit.Test;
import org.mockito.InOrder;
import java.io.PrintStream;

import static org.mockito.Mockito.*;

public class CodingAnimalPrinterTest {
    @Test
    public void print_printsWhatWeExpect() {
        PrintStream mockedInputStream = mock(PrintStream.class);
        InOrder orderChecker = inOrder(mockedInputStream);
        CodingAnimalPrinter printer =
                CodingAnimalPrinter.instance(AnimalFactory.instance(), mockedInputStream);

        printer.print();

        orderChecker.verify(mockedInputStream)
            .println("There are 1 coding animals. Their average position above sea is 69 meters.");
        orderChecker.verify(mockedInputStream)
            .println("The Coding Nagger has an average position above sea is 69 meters.");
    }
}