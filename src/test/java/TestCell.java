import gloo.numberlink.model.Cell;
import gloo.numberlink.model.Grid;
import gloo.numberlink.model.Path;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class TestCell {

    /**
     * An newly instantiated cell should be available for being added to paths.
     */
    @Test
    void testAvailabilityGenericCell() {
        Grid grid = mock(Grid.class);
        Cell cell = new Cell(grid);
        assertEquals(false, cell.hasPath()); // The cell doesn't have path after instantiation.

        Path path = mock(Path.class);
        Boolean isPathAccepted = cell.acceptPath(path); // The cell should be available.
        assertEquals(true, isPathAccepted);
    }
}
