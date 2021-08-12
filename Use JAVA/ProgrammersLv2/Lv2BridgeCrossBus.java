package ProgrammersLv2;
import java.util.Queue;
import java.util.LinkedList;
public class Lv2BridgeCrossBus {
    public static void main(String[] args) {
    int bridge_length =2;                  // 다리를 다 건너기 위해서는 다리길이 +1인 상태가 다 건넌 상태이다.
    int weight =10; 
    int[] truck_weights = {7,4,5,6};
    Queue<Integer> que = new LinkedList<>();
    int truck = 0;
    int count = 0;
    int time = 0;
    for(int i=0; i<truck_weights.length;i++){
        truck = truck_weights[i];
    while(true){                //만족할때까지 계속 돌리겠다.
        if(que.isEmpty()){      // 처음 시작에 que가 비어있으면 무조건 넣어야 되기때문에 넣음 + 시간 +1 -> 넣었으니 다시 truck를 할당한다.
            que.add(truck);
            count += truck;
            time++;
            break;
        }else if(que.size()==bridge_length){      // 다리 길이만큼 que가 다 차서 맨 앞에 트럭 or 0이 적재된걸 비워준다. 그리고 다리하중을 그만큼 줄여준다.
            count -= que.poll();
        }else
            if(count + truck <=weight){    // 다리하중 + 새로운 트럭 무게가 weight보다 작거나 같으면 적재가 가능하므로 que에 적재 + 다리하중 + 그 트럭 + 시간 +1 하고 다시 트럭할당받으러 감
                que.add(truck);
                count+=truck;
                time++;
                break;
            }else{                       // 다리 하중이 초과되므로 트럭이 내릴때 까지 기다려야 되므로 que에 0을 계속 넣는다 + 시간 +1
                que.add(0);
                time++;
            }
                
    }

    }
    System.out.println(time+bridge_length);  // 마지막 적재된 트럭이 끝까지 갈려면 현재 다리길이 만큼 더 해줘야 마지막 까지 가므로 다리 길이를 더한다.
    }
}