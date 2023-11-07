		import java.util.Scanner;

public class TaxCalculator {
	public static void main(String[] args) {
		
		int type = filingPrompt();
		int income = incomePrompt();
		
		double tax = 0;
		
		switch(type){
			case 0 :
				System.out.println("The Tax income is $" + singleFiler(income));
				break;
			case 1 :
			{
				System.out.println("The Tax income is $" + marriedJoint(income));
				break;
			}
			case 2 :
			{
				
				System.out.println("The Tax income is $" + marriedSeperate(income));
				break;
				
			}
			case 3 :
			{
				
				System.out.println("The Tax income is $" + Head(income));
				break;
			}
			
		}
	}
	
	public static double singleFiler(int income)
	{
		double tax = 0;
		
		if (income <= 10275)
		{
			tax = income*.1;
		}
		else if(income <= 41775)
		{
			tax = 10275*.1 + (income-10275)*.12;
		}
		else if(income <= 89075)
		{
			tax = 10275*.1 + (41775-10275)*.12 + (income-41775)*.22;
		}
		else if(income <= 170050)
		{
			tax = 10275*.1 + (41775-10275)*.12 + (89075-41775)*.22 + (income-89075)*.24;
		}
		else if(income <= 215950)
		{
			tax = 10275*.1 + (41775-10275)*.12 + (89075-41775)*.22 + (170050-89075)*.24 + (income-170050)*.32;
		}
		else if(income <= 539900)
		{
			tax = 10275*.1 + (41775-10275)*.12 + (89075-41775)*.22 + (170050-89075)*.24 + (215950-170050)*.32 + (income-215950)*.35;
		}
		else
		{
			tax = 10275*.1 + (41775-10275)*.12 + (89075-41775)*.22 + (170050-89075)*.24 + (215950-170050)*.32 + (539900-215950)*.35 + (income-539900)*.37;
		}
		
		return tax;
	}
	
	public static double marriedJoint(int income)
	{
		double tax = 0;
		
		if (income <= 20550)
		{
			tax = income*.1;
		}
		else if(income <= 83550)
		{
			tax = 20550*.1 + (income-20550)*.12;
		}
		else if(income <= 178150)
		{
			tax = 20550*.1 + (83550-20550)*.12 + (income-83550)*.22;
		}
		else if(income <= 340100)
		{
			tax = 20550*.1 + (83550-20550)*.12 + (178150-83550)*.22 + (income-178150)*.24;
		}
		else if(income <= 431900)
		{
			tax = 20550*.1 + (83550-20550)*.12 + (178150-83550)*.22 + (340100-178150)*.24 + (income-340100)*.32;
		}
		else if(income <= 647850)
		{
			tax = 20550*.1 + (83550-20550)*.12 + (178150-83550)*.22 + (340100-178150)*.24 + (431900-340100)*.32 + (income-431900)*.35;
		}
		else
		{
			tax = 20550*.1 + (83550-20550)*.12 + (178150-83550)*.22 + (340100-178150)*.24 + (431900-340100)*.32 + (647850-431900)*.35 + (income-647850)*.37;
		}
		
		return tax;
	}
	
	public static double marriedSeperate(int income)
	{
		double tax = 0;
		
		if (income <= 10275)
		{
			tax = income*.1;
		}
		else if(income <= 41775)
		{
			tax = 10275*.1 + (income-10275)*.12;
		}
		else if(income <= 89075)
		{
			tax = 10275*.1 + (41775-10275)*.12 + (income-41775)*.22;
		}
		else if(income <= 170050)
		{
			tax = 10275*.1 + (41775-10275)*.12 + (89075-41775)*.22 + (income-89075)*.24;
		}
		else if(income <= 215950)
		{
			tax = 10275*.1 + (41775-10275)*.12 + (89075-41775)*.22 + (170050-89075)*.24 + (income-170050)*.32;
		}
		else if(income <= 323925)
		{
			tax = 10275*.1 + (41775-10275)*.12 + (89075-41775)*.22 + (170050-89075)*.24 + (215950-170050)*.32 + (income-215950)*.35;
		}
		else
		{
			tax = 10275*.1 + (41775-10275)*.12 + (89075-41775)*.22 + (170050-89075)*.24 + (215950-170050)*.32 + (323925-215950)*.35 + (income-323925)*.37;
		}
		
		return tax;
	}
	
	public static double Head(int income)
	{
		double tax = 0;
		
		if (income <= 14650)
		{
			tax = income*.1;
		}
		else if(income <= 55900)
		{
			tax = 14650*.1 + (income-14650)*.12;
		}
		else if(income <= 89050)
		{
			tax = 14650*.1 + (55900-14650)*.12 + (income-55900)*.22;
		}
		else if(income <= 170050)
		{
			tax = 14650*.1 + (55900-14650)*.12 + (89050-55900)*.22 + (income-89050)*.24;
		}
		else if(income <= 215950)
		{
			tax = 14650*.1 + (55900-14650)*.12 + (89050-55900)*.22 + (170050-89050)*.24 + (income-170050)*.32;
		}
		else if(income <= 539900)
		{
			tax = 14650*.1 + (55900-14650)*.12 + (89050-55900)*.22 + (170050-89050)*.24 + (215950-170050)*.32 + (income-215950)*.35;
		}
		else
		{
			tax = 14650*.1 + (55900-14650)*.12 + (89050-55900)*.22 + (170050-89050)*.24 + (215950-170050)*.32 + (539900-215950)*.35 + (income-539900)*.37;
		}
		
		return tax;
	}
	
	public static int filingPrompt()
	{
		Scanner scan = new Scanner(System.in);
		String filingType;
		System.out.println("Enter a number for your filing type. 0 = Single Filers, 1 =  Married Filing Jointly, 2 = Married Filing Seperatly, 3 = Head of Household");
		filingType = scan.nextLine();
		while(!filingType.matches("[0-3]+"))
		{
			System.out.println("Enter a number for your filing type. 0 = Single Filers, 1 =  Married Filing Jointly, 2 = Married Filing Seperatly, 3 = Head of Household");
			filingType = scan.nextLine();
		}
		System.out.println();
		return Integer.parseInt(filingType);
	}
	
	public static int incomePrompt()
	{
		Scanner scan = new Scanner(System.in);
		String income;
		System.out.println("Enter your income");
		income = scan.nextLine();
		while(!income.matches("[0-9]+"))
		{
			System.out.println("Enter your income");
			income = scan.nextLine();
		}
		
		System.out.println();
		return Integer.parseInt(income);
	}
}
