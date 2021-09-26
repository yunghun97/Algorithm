package SSFAlgorithmLearn.Day4;
import java.util.Comparator;
import java.util.PriorityQueue;
public class PriorityQueueTest {
	public static void main(String[] args) {
		//PriorityQueue<Student> q = new PriorityQueue<>();
		//PriorityQueue<Student> q = new PriorityQueue<>(Comparator.reverseOrder());
		// 점수 순으로 처리
		/*PriorityQueue<Student> q = new PriorityQueue<>(new Comparator<Student>() {
			@Override
			public int compare(Student o1, Student o2) {
				return o1.score - o2.score;
			}
		});*/
		//PriorityQueue<Student> q = new PriorityQueue<>((o1, o2)-> o1.score - o2.score);
		
		
		//@FunctionalInterface  -> 메소드가 하나인 인터페이스는 람다함수 사용 가능

		PriorityQueue<Student> q = new PriorityQueue<>((o1, o2)-> Integer.compare(o1.score, o2.score));

		// 원래
		PriorityQueue<Student> pq = new PriorityQueue<>(new Comparator<Student>(){
			public int compare(Student o1, Student o2){
				return o1.no-o2.no;
			}
		});

		// Comparable<클래스명> = public int compareTo(클래스명 변수)
		// Comparator<클래스명> = public int compare(클래스명 변수, 클래스명 변수)
		q.offer(new Student(5,10));
		q.offer(new Student(1,70));
		q.offer(new Student(2,40));
		q.offer(new Student(4,30));
		q.offer(new Student(3,90));
		
		System.out.println(q.poll());
		System.out.println(q.poll());
		System.out.println(q.poll());
		System.out.println(q.poll());
		System.out.println(q.poll());		
	}
}