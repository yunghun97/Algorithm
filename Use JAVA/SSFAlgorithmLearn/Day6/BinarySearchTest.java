package SSFAlgorithmLearn.Day6;

import java.util.Arrays;

public class BinarySearchTest {
    public static void main(String[] args) {
        int[] arr = {10,4,6,20,35,7};
        Arrays.sort(arr);
        System.out.println(BinarySearch(arr, 6));
        System.out.println(BinarySearch(arr, 35));
        System.out.println(BinarySearch(arr, 50));

        System.out.println(Arrays.binarySearch(arr, 6));
        System.out.println(Arrays.binarySearch(arr, 35));
        System.out.println(Arrays.binarySearch(arr, 77));
    }
    static int BinarySearch(int[] arr, int key){
        int start = 0, end = arr.length-1;
        
        while(start<=end){
            int mid = (start+end)/2; // 중간위치
            if(arr[mid]==key) return mid;
            else if(arr[mid]<key){ // 키가 더 크므로 오른쪽 블록으로가기위해 종료점을 기준점 +1;
                start = mid+1;
            }else{  // 키가 더 작으므로 왼쪽 블록으로 가기위해 종료점을 기준점 -1
                end = mid-1;
            }
            
        }
        // 못 찾았을때
        return -1;
    }
}
