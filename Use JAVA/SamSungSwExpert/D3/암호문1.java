package SamSungSwExpert.D3;
import java.io.*;
import java.util.LinkedList;
import java.util.StringTokenizer;
public class 암호문1 {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        System.setIn(new FileInputStream("Use JAVA\\inputTxt모음\\SWExpert\\D3\\암호문1.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        for(int t=1; t<=10; t++){
        LinkedList<Integer> ls = new LinkedList<>();
        br.readLine();

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<10; i++){
            ls.add(Integer.parseInt(st.nextToken()));
        }
        int ordercount = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine()," ");
        int temp, repeat;
        for(int i=0; i<ordercount; i++){
            st.nextToken(); // l 버릴꺼
            temp = Integer.parseInt(st.nextToken());
            repeat = Integer.parseInt(st.nextToken());
            if(temp>10){
                for(int j=0; j<repeat; j++){                // 10번 이상은 필요없으므로 토큰 비워준다.
                    st.nextToken();
                }
            }
            else{
                for(int j=0; j<repeat; j++){
                    if(temp+j>10){st.nextToken();}
                    else{ls.add(temp+j, Integer.parseInt(st.nextToken()));}       // 리스트에 추가
                }
            }
        }
        bw.write("#"+t+" ");
        for(int i=0; i<10; i++){
            bw.write(String.valueOf(ls.get(i))+" ");
        }
        bw.write("\r\n");
        bw.flush();
        }//테케 끝
        bw.close();
        br.close();
    }
}
