package BackJun.Silver;
import java.io.*;
import java.util.*;
public class S1링크와스타트_15661 {
        static int[][] map;
        static int[] answer,answer2;
        static int size, R, result;
        static boolean[] isSelected;
        public static void main(String[] args) throws IOException{
            System.setIn(new FileInputStream("Use JAVA\\inputTxt모음\\BackJun\\Silver\\S1링크와스타트_15661.txt"));
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            StringTokenizer st;
            size = Integer.parseInt(br.readLine());
            map = new int[size][size];
            if(size%2==0){          //짝수일때는 반반
            answer = new int[size/2];
            answer2 = new int[size/2];
            R = size/2;
            }else{          // 홀수일때 반+1, 반
            answer = new int[size/2+1];
            answer2 = new int[size/2];
            R = size/2+1;
            }
            for(int i=0; i<size; i++){
                st = new StringTokenizer(br.readLine());   
                for(int j=0; j<size; j++){ 
                    map[i][j] = Integer.parseInt(st.nextToken()); // 선수에대한 정보 저장
                }
            }
            isSelected = new boolean[size];
            result = Integer.MAX_VALUE;
            combi(0,0);
            
            bw.write(""+result);
            bw.flush();
            bw.close();
            br.close();

        }
        static void combi(int cnt, int start){
            if(cnt==R){
                Arrays.fill(isSelected, false);     // 배열 초기화
                int temp=0;
                for(int j=0; j<cnt; j++){
                    isSelected[answer[j]]=true;     // 선택됐는지 안됐는지 확인
                }
                for(int j=0; j<size; j++){
                    if(!isSelected[j]) answer2[temp++] = j; // 안된거 2번배열에 추가
                }
                cal();
                return;
            }
            for(int i=start; i<size; i++){
                answer[cnt] = i;
                combi(cnt+1, i+1);
            }
        }
        static void cal(){
            if(size%2!=0){  // 홀수일때는 반반 나눠서
            int aSum =0;
            for(int a1=0; a1<answer.length; a1++){
                int ax = answer[a1];
                for(int a2=0; a2<answer.length; a2++){
                    //if(a1==a2) continue;
                    int ay = answer[a2];
                    aSum += map[ax][ay];
                }
            }
            int bSum =0;
            for(int b1=0; b1<answer2.length; b1++){
                int bx = answer2[b1];
                for(int b2=0; b2<answer2.length; b2++){
                    //if(b1==b2) continue;
                    int by = answer2[b2];
                    bSum += map[bx][by];
                }
            }
            result = Math.min(Math.abs(aSum-bSum), result);
        }else{                          // 짝수일때는 한번에
            int Sum =0;               
            for(int a1=0; a1<answer.length; a1++){
                int ax = answer[a1];
                int bx = answer2[a1];
                for(int a2=0; a2<answer.length; a2++){
                    //if(a1==a2) continue;
                    int ay = answer[a2];
                    int by = answer2[a2];
                    Sum += map[ax][ay];
                    Sum -= map[bx][by];
                }
            }
            result = Math.min(Math.abs(Sum), result);
        }
    }
}
