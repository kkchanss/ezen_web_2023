package java2.day25_제네릭2.Ex2;

public class Course {

	public static void registerCourse1(Applicant<?> applicant) {
		System.out.println(applicant.kind.getClass().getSimpleName());
	}
	
	public static void registerCourse2(Applicant<? extends Student> applicant) {
		System.out.println(applicant.kind.getClass().getSimpleName());
	}
	
	public static void registerCourse3(Applicant<? super Worker> applicant) {
		System.out.println(applicant.kind.getClass().getSimpleName());
	}
}
