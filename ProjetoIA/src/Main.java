import java.io.FileNotFoundException;
import java.util.ArrayList;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

public class Main {

	Knn algoritmo = new Knn();
	
	

	public static void main(String[] args) throws FileNotFoundException {
		// Knn euclidiano k = 3
		ArrayList<String> result;
		Knn algoritmo = new Knn();
		
		result = algoritmo.Knnalgo(3, "Re8.csv", true);
		System.out.println(algoritmo.TaxadeAcerto(result, "Re8.csv") * 100 + " Por Cento"); //50.71851225697379 Por Cento
		System.out.println(algoritmo.precisao(result, "Re8.csv")); //0.185
		System.out.println(algoritmo.recall(result, "Re8.csv")); //0.19270833333333334
		System.out.println(algoritmo.mediaHarmonica(result, "Re8.csv")); //0.18877551020408162

		// Knn euclidiano k = 5
		ArrayList<String> result5eucl;
		result5eucl = algoritmo.Knnalgo(5, "Re8.csv", true);

		System.out.println(algoritmo.TaxadeAcerto(result5eucl, "Re8.csv") * 100 + " Por Cento"); //50.44435040203131 Por Cento
		System.out.println(algoritmo.precisao(result5eucl, "Re8.csv")); //0.15604026845637584
		System.out.println(algoritmo.recall(result5eucl, "Re8.csv")); //0.16048317515099222
		System.out.println(algoritmo.mediaHarmonica(result5eucl, "Re8.csv")); //0.15823054019566143
		
		// Knn euclidiano k = 7
		ArrayList<String> result7eucl;
		result7eucl = algoritmo.Knnalgo(7, "Re8.csv", true);
		
		System.out.println(algoritmo.TaxadeAcerto(result7eucl, "Re8.csv") * 100 + " Por Cento"); //50.943396226415096 Por Cento
		System.out.println(algoritmo.precisao(result7eucl, "Re8.csv")); //0.16362631288004423
		System.out.println(algoritmo.recall(result7eucl, "Re8.csv")); //0.1707035755478662
		System.out.println(algoritmo.mediaHarmonica(result7eucl, "Re8.csv")); //0.16709003669206887
		
		// Knn manhatan k = 3
		ArrayList<String> result3man;
		result3man = algoritmo.Knnalgo(3, "Re8.csv", false);

		System.out.println(algoritmo.TaxadeAcerto(result3man, "Re8.csv") * 100 + " Por Cento"); //50.71851225697379 Por Cento
		System.out.println(algoritmo.precisao(result3man, "Re8.csv")); //0.185
		System.out.println(algoritmo.recall(result3man, "Re8.csv")); //0.19270833333333334
		System.out.println(algoritmo.mediaHarmonica(result3man, "Re8.csv")); //0.18877551020408162

		// Knn manhatan k = 5
		ArrayList<String> result5man;
		result5man = algoritmo.Knnalgo(5, "Re8.csv", false);
		
		System.out.println(algoritmo.TaxadeAcerto(result5man, "Re8.csv") * 100 + " Por Cento"); //50.44435040203131 Por Cento
		System.out.println(algoritmo.precisao(result5man, "Re8.csv")); //0.15604026845637584
		System.out.println(algoritmo.recall(result5man, "Re8.csv")); //0.16048317515099222
		System.out.println(algoritmo.mediaHarmonica(result5man, "Re8.csv")); //0.15823054019566143

		// Knn manhatan k = 7
		ArrayList<String> result7man;
		result7man = algoritmo.Knnalgo(7, "Re8.csv", false);
		
		System.out.println(algoritmo.TaxadeAcerto(result7man, "Re8.csv") * 100 + " Por Cento"); //50.943396226415096 Por Cento
		System.out.println(algoritmo.precisao(result7man, "Re8.csv")); //0.16362631288004423
		System.out.println(algoritmo.recall(result7man, "Re8.csv"));//0.1707035755478662
		System.out.println(algoritmo.mediaHarmonica(result7man, "Re8.csv")); //0.16709003669206887

		
		
		

	}

}
