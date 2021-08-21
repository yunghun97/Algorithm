package 정렬;

import java.util.Arrays;

public class 선택정렬 { // 선택정렬  주어진 리스트에서 최솟값을 찾는다. -> 최솟값을 맨 앞 자리의 값과 교환한다. -> 교환한자리 제외하고 그 다음자리부터 마지막까지 반복
    public static void main(String[] args) {
        int arr[] = {6,5,4,3,2,1};

        for(int i=0; i<arr.length; i++){
            int min_index = i;
            for(int j = i+1; j<arr.length; j++){
                if(arr[j]<arr[min_index]){
                    min_index = j;
                }
            }
            swap(arr, min_index, i); // 배열, 최소 인덱스(j에서 최소값을 찾지 못하면 i값과 i를 스왑하므로 결과는 똑같아 진다.), i를 매개변수로 전달
        }
        System.out.println(Arrays.toString(arr));
    }
    static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}