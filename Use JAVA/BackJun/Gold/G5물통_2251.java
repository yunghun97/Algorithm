package BackJun.Gold;

import java.io.*;
import java.util.*;

public class G5물통_2251 {
    static int[] maxArr;    
    static PriorityQueue<Integer> answer;
    static HashMap<String, Boolean> hmap;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        maxArr = new int[3];
        int[] nowArr = new int[3];
        maxArr[0] =  Integer.parseInt(st.nextToken());
        maxArr[1] =  Integer.parseInt(st.nextToken());
        maxArr[2] =  Integer.parseInt(st.nextToken());

        nowArr[2] = maxArr[2];
        answer = new PriorityQueue<>((o1,o2) -> Integer.compare(o1, o2));
        hmap = new HashMap<>();        
        spoil(2,nowArr);
        
        int prev = -1;
        while(!answer.isEmpty()){
            int result = answer.poll();
            if(prev==result) continue;
            bw.write(String.valueOf(result)+" ");
            prev = result;
        }
        bw.flush();
    }
    private static void spoil(int now, int[] arr){
        if(arr[0]==0){
            answer.add(arr[2]);
        }
        if(arr[now]==0) return;
        if(hmap.containsKey(now+"@"+arr[0]+"@"+arr[1])){ // 이미 해당 선택을 통해 더 진행한 경우 arr[2]는 어차피 arr[0], arr[1]이 똑같으면 자동으로 정해진다.
            return;
        }else{
            hmap.put(now+"@"+arr[0]+"@"+arr[1],true);
        }

        for(int i=0; i<3; i++){
            if(i==now) continue; // 자기 자신에는 물 넣기 X
            if(arr[i]==maxArr[i]) continue; // 물을 넣을려는 물통이 이미 최대인 경우
            int[] tmpArr = new int[3];
            arrCopy(arr,tmpArr);
            while(tmpArr[now]-->0){ // 물 한개씩 옮기기
                tmpArr[i]++;
                if(tmpArr[i]==maxArr[i]||tmpArr[now]==0){
                    break;
                }            
            }
            for(int j=0; j<3; j++){ // 0,1,2중 물이 있는 물통을 선택하여 물을 이동시킬 수 있도록한다.
                if(tmpArr[j]==0) continue;                
                spoil(j, tmpArr);
            }
        }

    }
    // 현재의 배열 상태 복사
    private static void arrCopy(int[] arr, int[] tmpArr){
        System.arraycopy(arr, 0, tmpArr, 0, 3);
    }
}
// https://www.acmicpc.net/status?user_id=yunghun97&problem_id=2251&from_mine=1