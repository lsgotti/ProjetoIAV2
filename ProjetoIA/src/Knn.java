import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class Knn {
	// função de calculo de distancia (Euclidiana)
	
	private ArrayList<String> res = new ArrayList<String>();
	
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
	
	public double TaxadeAcerto(ArrayList<String> list, String nomedoarquivo) throws FileNotFoundException {
		LeitorArquivo reader = new LeitorArquivo();
		reader.abrirArquivo(nomedoarquivo);
		reader.lerArquivo();
		
		double taxa;
		double acerto = 0;
		double total =0;
		for(int i = 0; i < list.size(); i++)
		{
			if(list.get(i).equals("Recommended") && reader.getLinhas().get(i+1)[0].contains("V_Recommended"))
			{
				acerto++;
			}
			else if(list.get(i).equals("Not Recommended") && reader.getLinhas().get(i+1)[0].contains("V_Not_Recommended"))
			{
				acerto++;
			}
			total++;
		}
		taxa = acerto/total;
		
		return taxa;
	}
	
	public double precisao(ArrayList<String> list, String nomedoarquivo) throws FileNotFoundException {
		LeitorArquivo reader = new LeitorArquivo();
		reader.abrirArquivo(nomedoarquivo);
		reader.lerArquivo();
		double verdadeiro_positivo = 0, verdadeiro_negativo = 0, falso_positivo =0, falso_negativo = 0, retorno =0;
		for(int i = 0; i < list.size(); i++)
		{
			if(list.get(i).equals("Recommended") && reader.getLinhas().get(i+1)[0].contains("V_Recommended"))
			{
				verdadeiro_positivo++;
			}
			else if(list.get(i).equals("Not Recommended") && reader.getLinhas().get(i+1)[0].contains("V_Not_Recommended"))
			{
				falso_positivo++;
			}
			
		}
		retorno = (verdadeiro_positivo)/(verdadeiro_positivo+falso_positivo);
		return retorno;
		
	}
	
	public double recall(ArrayList<String> list, String nomedoarquivo) throws FileNotFoundException {
		LeitorArquivo reader = new LeitorArquivo();
		reader.abrirArquivo(nomedoarquivo);
		reader.lerArquivo();
		double verdadeiro_positivo = 0, verdadeiro_negativo = 0, falso_positivo =0, falso_negativo = 0, retorno =0;
		for(int i = 0; i < list.size(); i++)
		{
			if(list.get(i).equals("Recommended") && reader.getLinhas().get(i+1)[0].contains("V_Recommended"))
			{
				verdadeiro_positivo++;
			}
			else if(list.get(i).equals("Not Recommended") && reader.getLinhas().get(i+1)[0].contains("V_Recommended"))
			{
				falso_negativo++;
			}
			
		}
		retorno = (verdadeiro_positivo)/(verdadeiro_positivo+falso_negativo);
		return retorno;	
	}
	
	public double mediaHarmonica(ArrayList<String> list, String nomedoarquivo) throws FileNotFoundException {
		LeitorArquivo reader = new LeitorArquivo();
		reader.abrirArquivo(nomedoarquivo);
		reader.lerArquivo();
		double verdadeiro_positivo = 0, verdadeiro_negativo = 0, falso_positivo =0, falso_negativo = 0, retorno =0;
		for(int i = 0; i < list.size(); i++)
		{
			if(list.get(i).equals("Recommended") && reader.getLinhas().get(i+1)[0].contains("V_Recommended"))
			{
				verdadeiro_positivo++;
			}
			else if(list.get(i).equals("Not Recommended") && reader.getLinhas().get(i+1)[0].contains("V_Recommended"))
			{
				falso_negativo++;
			}
			else if(list.get(i).equals("Not Recommended") && reader.getLinhas().get(i+1)[0].contains("V_Not_Recommended"))
			{
				falso_positivo++;
			}
			
		}
		retorno = (2*verdadeiro_positivo)/((2*verdadeiro_positivo)+falso_positivo+falso_negativo);
		return retorno;
		
	}

	public ArrayList<String> Knnalgo(int k, String nomedoarquivo, boolean euclidiana) throws FileNotFoundException {
		LeitorArquivo reader = new LeitorArquivo();
		reader.abrirArquivo(nomedoarquivo);
		reader.lerArquivo();
		int i, j, count;
		int re = 0, notre = 0;
		double resultadodistancia=0;
		System.out.println("indo");
		ArrayList<ArrayList<DistanciaIndex>> DI = new ArrayList<ArrayList<DistanciaIndex>>();
		
		
		for (i = 1; i < 1194; i++) {
			//System.out.println("i= " + i);
			ArrayList<DistanciaIndex> inst = new ArrayList<DistanciaIndex>();
			count = 0;
			for (j = 1194; j < reader.getLinhas().size(); j++) {
			//	System.out.println("j= " + j);
				if(euclidiana = true)
				{
					resultadodistancia = distancia(reader.getLinhas().get(i), reader.getLinhas().get(j));
					//System.out.println(reader.getLinhas().get(i)[0]);
					//System.out.println(resultadodistancia);
				}
				else
				{
					resultadodistancia = manhatan(reader.getLinhas().get(i), reader.getLinhas().get(j));
				}

				if (count < k) {
					count++;
					inst.add(new DistanciaIndex(j, resultadodistancia));
					//System.out.println(inst.get(0).getDistancia());
					//System.out.println(inst.get(0).getIndex());
					//System.out.println(j);
					//System.out.println(resultadodistancia);
					
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
			//System.out.println(j);
			//System.out.println(inst.get(0).getIndex());
			
			for (int t=0;t<inst.size();t++)
			{
				//System.out.println(inst.size());
				//System.out.println(t);
				//System.out.println(reader.getLinhas().get(inst.get(t).getIndex())[0]);
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
				//System.out.println("foi reco");
			}
			else if(notre>re)
			{
				res.add("Not Recommended");
				//System.out.println("no reco");
			}

		}
		System.out.println("Finishou");
		return res;
	}

}