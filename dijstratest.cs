using System;
using System.Collections.Generic;
using System.Linq;
using System.Text.RegularExpressions;
 
namespace dijstratest
{
    public class Program
    {
        //빈공간이라는 것을 의미하는 변수
       private static int BigSize = 50000;
 
        //n개의 정점간 관계를 나타내는 이차원 배열
        private static int[,] map=new int[,]{{BigSize,3,2,BigSize,BigSize},
                                {BigSize,BigSize,2,4,BigSize},
                                {BigSize,BigSize,BigSize,1,3},
                                {BigSize,BigSize,BigSize,BigSize,4},
                                {BigSize,BigSize,BigSize,BigSize,BigSize}};
        //각 정점과 start와의 최소 거리
        private static int[] dist=new int[]{BigSize,BigSize,BigSize,BigSize,BigSize};
 
        //트래커, 이전에 어떤 정점을 거쳐온건지 체크
        private static int[] prev=new int[]{-1,-1,-1,-1,-1};
        public static void Main(string[] args)
        {
            serch(0,3);
        }
        private static void serch(int start, int end){
            if(start>5 || end>5) // 일단은 정점이 5개므로 초과로 입력되는 것을 막는다.
                Console.WriteLine("error");
            dist[start]=0; // start initialization // 시작 정점은 최소거리가 0이므로 초기화를 시켜준다.
            for(int i=0; i<5; i++){
                for(int j=0; j<5; j++){
                    if(map[i,j]!=BigSize){  // 정점 간 간선이 존재한다면
                        if(dist[j]==BigSize){ // 그리고 첫번째 방문이라면
                            dist[j]=dist[i]+map[i,j]; // 바로 최소거리가 된다.
                            prev[j]=i; //그리고 이전 정점을 넣어준다.
                        }
                        else if(dist[j] > dist[i]+map[i,j]){ // 첫 방문이 아니고 이전에 설정된 최소거리가 지금 최소거리보다 크다면
                            dist[j]=dist[i]+map[i,j];
                            prev[j]=i;
                        }
                    }
                }
            }
            Console.WriteLine("length:"+dist[end]);
            trck(start,end);
        }
        private static int trck(int start,int tmp){ // 최소거리가 되는 정점을 찾는다.
            if(tmp==start){ 
                Console.Write(start);
            }else{
                Console.Write(tmp+"->");
                return trck(start,prev[tmp]);
            }
            return 0;
                
        }
    }
}
