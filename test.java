public class test
{
	public static void main (String [] args)
	{
		System.out.println("Starting test...");
		MyStringBuilder b = new MyStringBuilder("Testing");
		b.deleteCharAt(5);
		System.out.println(b);
		b.deleteCharAt(5);
		System.out.println(b);
	}
}