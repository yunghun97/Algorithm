package SamSungSwExpert.D3;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.OutputStreamWriter;


public class 퍼펙트셔플 {
    public static void main(String[] args) throws IOException{
                System.setIn(new FileInputStream("Use JAVA\\inputTxt모음\\SWExpert\\D3\\퍼펙트셔플.txt"));
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
                StringTokenizer st;
                int T = Integer.parseInt(br.readLine());
                int temp1,temp2;
                Queue<String> q1 = new LinkedList<>();  // 1번큐
                Queue<String> q2 = new LinkedList<>();  // 2번큐 생성        -> 번갈아 가면서 출력하기 위해서
                
                for(int t=1; t<=T; t++){
                    int wordSize = Integer.parseInt(br.readLine()); // 글씨 길이
                    
                    if(wordSize%2==0){ 
                        temp1= wordSize/2;      // 짝수면 반반
                        temp2 = wordSize-temp1;
                    }
                    else {
                        temp1 = wordSize/2+1;   // 홀수면 1번이 1개 더 길게
                        temp2 = wordSize-temp1;
                    }

                    st = new StringTokenizer(br.readLine()," ");
                    for(int i=0; i<temp1; i++){ //1번큐에 집어넣기
                        q1.add(st.nextToken());
                    }
                    for(int i=0; i<temp2; i++){ //2번큐에 집어넣기
                        q2.add(st.nextToken());
                    }

                    bw.write("#"+t+" ");

                    while(true){    // 다중 if문으로 역순으로 해서 출력
                        if(!q1.isEmpty()){
                            bw.write(q1.poll()+" ");
                        }
                        if(!q2.isEmpty()){
                            bw.write(q2.poll()+" ");
                        }
                        if(q1.isEmpty()&&q2.isEmpty()){     // 두 큐가 다 비어있으면 break;
                            break;
                        }
                    }
                    bw.newLine();   // 개행
                    bw.flush(); // 출력
                } //테케 끝
                bw.close();
                br.close();
        }
}





//https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWGsRbk6AQIDFAVW&categoryId=AWGsRbk6AQIDFAVW&categoryType=CODE&problemTitle=%ED%8D%BC%ED%8E%99%ED%8A%B8&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=&pageSize=10&pageIndex=1