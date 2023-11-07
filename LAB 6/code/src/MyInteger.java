public class MyInteger {
	
	private int value;
	
	public MyInteger() // constructor methods
	{
		value = 0;
	}
	
	public MyInteger(int num)
	{
		value = num;
	}
	
	public MyInteger(String num)
	{
		value = parseInt(num);
	}
	
	public MyInteger(char[] num)
	{
		value = parseInt(num);
	}
	
	//---------------------------------------------------------------
	public int getValue() // get/set methods
	{
		return value;
	}
	
	public void setValue(int n)
	{
		value = n;
	}
	
	public void setValue(String n)
	{
		value = parseInt(n);
	}
	
	public void setValue(char[] n)
	{
		value = parseInt(n);
	}
	//---------------------------------------------------------------
	public boolean isEven() //IsEven,IsOdd,IsPrime non-static methods
	{
		return value%2==0;
	}
	
	public boolean isOdd()
	{
		return value%2==0;
	}
	
	public boolean isPrime()
	{
		if (value < 2)
			return false;
		
		for (int i = 2;i<=value/2;i++)
		{
			if (value%i==0)
				return false;
		}
	
		return true;
	}
	//---------------------------------------------------------------
	public static boolean isEven(int value) // IsEven,IsOdd,IsPrime static methods
	{
		return value%2==0;
	}
	
	public static boolean isOdd(int value)
	{
		return value%2==0;
	}
	
	public static boolean isPrime(int value)
	{
		if (value < 2)
			return false;
		
		for (int i = 2;i<=value/2;i++)
		{
			if (value%i==0)
				return false;
		}
	
		return true;
	}
	//---------------------------------------------------------------
	public static boolean isEven(MyInteger value) // IsEven,IsOdd,IsPrime static methods (MyInteger)
	{
		return value.getValue()%2==0;
	}
	
	public static boolean isOdd(MyInteger value)
	{
		return value.getValue()%2==0;
	}
	
	public static boolean isPrime(MyInteger value)
	{
		if (value.getValue() < 2)
			return false;
		
		for (int i = 2;i<=value.getValue()/2;i++)
		{
			if (value.getValue()%i==0)
				return false;
		}
	
		return true;
	}
	//---------------------------------------------------------------
	public boolean equals(int value) // equals methods
	{
		return this.value == value; 
	}
	
	public boolean equals(MyInteger value)
	{
		return this.value == value.getValue(); 
	}
	//---------------------------------------------------------------
	public static int parseInt(char[] value) //parseInt methods
	{
		int conversion = 0;
		for (int i = 0; i<value.length;i++)
		{
			conversion = conversion*10 + value[i]-'0';
		}
		return conversion;
	}
	
	public static int parseInt(String value)
	{
		return parseInt(value.toCharArray());
	}
}