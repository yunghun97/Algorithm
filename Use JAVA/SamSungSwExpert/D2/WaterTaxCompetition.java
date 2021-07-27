package SamSungSwExpert.D2;
import java.util.Scanner;
public class WaterTaxCompetition {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int t= sc.nextInt();
        for(int i=1; i<=t; i++){
        	int aBill = sc.nextInt();
            int bBill = sc.nextInt();
            int limit = sc.nextInt();
            int overBill = sc.nextInt();
            int use = sc.nextInt();
           	int a = aBill*use;
            int b = bBill;
            if(use>limit){
            	b = bBill+(overBill*(use-limit));
            }
            if(a<b){
            	System.out.printf("#%d %d\n",i,a);                            
            }
            if(b<a){
            	System.out.printf("#%d %d\n",i,b);                            
            }
        }
    }
}
/* input 값
2
9 100 20 3 10
8 300 100 10 250

*/ 

// 출력 
//#1 90
//#2 1800 
