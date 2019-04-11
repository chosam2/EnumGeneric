package kr.or.ddit.basic;

class Util2 {
	public static <T extends Number> int compare(T t1, T t2) { // 제한된 타입 파라미터 => Number를 상속하는것만 쓸 수 있음. 제한적으로 사용가능.
		double v1 = t1.doubleValue();
		double v2 = t2.doubleValue();

		return Double.compare(v1, v2);

	}
}

/**
 * 제한된 타입 파라미터(Bounded Parameter) 예제
 * @author Hyungwook
 *
 */
public class T04_GenericMethodTest {
	public static void main(String[] args) {

		int result1 = Util2.compare(10, 20); // AutoBoxing(Integer) => int가 들어가서 AutoBoxing되서 Integer로 변환
		System.out.println(result1);

		int result2 = Util2.compare(3.14, 3); // AutoBoxing(Double)
		System.out.println(result2);

		// Util2.compare("c", "java"); // 에러발생 => 제한된 타입 파라미터를 사용했기 때문에
	}
}
