package SamSungSwExpert.D2;

import java.util.Scanner;
public class EasyChangeMoney {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
         // 5만, 1만, 5천 1천, 500, 100, 50, 10;   
        final int[] money = {50000, 10000, 5000, 1000, 500, 100, 50, 10};
       	for(int t=1; t<=T; t++){
        	int price = sc.nextInt();
            int[] change = {0,0,0,0,0,0,0,0};
            	for(int i=0; i<8; i++){
                	if((price/money[i])!=0){
                        change[i] = price/money[i];
                        price = price%money[i];
                    }
                    else{
                        continue;
                    }
                }
            System.out.printf("#%d\n",t);
            for(int j=0; j<8; j++){
            	System.out.printf("%d ",change[j]);
            }
            System.out.println();
        }
    
    sc.close();
    }
}
