package BackJun.Silver;


import java.util.StringTokenizer;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.OutputStreamWriter;


public class S5소가길을건너간이유1_14467 {
    public static void main(String[] args) throws IOException{
                System.setIn(new FileInputStream("Use JAVA\\inputTxt모음\\BackJun\\Silver\\S5소가길을건너간이유1_14467.txt"));
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
                StringTokenizer st;
                
                int checkCount = Integer.parseInt(br.readLine());
                int[] cow = new int[checkCount+1];
                boolean[] firstCheck = new boolean[checkCount+1];   // 소가 처음 등장하는지 확인하는 용
                int cowNum;
                int temp;
                int answer =0;
                for(int i=0; i<checkCount; i++){
                    st = new StringTokenizer(br.readLine());        // 첫번째 값
                    cowNum = Integer.parseInt(st.nextToken());      // 두번째 값
                    temp = Integer.parseInt(st.nextToken());
                    if(firstCheck[cowNum]==false){                  // 처음 등장시 그 위치 무조건 저장
                        cow[cowNum] = temp;
                        firstCheck[cowNum]= true;
                    }
                    else{                                           // 처음 등장 아닐때
                        if(temp!=cow[cowNum]){                      // 값 비교 후 다르면 이동횟수 +1, 그 값 새로 배열에 저장
                            answer++;
                            cow[cowNum] = temp;
                        }
                    }
                }
                bw.write(String.valueOf(answer));
                bw.flush();
                bw.close();
                br.close();
        }
}