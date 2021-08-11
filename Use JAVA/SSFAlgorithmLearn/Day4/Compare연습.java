package SSFAlgorithmLearn.Day4;
import java.util.Arrays;
import java.util.Comparator;

public class Compare연습 {
	private static class StudentComparator implements Comparator<Student>{

		@Override
		public int compare(Student o1, Student o2) {	// 앞에가 메소드 호출한거, 뒤에꺼 비교 대상
			// TODO Auto-generated method stub
			if(o1.score - o2.score==0) {
				return o2.no - o1.no;
			}
			else {
				return o1.score - o2.score;
			}
		}
	}
	public static void main(String[] args) {
		Student[] arr = {
			new Student(3,90),
			new Student(1,70),
			new Student(4,70),
			new Student(2,10),
		};
		
        Arrays.sort(arr, (o1, o2) -> o1.score - o2.score);
        System.out.println(Arrays.toString(arr));
		//익명 클래스 람다 표현
		/*Arrays.sort(arr, (o1, o2) -> {
				return o1.score - o2.score;
			});  // 한문장일때는 중괄호 생략 가능 + return 지워줘야 함

		//익명 클래스 람다 표현
		/*Arrays.sort(arr, (Student o1, Student o2) -> {
            // TODO Auto-generated method stub
            return o1.score - o2.score;
        });*/
    
    /*//익명 클래스
    Arrays.sort(arr, new Comparator<Student>() {
        @Override
        public int compare(Student o1, Student o2) {
            // TODO Auto-generated method stub
            return o1.score - o2.score;
        }});*/
		
		/*Arrays.sort(arr, new StudentComparator());
		System.out.println(Arrays.toString(arr));*/
		
		
		/* Comparable
		System.out.println(Arrays.toString(arr));
		Arrays.sort(arr);
		System.out.println(Arrays.toString(arr));*/
	}
}
	/*  sort는 대충 이런 형태로 되어있다.
	private void sort(Student[] arr) {
		Comparable comp = (Comparable)arr[0]; // 기준
		comp.compareTo((Comparable)(arr[1]));
	}
}*/
