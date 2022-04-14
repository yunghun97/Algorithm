package Programmers.Lv1;

import java.util.*;
public class 수박수박 {
    public String solution(int n) {
        String[] arr = new String[]{"수","박"};
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<n; i++){
            sb.append(arr[i%2]);
        }        
        return sb.toString();
    }
}
