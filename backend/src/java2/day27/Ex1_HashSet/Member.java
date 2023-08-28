package java2.day27.Ex1_HashSet;

public class Member {
	public String name;
	public int age;
	
	public Member(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return name.hashCode()+age;
	}
	
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		
		if(obj instanceof Member target) {
			return target.name.equals(name) && (target.age == age);
		}else {
			return false;
		}
	
	}

	@Override
	public String toString() {
		return "Member [name=" + name + ", age=" + age + "]";
	}
	
	
}
