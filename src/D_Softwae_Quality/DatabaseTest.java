package D_Softwae_Quality;

import org.junit.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

public class DatabaseTest {

    private static Database db;
    private static List<String> storage;

    @BeforeClass
    public static void startup() {
        db = new Database();
        storage = new ArrayList<String>();
        db.setStorage(storage);
    }

    @AfterClass
    public static void shutdown() {
        db = null;
        storage = null;
    }

    @Before
    public void setup() {
        db.open();
    }

    @After
    public void teardown() {
        db.close();
    }

    @Test
    public void normalTest() {
        String name = "Ali Alavi";
        db.insert(name);
        assertTrue(storage.contains(name));
        db.delete(name);

        assertFalse(storage.contains(name));
    }

    @Test
    public void testNullValue() {
        db.insert(null);
        assertTrue(storage.contains(null));
        assertEquals(1, storage.size());
    }

}