package BackJun.Silver;

import java.util.HashMap;
import java.util.StringTokenizer;
import java.io.*;
public class S4나는야포켓몬마스터이다솜{
    public static void main(String[] args) throws IOException{
        System.setIn(new FileInputStream("Use JAVA\\inputTxt모음\\BackJun\\Silver\\S4나는야포켓몬마스터이다솜.txt"));
        HashMap<Integer, String> map = new HashMap<Integer, String>();
        HashMap<String, Integer> map2 = new HashMap<String, Integer>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        st = new StringTokenizer(br.readLine());
        int size = Integer.parseInt(st.nextToken());
        int problem = Integer.parseInt(st.nextToken());
        
        for(int i=1; i<=size; i++){      // 인덱스 1번부터 이므로 
            sb.append(br.readLine());       // 포켓몬 이름 입력받기
            map.put(i,sb.toString());     // 인덱스, 포켓문 순으로 입력
            map2.put(sb.toString(),i);    // 포켓몬, 인덱스 순으로 입력
            sb.setLength(0);
        }
        for(int j=0; j<problem; j++){
            sb.append(br.readLine());
            if(Character.isDigit(sb.toString().charAt(0))){ // 숫자면 true
               System.out.println(map.get(Integer.parseInt(sb.toString()))); // key값을 입력해서 value를 추출
            }
            else{
                System.out.println(map2.get(sb.toString()));    // key 값이 String이므로 변환하지 않는다.
            }
        sb.setLength(0);
        }
    }
}