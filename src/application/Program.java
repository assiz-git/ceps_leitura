package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Program {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		String sd1 = sdf.format(new Date());
		String path = "M:\\ID_221.479 - DP-2016-0040878 - Base de Perdas - TG\\Produção\\20181228\\A100A.G050.txt";
		path="L:\\Rogerio\\Cursos\\Udemy\\Ceps\\ceps.csv";
		BufferedReader br = null;
		FileReader fr = null;
		try {
			//Integer linhas = 0;
			fr = new FileReader(path);
			br = new BufferedReader(fr);
			String line = br.readLine();
			while (line != null) {
				//linhas++;
				//System.out.println(line);
				if (line.contains(";")) {
					//String[] campo = line.split("\\|");
					String[] campo = line.split("\\;");
					//for (int i=0;i<campo.length;i++) {
						StringBuilder stb = new StringBuilder();
						stb.append("{\n");
						//stb.append("  \"dados\": \n");
						//stb.append("    {\n");
						stb.append("	\"cep\": \"" + campo[0] + "\",\n");
						stb.append("	\"cidade\": \"" + campo[1] + "\",\n");
						stb.append("	\"estado\": \"" + campo[2] + "\",\n");
						stb.append("	\"bairro\": \"" + campo[3] + "\",\n");
						stb.append("	\"logradouro\": \"" + campo[4] + "\",\n");
						stb.append("	\"complemento\": \"" + campo[5] + "\"\n");
						//stb.append("    }\n");
						stb.append("}\n\n");
						System.out.println(stb);
						//System.out.println("Campo " + i + ": " + campo[i]);
					//}
				}
				line = br.readLine();
			}
			//System.out.println(linhas);
		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		} finally {
			try {
				if (br != null)
					br.close();
				if (fr != null)
					fr.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		String sd2 = sdf.format(new Date());
		System.out.println(sd1);
		System.out.println(sd2);
	}

}
