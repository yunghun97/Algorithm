package SamSungSwExpert.D3;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 암호생성기 {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        System.setIn(new FileInputStream("Use JAVA\\inputTxt모음\\SWExpert\\D3\\암호생성기.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Queue<Integer> q = new LinkedList<>();

        for(int t=1; t<=10; t++){
        br.readLine();
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        while(st.hasMoreTokens()){
            q.offer(Integer.parseInt(st.nextToken()));
        }
        int i=1;
        while(true){
            if(i==6) i=1;
            if(q.peek()-i<=0){
                q.poll();
                q.offer(0);
                break;
            }
            else{
                q.offer(q.poll()-i);
                i++;
            }

        }
        bw.write("#"+t +" ");
        for(int x=0; x<8; x++){
            bw.write(q.poll()+" ");
        }
        bw.newLine();
        bw.flush();
        }//테케 끝   
        bw.close();
        br.close();
    }
}
// https://swexpertacademy.com/main/solvingProblem/solvingProblem.do    