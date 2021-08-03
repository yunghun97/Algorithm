package SSFAlgorithmLearn.Day2;

public class 이차원배열 {
    public static void main(String[] args) {
        int[][] arr = {
            {1,2,3,4},
            {5,6,7,8},
            {9,10,11,12},
            {13,14,15,16}};

        int R = arr.length;
        int C = arr[0].length;
        
        // 지그재그
        for(int i=0; i<R; i++){
            for(int j=0; j<C; j++){
                int temp = (i%2==0) ? j: C-1-j;
                System.out.print(arr[i][temp]+ " ");
            }
            System.out.println();
        }


        //행 우선 탐색
        /*for(int i=0; i<R; i++){
            for(int j=0; j<C;j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }*/
        }
    }
