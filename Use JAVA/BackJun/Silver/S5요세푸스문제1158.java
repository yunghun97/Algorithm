package BackJun.Silver;

import java.io.*;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class S5요세푸스문제1158 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        LinkedList<Integer> ls = new LinkedList<>();
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        st = new StringTokenizer(br.readLine());
        int size = Integer.parseInt(st.nextToken());
        int order = Integer.parseInt(st.nextToken())-1;
        for(int i=1; i<=size; i++){
            ls.add(i);
        }
        int index = order;
        sb.append("<");
        
        while(ls.size()>1){
            index %= ls.size();    
            sb.append(ls.remove(index)+", ");
            index = index+order;
        }
        sb.append(ls.poll());
        sb.append(">");
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
    
}
