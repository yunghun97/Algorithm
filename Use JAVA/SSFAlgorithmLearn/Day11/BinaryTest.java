package SSFAlgorithmLearn.Day11;
import java.util.Arrays;
public class BinaryTest {
    public static void main(String[] args) {
        int[] values = {3,7,11,11,15,20,21,45} ;
        System.out.println(Arrays.binarySearch(values, 3));
        System.out.println(Arrays.binarySearch(values, 11));
        // System.out.println(Arrays.binarySearch(values, 11));
        // System.out.println(Arrays.binarySearch(values, 30));
        // System.out.println(Arrays.binarySearch(values, 1));
        // System.out.println(Arrays.binarySearch(values, 50));

        // System.out.println(Arrays.binarySearch(values, 1, 4, 45));
        // System.out.println(Arrays.binarySearch(values, 0, 0, 45));
    }
}
