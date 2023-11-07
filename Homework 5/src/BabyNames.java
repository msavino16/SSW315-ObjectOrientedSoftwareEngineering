import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.util.HashMap;

public class BabyNames {

	public static void main(String args[]) throws IOException {
		NameReader("2011");
	}

	public static void NameReader(String year) throws IOException {
		File file = new File("namesbystate");
		
		String[] entryYears = {year};
		
		if (year.equals("all"))
		{
			entryYears = new String[111];
			for (int i = 1910; i >2021; i++)
			{
				entryYears[i-1910] = i + "";
			}
		}
		
		if (year.contains("s"))
		{
			int y = Integer.parseInt(year.substring(0,year.length()-1));
			entryYears = new String[10];
			for (int i = 0; i<10; i++)
			{
				entryYears[i] = i + y + "";
			}
		}
		try {
			File[] fileArray = file.listFiles();

			HashMap<String, HashMap<String, Integer>> boys = new HashMap<String, HashMap<String, Integer>>();
			HashMap<String, HashMap<String, Integer>> girls = new HashMap<String, HashMap<String, Integer>>();
			for (String y : entryYears)
			{
			for (File f : fileArray) {
				BufferedReader reader = new BufferedReader(new FileReader(f));
				try {
					String text = reader.readLine();
					while (text != null) {
						String[] split = text.split(",", 0);
						if (split[2].equals(y)) // Still need to add use case of YYYYs and all
						{
							if (split[1].equals("F")) // When they're girls
							{
								if (!girls.containsKey(y)) {
									girls.put(y, new HashMap<>());
								}
								if (!girls.get(y).containsKey(split[3])) {
									girls.get(y).put(split[3], Integer.parseInt(split[4]));
								} else {
									int count = girls.get(y).get(split[3]);
									girls.get(y).put(split[3], Integer.parseInt(split[4]) + count);
								}

							} else // when they're boys
							{
								if (!boys.containsKey(y)) {
									boys.put(y, new HashMap<>());
								}
								if (!boys.get(y).containsKey(split[3])) {
									boys.get(y).put(split[3], Integer.parseInt(split[4]));
								} else {
									int count = boys.get(y).get(split[3]);
									boys.get(y).put(split[3], Integer.parseInt(split[4]) + count);
								}

							}
						}
						text = reader.readLine();
					}
					reader.close();


				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			}
			FileWriter writer = new FileWriter("BoyRank2011.csv");
			
			String years = "";
			
			for (String k : boys.keySet())
			{
				years += k + ",";

			}
			years = years.substring(0,years.length()-1);
			writer.write(years);
			
			String soln = boys.get(year).toString();
			writer.write(soln);
			
			
			
			writer.close();
			
			writer = new FileWriter("GirlRank2011.csv");
			
			years = "";
			
			for (String k : girls.keySet())
			{
				years += k + ",";
			}
			
			years = years.substring(0,years.length()-1);
			writer.write(years);
			
			soln = girls.get(year).toString();
			writer.write(soln);
			
			writer.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}

}
