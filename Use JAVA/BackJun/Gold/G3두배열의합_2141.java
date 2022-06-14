package BackJun.Gold;

import java.io.*;
import java.util.*;
public class G3두배열의합_2141 {
    static int[] A, B;    
    static ArrayList<Integer> aList, bList;
    static int T;
    static long answer;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        T = Integer.parseInt(br.readLine());

        int len = Integer.parseInt(br.readLine());                
        A = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();        

        len = Integer.parseInt(br.readLine());
        B = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();                
        
        aList = new ArrayList<>();
        bList = new ArrayList<>();
        for(int i=0; i<A.length; i++){ // A로 만들 수 있는 부분합
            int sum = 0;
            for(int j=i; j<A.length; j++){
                sum+=A[j];
                aList.add(sum);
            }    
        }
        for(int i=0; i<B.length; i++){ // B로 만들 수 있는 부분합
            int sum = 0;
            for(int j=i; j<B.length; j++){
                sum+=B[j];
                bList.add(sum);
            }    
        }        
        // Collections.sort(aList);
        // aList.sort(new Comparator<Long>() {
        //     @Override
        //     public int compare(Long o1, Long o2) {
        //         // TODO Auto-generated method stub
        //         return 0;
        //     }
        // });
        aList.sort((o1,o2)-> Integer.compare(o1, o2));
        bList.sort((o1,o2)-> Integer.compare(o2, o1));        
        answer = 0;

        cal();
        bw.write(""+answer);
        bw.flush();
    }
    private static void cal() { // 투 포인터 탐색
        int indexA = 0;
        int indexB = 0;
        while(indexA<aList.size()&&indexB<bList.size()){
            int sum = aList.get(indexA) + bList.get(indexB);
            if(sum==T){
                int a = aList.get(indexA);
                int b = bList.get(indexB);
                long aCount = 0;
                long bCount = 0;
                while(indexA<aList.size()&&aList.get(indexA)==a){
                    aCount++;
                    indexA++;
                }
                while(indexB<bList.size()&&bList.get(indexB)==b){
                    bCount++;
                    indexB++;
                }
                answer += aCount*bCount;
            }else if(sum<T){
                indexA++;
            }else{
                indexB++;
            }
        }
    }
}
// https://www.acmicpc.net/problem/2143
// 이분탐색으로 풀어야 시간이 절약 될 듯