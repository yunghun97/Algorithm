package SamSungSwExpert.모의역랑테스트;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 요리사 {
    static int[][] map;
    static int[] answer;
    static int size, R, result;
    static boolean[] isSelected;
    public static void main(String[] args) throws IOException{
        System.setIn(new FileInputStream("Use JAVA\\inputTxt모음\\SWExpert\\모의역량테스트\\요리사.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for(int t=1; t<=T; t++){
        size = Integer.parseInt(br.readLine());
        map = new int[size][size];          // 맛에 대한 정보 저장
        R = size/2;               // N/2만큼 재료 쓰므로
        answer = new int[R];     // 처음 조합으로 저장할 배열
        isSelected = new boolean[size];     // 선택됐는지 안됐는지 확인용
        for(int i=0; i<size; i++){
            st = new StringTokenizer(br.readLine());   
            for(int j=0; j<size; j++){ 
                map[i][j] = Integer.parseInt(st.nextToken()); // 맛에 대한 정보 저장
            }
        }
        result = Integer.MAX_VALUE;     // 첨에 최대 값 할당해서 비교
        combi(0,0);
        bw.write("#"+t+" "+result+"\n");
        bw.flush();
        }//테케 끝
        bw.close();
        br.close();
    }
    static void combi(int cnt, int start){
        if(cnt==R){
            Arrays.fill(isSelected, false);     // 사용할때마다 초기화시켜준다.
            for(int j=0; j<cnt; j++){
                isSelected[answer[j]] =true;    // 각 원소의 번호가 선택되면 true로 해줌
            }
            cal();
            return;
        }
        for(int i=start; i<size; i++){      // 조합뽑는 공식
            answer[cnt] = i;
            combi(cnt+1,i+1);
        }
    }
    static void cal(){
        int[] answer2 = new int[R];     // 선택안된거 저장하기 위한 배열
        int temp=0;    // 처음부터 저장하기 위한 index 선언    
        for(int x=0; x<size; x++){      // size만큼 돌아도 이미 N/2만큼 선택되었으므로 N/2는 선택안된것이 나오게된다.
            if(!isSelected[x]) answer2[temp++] = x;     // 선택되지 않았으므로 2번째 배열에 저장
        }
        int Sum =0;    // 첫번째 재료의 모든 합
        for(int a1=0; a1<R; a1++){// 0번부터 선택된거 까지
            int ax = answer[a1];    // 첫 배열 index 설정
            int bx = answer2[a1];   // 두번째 배열 index 설정
            for(int a2=0; a2<R; a2++){ // 0번부터 선택된거 까지
            //if(a1==a2) continue;    // a1,a2가 같으면 어짜피 0이므로 더하지 않겠다는 뜻 -> 어짜피 0이 저장되므로 없어도 상관없는 코드
            int ay = answer[a2];    // 처음 선택된것과 다른 재료의 index 저장
            int by = answer2[a2];   //  ~~ 
            Sum += map[ax][ay];    // Sum에 모두 더해준다.
            Sum -= map[bx][by];    // Sum에 모두 -해준다
            }
        }
        result = Math.min(Math.abs(Sum),result);  // -> 제일 작은값을 뽑아낸다. Sum은 -가 될 수도 있으므로 절대값 처리 해준다.
    }
}
