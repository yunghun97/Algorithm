package ProgrammersLv2;
import java.util.HashMap;
import java.util.Map;
public class Lv2PhoneBook_useHash {
    public static void main(String[] args) {
        String[] phone_book = {"12","123","1235","567","88"};
        Lv2PhoneBookSolution pbs = new Lv2PhoneBookSolution();
        System.out.println(pbs.soulution(phone_book));
    }
}
class Lv2PhoneBookSolution{
        boolean soulution(String[] phone_book){
        Map<String, String> hMap= new HashMap<String, String>();
        for(int i=0; i<phone_book.length; i++){
            hMap.put(phone_book[i],phone_book[i]);
        }
        for(String temp : phone_book){                              
            for(int x=0; x<temp.length(); x++){
                String temp2 = temp.substring(0,x);
                if(hMap.containsKey(temp2)){
                return false;
            }
            }
        }
         return false;
        }
    }
//https://programmers.co.kr/learn/courses/30/lessons/42577

/*for(int j=0; j<phone_book.length; j++){                   마지막 2개에서 시간초과 난 코드
            for(int x=0; x<hMap.size(); x++){               이유 : 시작위치가 아니라 포함관계 였음 and get할 필요없이
                if(j==x){continue;}                         containsKey하면 되었음 &&(속도 때문에 containsValue하
                else if(hMap.get(j).startsWith(hMap.get(x))){           면 시간 초과 뜸)
                return false;
            }*/