package Basic.ProgrammersLv1;


import java.util.HashMap;
public class NoCompleteRunner{
    public static void main(String[] args) {
    String[] participant ={"marina", "josipa", "nikola", "vinko", "filipa"};    
    String[] completion  ={"josipa", "filipa", "marina", "nikola"};
    HashMap<String , Integer> ht = new HashMap<String , Integer>();
    String answer = "";
    for(int i=0; i<participant.length; i++){
         ht.put(participant[i],ht.getOrDefault(participant[i], 0)+1);  // ht 해쉬맵에 Key값을 참가자 이름으로 추가 Value는 1은 넣는다. 중복이면 getOrDefault를 이용 0반환 +1 기존 value 값에 +1은 한다.
    }
    for(int i=0; i<completion.length; i++){
        ht.put(completion[i],ht.get(completion[i])-1);  //똑같이 추가하지만 key값이 같으면 새로 쓴 Value 값으로 덮어쓰기 때문에 get(key)로 Value값을 불러온 후 -1을 한다. 이렇게 되면 이름이 겹치는 부분의 value는 다 0이된다.
}
    for(String a : ht.keySet()){   //위에서 값이 다 0이 되었기 때문에 0이 아닌것은 중복이 안되는 부분으로 keySet으로 key값을 불러와서 a에 저장 get(a)를 통해 value값을 불러와 0이 아닌것을 찾아 그 Key값을 answer에 넣는다.
        if(ht.get(a)!=0){
            answer = a;
        }
    }
    System.out.println(answer);
}
}