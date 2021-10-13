package BackJun.Silver;
import java.util.Scanner;
public class S1057토너먼트 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();	// 참가자 수
		int Kim = scan.nextInt();	// 김지민 번호
		int Lim = scan.nextInt();	// 임한수 번호
		int count = 0;
		
		while(Kim != Lim) {
			Kim = (Kim + 1) / 2;
			Lim = (Lim + 1) / 2;
			count  ++;
		}
		System.out.println(count);
		scan.close();
	}

}
https://www.acmicpc.net/problem/1057
