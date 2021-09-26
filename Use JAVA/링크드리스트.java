import java.io.*;
import java.util.*;

public class 링크드리스트 {

	public static void main(String[] args) throws IOException {
		LinkedList<LinkedList<LinkedList<Integer>>> list = new LinkedList<LinkedList<LinkedList<Integer>>>();
		for(int i=0; i<5; i++){
			list.add(new LinkedList<LinkedList<Integer>>());
		}
		for(int i=0; i<5; i++){
			for(int j=0; j<5; j++){
				list.get(i).add(new LinkedList<Integer>());
			}
		}
		list.get(0).get(4).add(1);
		list.get(0).get(4).add(3);
		list.get(0).get(4).add(5);
		for(int a : list.get(0).get(4)){
			System.out.println(a);
		}
	}

}