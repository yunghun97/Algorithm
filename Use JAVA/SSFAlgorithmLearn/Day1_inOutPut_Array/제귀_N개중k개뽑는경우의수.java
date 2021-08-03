package SSFAlgorithmLearn.Day1_inOutPut_Array;

public class 제귀_N개중k개뽑는경우의수 {
    private static int answer;
    public static void main(String[] args) {
     
        System.out.println(comb(5,2));
        System.out.println(comb(3,2));
        System.out.println(comb(3,3));
    }

    private static int comb(int n, int r) {
            // 자신을 포함해서 r개는 만드는 경우의 수 + 자신을 포함 x하고 r개
            if(r==0||n==r) return 1;

            
            return comb(n-1,r-1) + comb(n-1,r);
            //

    }
}

    /*
        System.out.print("N개 중 K개 뽑는 경우의 수");
        System.out.println(HowMuch(5,2));

        // 피보나치
        int[] arr ={1,1,2,3,5,8,13};
        System.out.println(fibo(arr, arr.length-1));
    }

    private static int HowMuch(int i, int j) {
        if(i<j) return 1;
        return i * HowMuch(i-1, j);
    }
    private static int fibo(int[] arr, int size){
        if(size<0) return 0;
        return arr[size]+ fibo(arr, size-1);
    }
}*/
