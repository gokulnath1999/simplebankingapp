package gokul;

public class Overloading {
	public int add(int number1 ,int number2) {
	return number1+number2;
	}

	public int add(int number1,int number2,int number3) {
	return number1+number2+number3;
	}

	public double add(double number1,double number2) {
	return number1+number2;
	}

	public static void main(String[] args) {
	Overloading ad = new Overloading();
	System.out.println(ad.add(10, 10));
	System.out.println(ad.add(10 ,10, 10));
	System.out.println(ad.add(10.0,10.0));
	}
}
