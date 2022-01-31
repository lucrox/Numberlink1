import gloo.numberlink.model.*;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class TestPath {

    @Mock
    Cell mockedCell;

    @Mock
    Tag mockedTag;

    @Test
    void testAddCell() {
        Path path = new Path(mockedTag);
        path.addCell(mockedCell);
        assertSame(mockedCell, path.getLastCell());
    }

    @Test
    void testIsEndReached() {
        Cell mockedCellWithEnd = mock(Cell.class);
        when(mockedCellWithEnd.hasEnd()).thenReturn(true);
        Cell mockedCellWithoutEnd = mock(Cell.class);
        when(mockedCellWithoutEnd.hasEnd()).thenReturn(false);
        Path path = new Path(mockedTag);

        path.addCell(mockedCell);
        /* The path hasn't encountered second path with end yet */
        assertFalse(path.isEndReached());

        path.addCell(mockedCellWithoutEnd);
        /* The path hasn't encountered second path with end yet */
        assertFalse(path.isEndReached());

        path.addCell(mockedCellWithEnd);
        /* The path has an initial cell and an end cell, both with an End */
        assertTrue(path.isEndReached());
    }

    @Test
    void testAdvance() {
        Path path = new Path(mockedTag);
        Cell mockedCell = mock(Cell.class);
        Cell mockedNeighbor = mock(Cell.class);
        when(mockedCell.getNeighbor(Direction.RIGHT)).thenReturn(mockedNeighbor);
        when(mockedNeighbor.acceptPath(path)).thenAnswer(invocation -> {
            path.addCell(mockedNeighbor);
            return true;
        });

        path.addCell(mockedCell);
        path.advance(Direction.RIGHT);
        assertSame(mockedNeighbor, path.getLastCell());
    }
}
