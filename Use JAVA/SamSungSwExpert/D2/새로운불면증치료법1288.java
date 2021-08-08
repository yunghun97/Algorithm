package SamSungSwExpert.D2;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.OutputStreamWriter;


public class 새로운불면증치료법1288 {
    public static void main(String[] args) throws IOException{
                System.setIn(new FileInputStream("Use JAVA\\inputTxt모음\\SWExpert\\D2\\새로운불면증치료법1288.txt"));
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
                int T = Integer.parseInt(br.readLine());
                for(int t=1; t<=T; t++){
                    int input = Integer.parseInt(br.readLine());
                    int input2 = input;
                    int answer = 0;
                    int[] check = new int[10];
                    int temp = input;
                    while(true){
                        for(int i=0; i<10; i++){            // 다 나왔는지 획인
                            if(check[i]==1){
                                answer++;
                            }
                            else{
                                break;
                            }
                        }
                        if(answer==10) break;
                        else {answer=0;}
                        temp = input;
                        while(true){
                            check[temp%10] = 1;
                            temp /=10;
                            if(temp<=0){
                                break;
                            }
                        }
                        input += input2;            
                    }
                    input -=input2;
                    bw.write("#"+t+" "+input+"\r\n");
                    bw.flush();
                } // 테케 끝
                
                bw.close();
                br.close();
        }
}
