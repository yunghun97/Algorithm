package SamSungSwExpert.D2;
import java.util.Scanner;

public class TimeAdd {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int t=1; t<=T; t++){
        	int hour1 = sc.nextInt();
            int minute1 = sc.nextInt();
            int hour2 = sc.nextInt();
            int minute2 = sc.nextInt();
        	hour1 += hour2 + (minute1+minute2)/60;
            minute1 = (minute1+minute2)%60;
            if(hour1>12) hour1-=12;
            System.out.printf("#%d %d %d\n", t, hour1, minute1);
        }
    }
}
/*
입력  : 
3 
3 17 1 39
8 22 5 10
6 53 2 12  

출력 : 
#1 4 56
#2 1 32
#3 9 5
*/



//https://swexpertacademy.com/main/code/problem/problemDetail.do?problemLevel=2&contestProbId=AV5PttaaAZIDFAUq&categoryId=AV5PttaaAZIDFAUq&categoryType=CODE&problemTitle=&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=2&pageSize=10&pageIndex=2