package kr.or.ddit.basic;

import java.util.Arrays;

/**
 * 와일드카드 타입 예제
 * @author Hyungwook
 *
 */
public class T06_WildCardTest {

	// 모든 과정등록한 수강생 목록 조회
	public static void registerCourse(Course<?> course) {
		System.out.println(course.getName() + "수강생 : " + Arrays.toString(course.getStudents()));
	}

	// 학생 과정 등록한 수강생 목록 조회
	public static void registerCourseStudent(Course<? extends Student> course) {
		System.out.println(course.getName() + "수강생 : " + Arrays.toString(course.getStudents()));
	}

	// 직장인 과정 등록한 수강생 목록 조회
	public static void registerCourseWorker(Course<? super Worker> course) {	// super란? 자신을 포함한 조상들
		System.out.println(course.getName() + "수강생 : " + Arrays.toString(course.getStudents()));
	}

	public static void main(String[] args) {
		Course<Person> personCourse = new Course("일반인 과정", 5);
		personCourse.add(new Person("일반인1"));
		personCourse.add(new Worker("직장인1"));
		personCourse.add(new Student("학생1"));
		personCourse.add(new HighStudent("고등학생1"));

		Course<Worker> workerCourse = new Course("직장인 과정", 5);
		workerCourse.add(new Worker("직장인1"));

		Course<Student> studentCourse = new Course("학생 과정", 5);
		studentCourse.add(new Student("학생1"));

		Course<HighStudent> highStudnetCourse = new Course("고등학생 과정", 5);
		highStudnetCourse.add(new HighStudent("고등학생1"));

		registerCourse(personCourse);
		registerCourse(workerCourse);
		registerCourse(studentCourse);
		registerCourse(highStudnetCourse);
		System.out.println("----------------------------------------------------");

//		registerCourseStudent(personCourse);
//		registerCourseStudent(workerCourse);
		registerCourseStudent(studentCourse);
		registerCourseStudent(highStudnetCourse);
		System.out.println("----------------------------------------------------");

		registerCourseWorker(personCourse);
		registerCourseWorker(workerCourse);
//		registerCourseWorker(studentCourse);
//		registerCourseWorker(highStudnetCourse);

	}
}

class Course<T> {
	private String name; // 코스명
	private T[] students; // 수강생 배열

	public Course(String name, int capacity) {
		this.name = name;
		// 타입 파라미터로 배열을 생성시 오브젝트 배열을 생성후, 타입파라미터 배열로 캐스팅 처리해야함.
		students = (T[]) (new Object[capacity]);
	}

	public String getName() {
		return name;
	}

	public T[] getStudents() {
		return students;
	}

	public void add(T t) {
		for (int i = 0; i < students.length; i++) {
			if (students[i] == null) {
				students[i] = t;
				break;
			}
		}
	}

}

class Person {
	String name; // 이름

	public Person(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "이름 : " + name;
	}

}

// 직장인
class Worker extends Person {
	public Worker(String name) {
		super(name);
	}
}

// 학생
class Student extends Person {
	public Student(String name) {
		super(name);
	}
}

// 고등학생
class HighStudent extends Student {
	public HighStudent(String name) {
		super(name);
	}
}