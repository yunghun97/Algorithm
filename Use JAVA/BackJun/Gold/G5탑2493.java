package BackJun.Gold;
import java.util.StringTokenizer;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.Stack;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.OutputStreamWriter;
public class G5탑2493 {
    public static void main(String[] args) throws IOException{
        System.setIn(new FileInputStream("Use JAVA\\inputTxt모음\\BackJun\\Gold\\G5탑2493.txt"));
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> temp = new Stack<>();
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int compare;
        int topCount = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=topCount; i++){
            int val =Integer.parseInt(st.nextToken());  // 뒤에 비교하는 값
            if(stack.isEmpty()){    // 젤 처음엔 무조건 0
                stack.push(val);
                temp.push(i);
                sb.append("0");
            }
            else{
                while(true){
                    if(!stack.isEmpty()){  //비어있지 않으면
                        compare = stack.peek(); // 현재 val 앞쪽 칸 가져옴
                        if(compare>val){    // 앞에 값이 뒤에 값 보다 클 때
                            sb.append(" " + temp.peek()); // 앞에 타워의 번호를 저장한다.
                            stack.push(val);    // val타워,번호정보 저장
                            temp.push(i);
                            break;
                        }
                        else{   // 앞에 값이 뒤에 값보다 작으므로 제거
                            stack.pop();    // 이후에도 필요 없으므로 둘 다 버린다.
                            temp.pop();
                        }
                }
                else{       // 스택 처음까지 돌아도 더 큰 값이 없으므로 0을 넣고 큰 값인 val을 저장
                    sb.append(" 0");
                    stack.push(val);
                    temp.push(i);
                    break;
                }


            }
        }
    }
    bw.write(sb.toString());
    bw.flush();
    bw.close();
    }
}
//https://www.acmicpc.net/problem/2493


/*
시간 초과 나던거...
public class test {
    static int count, max, swap, tempSize;
    static Stack<Integer> stack = new Stack<>();
    static Stack<Integer> temp = new Stack<>();
    public static void main(String[] args) throws IOException{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int topCount = Integer.parseInt(br.readLine());
        tempSize =0;
        st = new StringTokenizer(br.readLine());
        for(int i =0; i<topCount; i++){
            stack.push(Integer.parseInt(st.nextToken()));
        }
        while(stack.size()>0){
            max =stack.pop();
            topCount--;
            count = topCount;
            if(stack.size() ==0){ // 맨 앞일때
                temp.push(0);
                tempSize++;
                break;
            }
            else{
                cal();
            }
        }
        for(int n=0; n<tempSize; n++){
            bw.write(temp.pop()+" ");
        }
        bw.flush();
        bw.close();
    }
    static void cal(){ 
        while(true){
        if((stack.size()==0)){
                while(temp.size()>tempSize){
                    stack.push(temp.pop());
                }
                temp.push(0);
                tempSize++;
                break;
        }
        swap = stack.pop();
        if(max<swap){  //앞에 타워가 더 크면
            stack.push(swap);
            while(temp.size()>tempSize){
                stack.push(temp.pop());
            }
            temp.push(count);
            tempSize++;
            break;
        }
        else {
            temp.push(swap);
            count--;
        }
        }
        return;
    }
}
*/