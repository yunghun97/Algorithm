package SSAFYAlgorithmLearn.Day1_inOutPut_Array;

public class 재귀_배열출력 {
    public static void main(String[] args) {
        int[] arr = {10,20,30,40};  
        int i = 0;  
        print(arr,i);    
    }

    private static void print(int[] arr, int i) {
        if(i==arr.length) return;
        System.out.println(arr[i]);
        i++;
        print(arr, i);
    }
}
