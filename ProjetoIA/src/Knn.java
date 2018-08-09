import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class Knn {
	// função de calculo de distancia (Euclidiana)
	private double distancia(String[] a, String[] b) {
		double soma = 0;
		double x, y;
		for (int i = 1; i < a.length; i++) {
			x = Double.parseDouble(a[i]);
			y = Double.parseDouble(b[i]);
			soma += (x - y) * (x - y);
		}
		return (double) Math.sqrt(soma);
	}
	
	private double manhatan(String[] a, String[] b) {
		double soma = 0;
		double x, y;
		for (int i = 1; i < a.length; i++) {
			x = Double.parseDouble(a[i]);
			y = Double.parseDouble(b[i]);
			soma += Math.abs(x - y);
		}
		return (double) soma;
	}
	

	public ArrayList<String> Knnalgo(int k, String nomedoarquivo, boolean euclidiana) throws FileNotFoundException {
		ArrayList<String> res = new ArrayList<String>();
		LeitorArquivo reader = new LeitorArquivo();
		reader.abrirArquivo(nomedoarquivo);
		reader.lerArquivo();
		int i, j, count;
		int re = 0, notre = 0;
		double resultadodistancia=0;
		System.out.println("indo");
		ArrayList<ArrayList<DistanciaIndex>> DI = new ArrayList<ArrayList<DistanciaIndex>>();
		
		
		for (i = 1; i < 1194; i++) {
			System.out.println("i= " + i);
			ArrayList<DistanciaIndex> inst = new ArrayList<DistanciaIndex>();
			count = 0;
			for (j = 1194; j < reader.getLinhas().size(); j++) {
				System.out.println("j= " + j);
				if(euclidiana = true)
				{
					resultadodistancia = distancia(reader.getLinhas().get(i), reader.getLinhas().get(j));
				}
				else
				{
					resultadodistancia = manhatan(reader.getLinhas().get(i), reader.getLinhas().get(j));
				}

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
						inst.get(maiorindex).setIndex(j);
					}

				}
			}
			for (int t=0;t<inst.size();t++)
			{
				if (reader.getLinhas().get(inst.get(t).getIndex())[0].contains("V_Recommended"))
				{
					
					re++;
				}
				else if(reader.getLinhas().get(inst.get(t).getIndex())[0].contains("V_Not_Recommended"))
				{
					
					notre++;
				}
			}
			if(re>notre)
			{
				res.add("Recommended");
			}
			else if(notre>re)
			{
				res.add("Not Recommended");
			}

		}
		System.out.println("Finishou");
		return res;
	}

}