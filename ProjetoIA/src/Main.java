import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Main {

	Knn algoritmo = new Knn();
	
	public static void main(String[] args) throws FileNotFoundException {
		ArrayList<String> result;
		Knn algoritmo = new Knn();
		result = algoritmo.Knnalgo(3, "Re8.csv", true);
		
		System.out.println(result.get(1));
		
	}
	
}
