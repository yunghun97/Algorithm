package SSFAlgorithmLearn.Day4;

public class Student implements Comparable<Student> {
	int no, score;
	Student(int no, int score){
		this.no = no;
		this.score = score;
	}
	public int getScore() {
		return this.score;
	}
	@Override
	public String toString() {
		return "Student [no=" + no + ", score=" + score + "]";
	}
	/*
	 * 음수값이 리턴일 경우 기준점이 비교대상의 앞에 위치
	 * 양수값이 리턴일 경우 기준점이 비교대상 뒤에 위치
	 * 0 일 경우 자리이동이 없다.
	 */
	@Override
	public int compareTo(Student o) {
		return (this.no - o.no);
	}
}
