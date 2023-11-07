import java.io.File;
import java.io.FileWriter;
import java.util.Stack;
import java.io.IOException;

public class DirectoryUtil {
	public static void main(String[] args) {
		String name = args[0];
		try {
			FileWriter writer = new FileWriter(name+".log");//Open File Writer
			Stack<File> stack = new Stack<>(); // initialize a Stack
			File folder = new File(name);
			stack.push(folder);

			while (!stack.isEmpty()) {
				File recent = stack.pop(); //Take file out of stack to check for other folders/information

				if (recent.isDirectory()) {
					File[] files = recent.listFiles();
					long folderSize = 0;
					int fileCount = 0;
					for (File f : files) // Iterate through the files in files array created by the recent file taken out
					{ 
						if (f.isFile()) 
						{
							folderSize += f.length();
							fileCount++;
						} 
						else if (f.isDirectory())  //Check if directory
						{
							folderSize += f.length();
							stack.push(f);
						}
					}
					writer.write(fileCount +"\t"+folderSize+"\t"+recent.getPath()+"\n"); // write into the final report folder
				}
			}
			writer.close();
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
}