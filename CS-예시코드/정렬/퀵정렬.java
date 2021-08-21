package 정렬;

import java.util.Arrays;

public class 퀵정렬 {
    public static void main(String[] args) {
        int[] arr = {8,7,6,4,2,3,9};
        sort(arr, 0, arr.length-1);
        System.out.println("결과 : " + Arrays.toString(arr));
    }
    static void sort(int[] arr, int start, int end){
        if(start>=end) return;   // 1칸이 되었으므로 -> 비교 대상이 없어짐 -> 마지막까지 쪼개졌다는 뜻
        
        int mid = partition(arr,start,end);
        System.out.println("시작 : "+ start+" 종료 :  " + end +" mid "+mid);
        sort(arr, start, mid-1); 
        sort(arr, mid, end);
    }
    static int partition(int[] arr, int start, int end){
        int pivot = arr[(start+end)/2];  // 중간을 pivot으로 지정
        System.out.print("pivot : "+pivot+" ");
        if(start==end) return start;    // 자기 자신일때는 돌지 않는다 -> 1칸일 때 안 돌겠다.
        else{
        while(start<=end){ //시작부터 끝까지 돌겠다.
            while(arr[start]<pivot) start++;
            while(arr[end] > pivot) end--;
            if(start<=end){
                System.out.println("swap전 : "+ Arrays.toString(arr));
                swap(arr,start,end);
                System.out.println(Arrays.toString(arr));
                start++;
                end--;
            }
        }
        //System.out.println("한 번 다 돔 : "+ Arrays.toString(arr));
        return start;
        }
    }
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
