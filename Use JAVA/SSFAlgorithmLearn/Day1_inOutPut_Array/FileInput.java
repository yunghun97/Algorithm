package SSFAlgorithmLearn.Day1_inOutPut_Array;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileInput {
    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("Use JAVA\\SSAFYAlgorithmLearn\\Day1_inOutPut_Array\\input.txt"));
        Scanner sc = new Scanner(System.in);
        System.out.printf(sc.nextLine());
        sc.close();
    }
}
