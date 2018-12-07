package abstractbyhaldsorter;

import abstractbubblesorter.AbstractBubbleSorter;

/**
 * @author Lova Vardanian
 * @version 1.1
 * @since 1.1
 * <p>
 * This is an abstract class that extends {@link AbstractBubbleSorter}
 * <br> This abstract class include 4 abstract methods for sorting by different sorts by dividing inputArray by half
 * <ul>
 *   <li> method sort - for sort using class {@link bubblesort.BubbleSort#sort(int[])}
 *   <li> method reverseSort - for reverseSort using class {@link bubblesort.BubbleSort#reverseSort(int[])}
 *   <li> method qsort - for sort using class {@link qsort.Qsort#sort(int[])}
 *   <li> method arraysSort - for sort using class {@link myarrays.MyArrays#sort(int[])}
 * </ul>
 *</p>
 */
public abstract class AbstractByHalfSorter extends AbstractBubbleSorter {

    public abstract void qsort(int[] inputArray);
    public abstract void arraysSort(int[] inputArray);

}
