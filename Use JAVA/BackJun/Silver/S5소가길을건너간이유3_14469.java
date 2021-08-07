package BackJun.Silver;

import java.util.Arrays;
import java.util.StringTokenizer;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.OutputStreamWriter;


public class S5소가길을건너간이유3_14469 {
    public static void main(String[] args) throws IOException{
                System.setIn(new FileInputStream("Use JAVA\\inputTxt모음\\BackJun\\Silver\\S5소가길을건너간이유3_14469.txt"));
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
                StringTokenizer st;
                int cowCount = Integer.parseInt(br.readLine());
                int answer = 0;
                int[] cowSpend = new int[1000001];
                int[] cow = new int[cowCount];
                int nowCow;
                for(int i=0; i<cowCount; i++){
                    st = new StringTokenizer(br.readLine());
                    nowCow = Integer.parseInt(st.nextToken());
                    cow[i] = nowCow;
                    cowSpend[nowCow] =  Integer.parseInt(st.nextToken());
                }
                Arrays.sort(cow);
                for(int j=0; j<cowCount; j++){
                    if(answer<cow[j]){
                        answer = cow[j] + cowSpend[cow[j]];     // 현재 시간보다 도착시간이 더 늦은 경우 도착 시간+소비 시간이 현재 시간이 된다.
                    }
                    else{
                        answer += cowSpend[cow[j]];             // 도착시간이 더 빠른 경우 대기하므로 현재 시간 + 소비 시간이 답이 된다.
                    }
                }
                bw.write(String.valueOf(answer));
                bw.flush();
                bw.close();
                br.close();
        }
}