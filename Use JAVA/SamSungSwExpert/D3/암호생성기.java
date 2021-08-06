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
        int min = Integer.MAX_VALUE; // 공통차감수
        int temp;
        while(st.hasMoreTokens()){
            temp = Integer.parseInt(st.nextToken());
            min = Math.min(min,temp);
            q.offer(temp);
        }

        if(min<=15){min=0;} // //15보다 작을 경우 뺴지 않는다.
        else if(min%15==0){min-=15;}    //15배수와 동일할경우 -15해줌
        min = min / 15*15;

        for(int y=0; y<8; y++){
            q.offer(q.poll()-min);
        }
        int tmp;
        int i=1;
        while(true){
            if(i==6) i=1;
            tmp = q.poll()-i;
            if(tmp<=0){            
                q.offer(0);
                break;
            }
            else{
                q.offer(tmp);
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