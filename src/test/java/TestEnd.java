import gloo.numberlink.model.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class TestEnd {

    @Test
    void testGetTag() {
        Tag mockedTag = mock(Tag.class);
        End end = new End(mockedTag);
        assertSame(end.getTag(), mockedTag);
    }

    @Test
    void testGetLabel() {
        Tag mockedTag = mock(Tag.class);
        String mockedLabel = "x";
        when(mockedTag.getLabel()).thenReturn(mockedLabel);
        End end = new End(mockedTag);
        assertEquals(mockedLabel, end.getLabel());
    }

    @Test
    void testCreateNewPath() {
        Tag mockedTag = mock(Tag.class);
        Path mockedPath = mock(Path.class);
        when(mockedTag.createNewPath()).thenReturn(mockedPath);

        End end = new End(mockedTag);
        assertSame(mockedPath, end.createNewPath());
    }
}
