import java.util.Arrays;
import java.util.Comparator;

/**
 * A simple way to sort arrays using merge sort.
 *
 * @author YourName Here
 * @author Your NameHere
 * @author Samuel A. Rebelsky
 */
public class MergeSorter {

  // +------------------+--------------------------------------------
  // | Exported methods |
  // +------------------+

  /**
   * Sort an array using the merge sort algorithm.
   */
  public static <T> void sort(T[] vals, Comparator<? super T> comparator) {
    merge(vals, 0, vals.length / 2, vals.length, comparator);
  } // sort

  // +-----------------+---------------------------------------------
  // | Local utilities |
  // +-----------------+

  /**
   * Merge the values from positions [lo..mid) and [mid..hi) back into
   * the same part of the array.
   *
   * Preconditions: Each subarray is sorted accorting to comparator.
   */
  static <T> void merge(T[] vals, int lo, int mid, int hi, Comparator<? super T> comparator) {
    int loPointer = lo;
    int hiPointer = mid;

    T[] temp = Arrays.copyOf(vals, hi - lo);
    int i = 0;

    while (loPointer < mid || hiPointer < hi) {
      int comparison = comparator.compare(vals[loPointer], vals[hiPointer]); // -1, 0, 1

      if(comparison <= 0){
        temp[i] = vals[loPointer];
        loPointer++;
      }
      if(comparison > 0){
        temp[i] = vals[hiPointer];
        hiPointer++;
      }
      i++;
    }
  } // merge

} // class MergeSorter
