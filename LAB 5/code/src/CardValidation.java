import java.util.Scanner;
public class CardValidation {
	public static void main(String[] args)
	{
		System.out.println("Enter your creditcard number");
		Scanner scan = new Scanner(System.in);
		long cardNum = scan.nextLong();
		scan.close();
		if (isValid(cardNum))
		{
			System.out.println("The card number is valid");
		}
		else
		{
			System.out.println("The card number is not valid");
		}
	}
	
	public static boolean isValid(long number)
	{
		int size = (number + "").length();
		return size >= 13 && size <= 16 && (firstNums(number,1)==4 || 
				firstNums(number,1)==5 || firstNums(number,2)==37 || 
				firstNums(number,1)==6) && (totalSum(number)%10==0);
	}
	
	public static int evenSum(String s)
	{
		int sum = 0;
		
		for (int i = s.length() - 2; i>=0; i-=2) // sum of even numbers
		{
			int ind = Integer.parseInt(s.charAt(i)+"")*2;
			if (ind < 9)
				sum += ind;
			else
				sum += ind/10 + ind%10;
		}
		
		return sum;
	}
	
	public static int oddSum(String s)
	{
		{
			int sum = 0;
			
			for (int i = s.length() - 1; i>=0; i-=2) // sum of odd numbers
			{
				sum += Integer.parseInt(s.charAt(i)+"");
			}
			
			return sum;
		}
	}
	
	public static int totalSum(long number) // sum of even numbers and odd numbers
	{
		String cardString = number + "";
		return evenSum(cardString) + oddSum(cardString);
	}
	
	public static long firstNums(long number, int i) {
		if ((number+"").length() > i)  {
			String num = number + "";
			return  Long.parseLong(num.substring(0, i));
		}
		return number;
	}
}
