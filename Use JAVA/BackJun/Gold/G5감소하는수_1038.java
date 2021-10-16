package BackJun.Gold;
import java.io.BufferedReader; 
import java.io.IOException; 
import java.io.InputStreamReader; 
import java.util.LinkedList; 
import java.util.Queue; 
public class G5감소하는수_1038{
    public static void main(String[] args) throws IOException
    { 
        int n = Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine()); 
        if(n>1022) {
            System.out.println(-1); 
        } else if(n<10) { 
            System.out.println(n); 
        } else { 
            Queue<Long> q = new LinkedList<>(); int cnt= 0; 
            for(int i=1; i<10; i++) { 
                q.add((long)i); cnt++; 
            } while(cnt<n) { 
                long k = q.poll(); 
                long temp = k % 10; 
                for(int i=0; i<temp; i++) { 
                        q.add(k*10 + i); cnt++; 
                        if(cnt == n) { 
                        System.out.println(k*10+i); break; 
                        } 
                } 
            }
        } 
    } 
}
// https://www.acmicpc.net/problem/1038
