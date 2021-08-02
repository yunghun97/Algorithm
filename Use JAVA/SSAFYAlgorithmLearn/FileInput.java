package SSAFYAlgorithmLearn;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileInput {
    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("input.txt"));
        Scanner sc = new Scanner(System.in);
    }
}
