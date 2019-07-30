package animals;

import animals.model.AnimalFactory;
import org.junit.Test;
import org.mockito.Mockito;

import java.io.PrintStream;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class CodingAnimalPrinterTest {
    @Test
    public void print_printsTheSummaryWeExpect() {
        PrintStream mockedInputStream = mock(PrintStream.class);
        CodingAnimalPrinter printer =
                CodingAnimalPrinter.instance(AnimalFactory.instance(), mockedInputStream);

        printer.print();

        verify(mockedInputStream, Mockito.times(1)).println(
                "There are 0 coding animals. Their average position above sea is 0 meters.");
    }
}