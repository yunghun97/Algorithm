package 코딩테스트문제.현대엔지비;
import java.io.*;
import java.util.*;
public class 하반기2021_2번 {
    public static void main(String args[]) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ArrayList<Integer> list = new ArrayList<>();
        int repeat = Integer.parseInt(br.readLine());
        for(int i=0; i<repeat; i++){
        list.add(Integer.parseInt(br.readLine()));
        }
        int answer=0;
        int temp=0;
        for(int i=list.size()-1; i>=0; i--){
            if(list.get(i)>temp){
                answer++;
                temp = list.get(i);
            }
        }
        bw.write(""+answer);
        bw.flush();
    }
}
