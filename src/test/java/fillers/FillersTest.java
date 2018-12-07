package fillers;

import fillers.Fillers;
import org.junit.*;
import org.junit.rules.Timeout;

import static org.junit.Assert.*;


public class FillersTest {

    Fillers fillers = new Fillers();


    int arrSize;
    int [] arr;

    @Rule
    public Timeout timeout = new Timeout(100);

    @Before
    public void setUp() {
        System.out.println("Start");
        arrSize = 1_000_000;
    }

    @After
    public void tearDown() {
        System.out.println("End");
        arr = null;
    }

    @Test
    public void sort() {

        assertTrue(arrSize > 0);
        arr = Fillers.randArray(arrSize);

        assertNotNull(arr);
        assertEquals(arrSize, arr.length);

    }

    @Test
    public void randLastElement() {

        assertTrue(arrSize > 0);
        arr = Fillers.randArray(arrSize);

        assertNotNull(arr);
        assertEquals(arrSize, arr.length);

    }

    @Test
    public void reverseSort() {

        assertTrue(arrSize > 0);
        arr = Fillers.randArray(arrSize);

        assertNotNull(arr);
        assertEquals(arrSize, arr.length);

    }


    @Test
    public void randArray() {

        assertTrue(arrSize > 0);
        arr = Fillers.randArray(arrSize);

        assertNotNull(arr);
        assertEquals(arrSize, arr.length);

    }
}