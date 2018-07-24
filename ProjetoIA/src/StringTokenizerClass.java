import java.util.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class StringTokenizerClass {
	
	private static String readAllBytesJava7(String filePath)
	{
	    String content = "";
	    
	    try
	    {
	        content = new String ( Files.readAllBytes( Paths.get(filePath) ) );
	    }
	    catch (IOException e)
	    {
	        e.printStackTrace();
	    }
	    return content;
	}
	
	public static void main(String[] args) throws IOException {
		
		StringTokenizer st = new StringTokenizer(readAllBytesJava7("C:\\Users\\Pichau\\Downloads\\Teste\\The_Elder_Scrolls_V_Not_Recommended.txt"),"]");
		int i = 0;
		
		while (st.hasMoreTokens()){
			String fileName = "The_Elder_Scrolls_V_Not_Recommended_" + i + ".txt";
		
			File arquivo = new File(fileName);
			ObjectOutputStream oos = null;
			try{
			FileOutputStream fos = new FileOutputStream(arquivo);
			oos= new ObjectOutputStream(fos);
			oos.writeObject(st.nextToken());
			fos.close();
			} catch (Exception e){
				e.printStackTrace();
			}

			 i++;
			
			st.nextToken();	
			


	}
	}
}
