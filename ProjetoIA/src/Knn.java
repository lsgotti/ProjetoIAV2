import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class Knn {

	// função de calculo de distancia (Euclidiana)
	private static double distancia(String[] a, String[] b) {
		double soma = 0;
		double x, y;
		for (int i = 1; i < a.length; i++) {
			x = Double.parseDouble(a[i]);
			y = Double.parseDouble(b[i]);
			soma += (x - y) * (x - y);
		}
		return (double) Math.sqrt(soma);
	}

	private static String Knn(int k, String nomedoarquivo) throws FileNotFoundException {
		String res = "Not Recommended";

		LeitorArquivo reader = new LeitorArquivo();
		reader.abrirArquivo(nomedoarquivo);
		reader.lerArquivo();
		int i, j, count;
		double resultadodistancia;
		ArrayList<ArrayList<DistanciaIndex>> DI = new ArrayList<ArrayList<DistanciaIndex>>();
		for (i = 1; i < 1194; i++) {
			ArrayList<DistanciaIndex> inst = new ArrayList<DistanciaIndex>();
			count = 0;
			for (j = 1194; j < reader.getLinhas().size(); j++) {
				resultadodistancia = distancia(reader.getLinhas().get(i), reader.getLinhas().get(j));

				if (count < k) {
					count++;
					inst.add(new DistanciaIndex(j, resultadodistancia));
				} else {
					double maior = 0;
					int maiorindex = -1;
					for (int z = 0; z < count; z++) {

						if (inst.get(z).getDistancia() > maior) {
							maior = inst.get(z).getDistancia();
							maiorindex = z;
						}

					}
					if (maior > resultadodistancia) {
						inst.get(maiorindex).setDistancia(resultadodistancia);
					}

				}
			}

		}

		return res;
	}

}