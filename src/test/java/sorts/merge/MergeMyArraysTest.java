package sorts.merge;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

import static org.junit.Assert.*;

public class MergeMyArraysTest {

    MergeMyArrays2 mergeMyArrays = new MergeMyArrays2();

    int[] sortedArr = {0, 1, 2, 2, 3, 5, 7, 9, 11, 22};
    int[] arr = {3, 2, 11, 1, 0, 7, 22, 5, 9, 2};

    int[] oneElement = { 1 };

    @Before
    public void setUp() {
        System.out.println("START");
    }

    @After
    public void tearDown() {
        System.out.println("END");
    }

    @Rule
    public Timeout timeout = new Timeout(100);

    @Test
    public void sort() {

        mergeMyArrays.sort(arr);
        assertArrayEquals(sortedArr, arr);

        mergeMyArrays.sort(oneElement);
        assertNotNull(oneElement);
    }
}