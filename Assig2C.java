//Solomon Astley, PeopleSoft #3938540
//CS 0445 Ramirez, Recitation Tuesday 10:00
//This is the driver program to demonstrate the method I implemented for bonus points

public class Assig2C
{
	public static void main(String [] args)
	{
		System.out.println("\nThis program is testing the method \nimplemented for bonus points for Assignment 2\n");
		MyStringBuilder2 b1 = new MyStringBuilder2("We are going to the market and we are going to buy food\n");

		System.out.println(b1);
		int lastIndex = b1.lastIndexOf("we", 12);
		System.out.println("Last index (starting at 12) of \"we\" in the \nMyStringBuilder is at index: " + lastIndex + "\n");
		lastIndex = b1.lastIndexOf("we", 36);
		System.out.println("Starting from index 36, the lastIndexOf() \nmethod finds no instance of we and returns this: " + lastIndex);
	}
}