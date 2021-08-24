package SamSungSwExpert.D4;

import java.io.*;
import java.util.*;
public class 창용마을무리의개수 {   // 소집합 활용
    static int N, order,result;
    static int[] Arr,answer;
    static Set<Integer> answer2;
    public static void main(String[] args) throws IOException{
    
    System.setIn(new FileInputStream("Use JAVA\\inputTxt모음\\SWExpert\\D4\\창용마을무리의개수.txt"));
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st;
    int T = Integer.parseInt(br.readLine());
    for(int t=1; t<=T; t++){
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        order = Integer.parseInt(st.nextToken());
        Arr = new int[N+1];
        make();    
        for(int i=0; i<order; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            union(a,b);
        }
        answer2 = new HashSet<>();
        answer = new int[N];
        for(int i=1; i<=N; i++){
            answer2.add(find(Arr[i]));  //set에 저장해서 알아서 중복 제거
        }
        /*for(int i=0; i<N; i++){
            answer[i] = find(Arr[i+1]);
        }
        Arrays.sort(answer);
        result = 1;
        for(int i=0; i<N-1; i++){
            if(answer[i]!=answer[i+1]) result++;
        }*/
        //System.out.println(Arrays.toString(answer));
        bw.write("#"+t+" "+answer2.size()+"\n");
        bw.flush();
    }//테케 끝
    bw.close();
    br.close();
}
    private static int find(int input) {
        if(input==Arr[input]) return input;
        return Arr[input] = find(Arr[input]);
    }
    private static boolean union(int a, int b) {
        int aTemp = find(a);
        int bTemp = find(b);
        if(aTemp==bTemp) return false;
        Arr[bTemp] = aTemp;
        return true;
    }
    private static void make() {
        for(int i=1; i<=N; i++){
            Arr[i] = i;
        }
    }
}

