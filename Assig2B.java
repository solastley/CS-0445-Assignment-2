//Solomon Astley, PeopleSoft #3938540
//CS 0445 Ramirez, Recitation Tuesday 10:00
//This is the driver program for the second part of assignment 2 and it is meant to test the speed of
//MyStringBuilder vs StringBuilder and String

import java.util.*;
import java.io.*;

public class Assig2B
{
	public static void main(String [] args) throws IOException
	{
		String filename = new String(args[0]);

		//Determining the number of characters in the file for the average time calculations
		BufferedReader firstBuffer = new BufferedReader(new FileReader(new File(filename)));
		int count = 0;
		int c;
		while ((c = firstBuffer.read()) != -1)
		{
			count++;
		}

		System.out.println("The number of characters in the input file is " + count);

		//Testing the MyStringBuilder class now

		System.out.println("\nTESTING MYSTRINGBUILDER:\n");

		BufferedReader buffer = new BufferedReader(new FileReader(new File(filename)));
		MyStringBuilder myBuilder = new MyStringBuilder();

		//Testing append method
		long startTime = System.nanoTime();
		while ((c = buffer.read()) != -1)
		{
			myBuilder.append( (char) c);
		}
		long endTime = System.nanoTime();
		long totalTime = endTime - startTime;
		long averageTime = totalTime / count;
		System.out.println("Total time to append: " + totalTime + " nanoseconds.");
		System.out.println("Average time to append: " + averageTime + " nanoseconds.\n");

		//Testing delete method
		startTime = System.nanoTime();
		while (myBuilder.length() > 0)
		{
			myBuilder.delete(0, 1);
		}
		endTime = System.nanoTime();
		totalTime = endTime - startTime;
		averageTime = totalTime / count;
		System.out.println("Total time to delete: " + totalTime + " nanoseconds.");
		System.out.println("Average time to delete: " + averageTime + " nanoseconds.\n");

		buffer = new BufferedReader(new FileReader(new File(filename)));
		myBuilder = new MyStringBuilder();

		//Testing insert method
		startTime = System.nanoTime();
		int loc;
		while ((c = buffer.read()) != -1)
		{
			loc = myBuilder.length() / 2;
			myBuilder.insert(loc, (char) c);
		}
		endTime = System.nanoTime();
		totalTime = endTime - startTime;
		averageTime = totalTime / count;
		System.out.println("Total time to insert: " + totalTime + " nanoseconds.");
		System.out.println("Average time to insert: " + averageTime + " nanoseconds.\n\n");

		//Testing the StringBuilder class now

		System.out.println("TESTING STRINGBUILDER:\n");

		buffer = new BufferedReader(new FileReader(new File(filename)));
		StringBuilder builder = new StringBuilder();

		//Testing append method
		startTime = System.nanoTime();
		while ((c = buffer.read()) != -1)
		{
			builder.append((char) c);
		}
		endTime = System.nanoTime();
		totalTime = endTime - startTime;
		averageTime = totalTime / count;
		System.out.println("Total time to append: " + totalTime + " nanoseconds.");
		System.out.println("Average time to append: " + averageTime + " nanoseconds.\n\n");

		//Testing delete method
		startTime = System.nanoTime();
		while (builder.length() > 0)
		{
			builder.delete(0, 1);
		}
		endTime = System.nanoTime();
		totalTime = endTime - startTime;
		averageTime = totalTime / count;
		System.out.println("Total time to delete: " + totalTime + " nanoseconds.");
		System.out.println("Average time to delete: " + averageTime + " nanoseconds.\n");

		buffer = new BufferedReader(new FileReader(new File(filename)));
		builder = new StringBuilder();

		//Testing insert method
		startTime = System.nanoTime();
		while ((c = buffer.read()) != -1)
		{
			loc = builder.length() / 2;
			builder.insert(loc, (char) c);
		}
		endTime = System.nanoTime();
		totalTime = endTime - startTime;
		averageTime = totalTime / count;
		System.out.println("Total time to insert: " + totalTime + " nanoseconds.");
		System.out.println("Average time to insert: " + averageTime + " nanoseconds.\n\n");

		//Testing the String class now

		System.out.println("TESTING STRING:\n");

		buffer = new BufferedReader(new FileReader(new File(filename)));
		String myString = new String();

		//Testing insert method
		startTime = System.nanoTime();
		while ((c = buffer.read()) != -1)
		{
			myString += (char) c;
		}
		endTime = System.nanoTime();
		totalTime = endTime - startTime;
		averageTime = totalTime / count;
		System.out.println("Total time to append: " + totalTime + " nanoseconds.");
		System.out.println("Average time to append: " + averageTime + " nanoseconds.\n\n");

		//Testing delete method
		startTime = System.nanoTime();
		for (int i = 0; i < myString.length(); i++)
		{
			myString = myString.substring(0, myString.length() - 1);
		}
		endTime = System.nanoTime();
		totalTime = endTime - startTime;
		averageTime = totalTime / count;
		System.out.println("Total time to delete: " + totalTime + " nanoseconds.");
		System.out.println("Average time to delete: " + averageTime + " nanoseconds.\n");

		buffer = new BufferedReader(new FileReader(new File(filename)));
		myString = new String();

		//Testing insert method
		startTime = System.nanoTime();
		while ((c = buffer.read()) != -1)
		{
			loc = myString.length() / 2;
			String substring1 = myString.substring(0, loc);
			String substring2 = myString.substring(loc, myString.length());
			myString = substring1 + (char) c + substring2;
		}
		endTime = System.nanoTime();
		totalTime = endTime - startTime;
		averageTime = totalTime / count;
		System.out.println("Total time to insert: " + totalTime + " nanoseconds.");
		System.out.println("Average time to insert: " + averageTime + " nanoseconds.\n\n");
	}
}