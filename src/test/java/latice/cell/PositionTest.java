package latice.cell;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;

public class PositionTest {

    @Test
    public void testGetX() {
        Position position = new Position(3, 5);
        assertEquals(3, position.x());
    }

    @Test
    public void testGetY() {
        Position position = new Position(3, 5);
        assertEquals(5, position.y());
    }

    @Test
    public void testEqualsDifferentObjectSameValues() {
        Position position1 = new Position(4, 7);
        Position position2 = new Position(4, 7);
        assertEquals(position1, position2);
    }

    @Test
    public void testEqualsDifferentValues() {
        Position position1 = new Position(4, 7);
        Position position2 = new Position(7, 4);
        assertNotEquals(position1, position2);
    }

    @Test
    public void testEqualsNull() {
        Position position = new Position(1, 1);
        assertNotEquals(null, position);
    }

    @Test
    public void testHashCodeEqualObjects() {
        Position position1 = new Position(2, 3);
        Position position2 = new Position(2, 3);
        assertEquals(position1.hashCode(), position2.hashCode());
    }
}