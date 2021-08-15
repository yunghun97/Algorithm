package BackJun.Silver;
import java.io.*;
import java.util.Arrays;
public class S5단어정렬_1181 {
    public static void main(String[] args) throws IOException{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int size = Integer.parseInt(br.readLine());
        String[] arr = new String[size];
        for(int i=0; i<size; i++){
            arr[i] = br.readLine();
        }
        Arrays.sort(arr, (o1, o2) -> {  // 람다 함수
                if(o1.length()==o2.length()){
                    return o1.compareTo(o2);
                }
                else{
                   return o1.length()-o2.length();
                }
        });
        for(int i=0; i<size; i++){
            if(i==size-1){
                bw.write(arr[i]);
            }
            else if(arr[i].equals(arr[i+1])){
                continue;
            }
            else{
                bw.write(arr[i]+"\n");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }

}
