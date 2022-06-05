package gokul;

import java.util.Scanner;
import java.util.regex.Matcher;

public class email {
	public static void main(String[] args) {
		Scanner rd = new Scanner(System.in);
		System.out.print("Enter the contact number :");
		
		String value = rd.next();
		String Regex ="[789][0-9]{9}";
        boolean result = value.matches(Regex);
        if(result)
        {
        	System.out.println("Given Number is valid");
        }
        else {
        	System.out.println("Given Number is not valid");
        }
		
	}``````````````````11111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111

}
