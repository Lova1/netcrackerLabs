package abstracter;
import interfaces.Time;

/**
 * @author Lova Vardanian
 * @version 1.1
 * @since 1.1
 * <p>
 * This is an main abstract class that include only one abstract method sort
 * </p>
 */
public abstract class AbstractSorter implements Time {

    public abstract void sort(int[] inputArray);

}
