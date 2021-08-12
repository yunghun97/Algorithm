package BackJun.Silver;

import java.io.*;
import java.util.StringTokenizer;
    
public class S1도영이가만든맛있는음식2961 {
    static int count, sumSugar, mulSour, BinNum;
    static long answer;
    static int[] sour, sugar;
    static boolean[] use;
    public static void main(String[] args) throws IOException{
        System.setIn(new FileInputStream("Use JAVA\\inputTxt모음\\BackJun\\Silver\\S1도영이가만든맛있는음식2961.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        count = Integer.parseInt(br.readLine());
        use = new boolean[count];
        sour = new int[count];
        sugar = new int[count];
        for(int i=0; i<count; i++){
            st = new StringTokenizer(br.readLine());
            sour[i] = Integer.parseInt(st.nextToken());   
            sugar[i] = Integer.parseInt(st.nextToken());
        }
        answer = Long.MAX_VALUE;
        set(0,0);
        Binary(0, 0);
        bw.write(""+answer);
        bw.flush();
        bw.close();
        br.close();
    }

    private static void set(int cnt, int useCount) {
        if(cnt==count){
            if(useCount==0) return;
            sumSugar =0; mulSour =1;
            for(int i=0; i<count; i++){
                if(use[i]){
                    mulSour *= sour[i];
                    sumSugar+=sugar[i];     
                }
            }
            answer = Math.min(answer, Math.abs(sumSugar-mulSour));
            return;
        }
            use[cnt]=true;
            set(cnt+1, useCount+1);
            use[cnt]=false;
            set(cnt+1,useCount);
    }
    private static void Binary(int cnt, int useCount) {        // binaryCount
        for(int i=0; i<(1<<count); i++){                       //0부터 2의 n제곱 까지니까 0->2의 n제곱-1까지 -> 0,1,2,3,4 가 되므로 0,1,10,11,100 의 형태가 된다. 알아서 부분집합이 됨.
            sumSugar =0; mulSour=1;useCount=0;                 //초기 값 할당
            for(int j=0; j<count; j++){                         // 2중 for문  비교하기 위한 j 값
                if((i&(1<<j))!=0){            //  첫부터 끝까지 돌아서 1이면 선택되어있는
                    System.out.println(j);
                    sumSugar+=sugar[j];
                    mulSour *= sour[j];
                    useCount++;
                }
            }
            if(useCount!=0){
                answer = Math.min(answer, Math.abs(sumSugar-mulSour));}
        }
        return;
    }
}
