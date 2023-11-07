import java.util.Scanner;
public class MaxCounter {
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		System.out.println("Input a series of numbers with a space inbetween");
		String a = scan.nextLine();
		System.out.println(maxCounter(parseValues(a))[0] + " is the largest number");
		System.out.println(maxCounter(parseValues(a))[1] + " is the amount of occurances");
	}
	
	public static int[] maxCounter(int[] values)
	{
		int max = 0;
		int occ = 0;
		int[] MaxAndOcc = new int[2];
		
		for (int i : values)
		{
			if (i>=max)
			{
				max=i;
			}
		}
		
		for (int i : values)
		{
			if (i == max)
			{
				occ += 1;
			}
		}
		
		MaxAndOcc[0]=max;
		MaxAndOcc[1]=occ;
			
		return MaxAndOcc;
	}
	
	public static int[] parseValues(String input)
	{
		String[] stringArray = input.split("\\s+");
		int[] intArray = new int[stringArray.length];
		for (int i=0;i<input.length();i++)
		{
			try 
			{
				intArray[i]=Integer.parseInt(stringArray[i]);
			} 
			catch (Exception e)
			{}
		}
		return intArray;
		
	}
	
	
}
