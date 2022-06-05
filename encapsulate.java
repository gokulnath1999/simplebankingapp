package gokul;
class Encap {
	private int roll;
	private int age;

	public int getRoll() {
		return roll;
	}

	public int getAge() {
		return age;
	}

	public void setRoll(int newRoll) {
		roll = newRoll;
	}

	public void setAge(int newAge) {
		age = newAge;
	}
}

public class encapsulate{
public static void main(String[] args){
	Encap ob1 = new Encap();
	ob1.setRoll(10);
	ob1.setAge(22);
	System.out.println("roll: " + ob1.getRoll());
	System.out.println("age: " + ob1.getAge());
}
}




