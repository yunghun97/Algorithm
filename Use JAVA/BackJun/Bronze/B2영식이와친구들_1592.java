package BackJun.Bronze;
import java.util.*;
public class B2영식이와친구들_1592 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int people = sc.nextInt();
        int purpose = sc.nextInt();
        int move = sc.nextInt();
        int[] arr = new int[people];
        int temp = 0;
        int answer = 0;
        arr[temp]=1;
        while(true){
            if(arr[temp]==purpose) break;
            arr[temp]++;
            answer++;
            temp+=move;
            temp%=people;
        }
        System.out.println(answer);
        sc.close();
    }
}
//https://www.acmicpc.net/problem/1592
// 입력 5 3 2 결과 -> 10