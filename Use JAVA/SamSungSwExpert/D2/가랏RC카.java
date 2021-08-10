package SamSungSwExpert.D2;
import java.util.*;
class 가랏RC카{
    public static void main(String[] args)
    {   int T,n,r,o,a,b;
        Scanner s=new Scanner(System.in);
        T=s.nextInt();
        for(int t=1;t<=T;t++)
        {
            n=0;r=0;o=s.nextInt();
            for(int i=0;i<o;i++){
                a=s.nextInt();if(a==0)
                r+=n;else{b=s.nextInt();
                    if(a==1){r+=n+b;n+=b;}
                    else if(a==0)r+=n;
                    else{n-=b;if(n<=0)n=0;r+=n;
                    }
                }
            }
                    System.out.printf("#%d %d\n",t,r);
                }
            s.close();
            }
        }
