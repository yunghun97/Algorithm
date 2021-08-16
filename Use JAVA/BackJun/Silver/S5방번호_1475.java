package BackJun.Silver;
import java.io.*;
public class S5방번호_1475 {
    public static void main(String[] args) throws IOException{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String roomNum = br.readLine();
        int arr[] = new int[10];
        int answer = 1;
        for(int i=0; i<10; i++){
            arr[i]++;
        }
        for(int i=0; i<roomNum.length(); i++){
            int temp = Integer.parseInt(roomNum.substring(i,i+1));
            if(temp==6||temp==9){
                if(arr[6]==0&&arr[9]==0){
                    for(int j=0; j<10; j++){
                        arr[j]++;
                    }
                    answer++;
                    arr[temp]--;
                }
                else if(arr[6]>=1&&arr[9]==0){
                    arr[6]--;
                }
                else if(arr[6]==0&&arr[9]>=1){
                    arr[9]--;
                }
                else{
                    arr[temp]--;
                }
            }
            else{
            if(arr[temp]>=1){
                arr[temp]--;
            }
            else{
                for(int j=0; j<10; j++){
                    arr[j]++;
                }
                arr[temp]--;
                answer++;
            }
        }
        }
        bw.write(""+answer);
        bw.flush();
        bw.close();
        br.close();
    }
}
