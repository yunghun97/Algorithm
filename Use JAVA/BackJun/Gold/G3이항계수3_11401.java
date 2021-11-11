package BackJun.Gold;
import java.util.Scanner;
public class G3이항계수3_11401 {
	static int N, K, P=1000000007;
	public static void main(String[] args) {
		
		Scanner scann=new Scanner(System.in);
		N=scann.nextInt();
		K=scann.nextInt();
		long r=nCr(N,K);
		System.out.println((r)%P);
		scann.close();
	}
	
	static long fact(long n) {
		long re=1L;
		for (int i = 1; i <= n; i++) {
			re*=i;
			re%=P;
		}
		return re%P;
	}
	static long nCr(long n, long k) {
		long re=1L;
		re*=fact(n);
		re%=P;
		re*=power(fact(n-k),P-2);
		re%=P;
		re*=power(fact(k),P-2);
		re%=P;
		return re;
	}
	static long power(long x, long y) {
		long re=1L;
		while(y>0) {
			if(y%2==1) {
				re*=x;
				re%=P;
			}
			x*=x;
			x%=P;
			y/=2;
		}
		return re%P;
	}
}
//https://www.acmicpc.net/problem/11401