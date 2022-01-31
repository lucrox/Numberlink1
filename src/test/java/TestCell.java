import gloo.numberlink.model.*;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class TestCell {

    @Mock
    End mockedEnd;

    @Mock
    Grid mockedGrid;

    @Mock
    Tag mockedTag;

    @Mock
    Path mockedPath;

    /**
     * A newly instantiated cell should be available for being added to paths.
     */
    @Test
    void testAvailabilityGenericCell() {
        Cell cell = new Cell(mockedGrid);
        assertFalse(cell.hasPath()); // The cell doesn't have path after instantiation.

        Path mockedPath = mock(Path.class);
        assertTrue(cell.acceptPath(mockedPath)); // The cell should be available.
        assertTrue(cell.hasPath()); // The cell now has a path.
        assertFalse(cell.acceptPath(mockedPath));
    }


    @Test
    void testAvailabilityInitiallyNumberedCell() {

        End mockedEnd = mock(End.class);
        when(mockedEnd.getTag()).thenReturn(mockedTag);

        Path mockedPath = mock(Path.class);
        when(mockedPath.getTag()).thenReturn(mockedTag);

        Cell cell = new Cell(mockedGrid, mockedEnd);
        /* An initially numbered cell should be able to accept path with same End */
        assertFalse(cell.hasPath());
        assertTrue(cell.acceptPath(mockedPath));
        /* A cell should not accept multiple paths at the same time */
        assertFalse(cell.acceptPath(mock(Path.class)));

        cell = new Cell(mockedGrid, mockedEnd);
        Path path = mock(Path.class);
        when(path.getTag()).thenReturn(mock(Tag.class));
        /* A cell should not accept path with a different tag */
        assertFalse(cell.acceptPath(path));
    }

    @Test
    void testCreateNewPath() {
        Cell cell = new Cell(mockedGrid);
        /* A cell without end should not be able to create a path */
        assertNull(cell.createNewPath());

        End mockedEnd = mock(End.class);
        Path mockedPath = mock(Path.class);
        when(mockedEnd.createNewPath()).thenReturn(mockedPath);
        cell = new Cell(mockedGrid, mockedEnd);
        /* A cell with an end should be able to create a path */
        assertNotNull(cell.createNewPath());
    }

}
