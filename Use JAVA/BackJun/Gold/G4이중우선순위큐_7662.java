package BackJun.Gold;

import java.io.*;
import java.util.*;

public class G4이중우선순위큐_7662 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for(int t=0; t<T; t++){
            TreeMap<Integer,Integer> treeMap = new TreeMap<>();
            int N = Integer.parseInt(br.readLine());
            for(int i=0; i<N; i++){
                st = new StringTokenizer(br.readLine());
                String kind = st.nextToken();
                int num = Integer.parseInt(st.nextToken());
                if(kind.equals("I")){ // Insert
                    if(treeMap.containsKey(num)){
                        treeMap.put(num, treeMap.get(num)+1);
                    }else treeMap.put(num, 1);
                }else{
                    if(treeMap.size()==0) continue;
                    if(num==1){ // 최대값 삭제
                        if(treeMap.get(treeMap.lastKey())!=1){
                            treeMap.put(treeMap.lastKey(),treeMap.get(treeMap.lastKey())-1);
                        }else treeMap.remove(treeMap.lastKey());
                    }else{ // 최소값 삭제
                        if(treeMap.get(treeMap.firstKey())!=1){
                            treeMap.put(treeMap.firstKey(),treeMap.get(treeMap.firstKey())-1);
                        }else treeMap.remove(treeMap.firstKey());
                    }                    

                }
            }
            if(treeMap.size()==0){
                bw.write("EMPTY");
            }else{                
                bw.write(""+treeMap.lastKey()+" "+treeMap.firstKey());
            }
            if(t!=T-1) bw.newLine();
        } // 테케 끝
        bw.flush();
    }
}
// https://www.acmicpc.net/problem/7662