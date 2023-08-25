package java2.day25_제네릭2.Ex2;

public class Ex2_와일드카드제네릭타입 {

	public static void main(String[] args) {
		
		Person person = new Person();
		
		Applicant<Person> applicant = new Applicant<Person>(person);
		
	}

}
