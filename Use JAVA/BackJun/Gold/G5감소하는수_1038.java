package BackJun.Gold;

import java.io.*;

public class G5감소하는수_1038 {    // 아직 못품 재귀로 하면 스택오버플로우 남
    static int N;
    static BufferedWriter bw;
    static boolean end;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        end = false;
        int cnt = 0;
        int num = 1;
        
        bw.flush();

    }

    private static void check(int cnt, int num) throws IOException{
        if(end) return;
        if(cnt==N){
            bw.write(""+(num-1));
            end = true;
            return;
        }
        int min = num%10;
        int temp = num/10;
        while(temp!=0){
            if(temp%10>min){
                temp/=10;
            }else{
                break;
            }
        }
        if(temp==0){
            check(cnt+1, num+1);
        }else{
            check(cnt, num+1);
        }
    }
}
// https://www.acmicpc.net/problem/1038