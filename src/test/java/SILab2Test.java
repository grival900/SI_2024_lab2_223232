import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;
import java.util.ArrayList;

public class SILab2Test {

    @Test
    public void testCheckCartEveryBranch() {
        // Test Case 1: Null List Test
        RuntimeException ex = assertThrows(RuntimeException.class, () -> SILab2.checkCart(null, 0));
        assertEquals("allItems list can't be null!", ex.getMessage());

        // Test Case 2: Empty List Test
        assertTrue(SILab2.checkCart(new ArrayList<>(), 0));

        // Test Case 3: Item with Null Name Test
        List<Item> items = new ArrayList<>();
        items.add(new Item(null, "123456", 100, 0));
        assertTrue(SILab2.checkCart(items, 100));

        // Test Case 4: Item with Empty Name Test
        items.clear();
        items.add(new Item("", "123456", 100, 0));
        assertTrue(SILab2.checkCart(items, 100));

        // Test Case 5: Item with Null Barcode Test
        items.clear();
        items.add(new Item("Item1", null, 100, 0));
        ex = assertThrows(RuntimeException.class, () -> SILab2.checkCart(items, 100));
        assertEquals("No barcode!", ex.getMessage());

        // Test Case 6: Item with Invalid Barcode Character Test
        items.clear();
        items.add(new Item("Item1", "12a456", 100, 0));
        ex = assertThrows(RuntimeException.class, () -> SILab2.checkCart(items, 100));
        assertEquals("Invalid character in item barcode!", ex.getMessage());

        // Test Case 7: Item with Discount Test
        items.clear();
        items.add(new Item("Item1", "123456", 100, 0.1f));
        assertTrue(SILab2.checkCart(items, 90));

        // Test Case 8: Item without Discount Test
        items.clear();
        items.add(new Item("Item1", "123456", 100, 0));
        assertTrue(SILab2.checkCart(items, 100));

        // Test Case 9: Item with Special Discount Test
        items.clear();
        items.add(new Item("Item1", "012345", 350, 0.1f));
        assertTrue(SILab2.checkCart(items, 305));

        // Test Case 10: Sum Greater than Payment Test
        items.clear();
        items.add(new Item("Item1", "123456", 100, 0));
        assertFalse(SILab2.checkCart(items, 50));
    }

    @Test
    public void testCheckCartMultipleCondition() {
        // Case 1: (True, True, True)
        List<Item> items = new ArrayList<>();
        items.add(new Item("Item1", "012345", 350, 0.1f));
        assertTrue(SILab2.checkCart(items, 305), "Expected true for (True, True, True) case");

        // Case 2: (True, True, False)
        items.clear();
        items.add(new Item("Item1", "112345", 350, 0.1f));
        assertTrue(SILab2.checkCart(items, 315), "Expected true for (True, True, False) case");

        // Case 3: (True, False, True)
        items.clear();
        items.add(new Item("Item1", "012345", 350, 0));
        assertTrue(SILab2.checkCart(items, 350), "Expected true for (True, False, True) case");

        // Case 4: (True, False, False)
        items.clear();
        items.add(new Item("Item1", "112345", 350, 0));
        assertTrue(SILab2.checkCart(items, 350), "Expected true for (True, False, False) case");

        // Case 5: (False, True, True)
        items.clear();
        items.add(new Item("Item1", "012345", 250, 0.1f));
        assertTrue(SILab2.checkCart(items, 225), "Expected true for (False, True, True) case");

        // Case 6: (False, True, False)
        items.clear();
        items.add(new Item("Item1", "112345", 250, 0.1f));
        assertTrue(SILab2.checkCart(items, 225), "Expected true for (False, True, False) case");

        // Case 7: (False, False, True)
        items.clear();
        items.add(new Item("Item1", "012345", 250, 0));
        assertTrue(SILab2.checkCart(items, 250), "Expected true for (False, False, True) case");

        // Case 8: (False, False, False)
        items.clear();
        items.add(new Item("Item1", "112345", 250, 0));
        assertTrue(SILab2.checkCart(items, 250), "Expected true for (False, False, False) case");
    }

}
