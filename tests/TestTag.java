import gloo.numberlink.model.Path;
import gloo.numberlink.model.Tag;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestTag {

    /**
     * The constructor must not return a null object.
     */
    @Test
    void testNotNull() {
        Tag tag = new Tag(1);
        assertNotNull(tag);
    }

    @Test
    void testGetLabel() {
        Tag tag = new Tag(5);
        assertEquals("5", tag.getLabel());
    }

    /**
     * Two tags objects with the same label are considered to be equal.
     */
    @Test
    void testEquals() {
        Tag thisTag = new Tag(1);
        Tag otherTag = new Tag(1);
        assertEquals(thisTag, otherTag);
    }
}
