package trabalho1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;

public class Thread2 extends Thread{

	
	
	
	@Override
	public void run() {
		

		//File arq = new File("Pasta2/arq.txt");
		
				//while(true) {
				//if(arq.exists()) {
					try (BufferedReader ler = new BufferedReader(new FileReader(new File("Pasta2/Arq1.txt")))) {
						String linha = "";
						
						do {
									
							linha = ler.readLine();
							String[] num = linha.split("(?<=.)");
							int[] numC = new int[num.length];
							int result = 0;
							
							for(int i = 0; i < num.length; i++) {
								numC[i] = Integer.parseInt(num[i]);
							}
							
							for(int i = 0; i < numC.length; i++) {
								result += numC[i];
							}
							String r = Integer.toString(result);
								
							boolean existe = (new File("Pasta3/resultado.txt")).exists();
					         
							if(!existe) {
								File arquivo = new File("Pasta3/resultado.txt");
				                System.out.println("o arquivo foi criado com sucesso em '" + arquivo.getAbsolutePath() + "'");
				            } else {
				                System.out.println("O arquivo de resultados ja existe ;)");
				                gravarDados(r,"Arq1.txt");  
				                File f = new File("Pasta2/Arq1.txt");  
				                f.delete();
				            }
						}while(linha != null && linha != "");
						
						} catch (Exception e) {
					// TODO: handle exception
						}
					//} else {
						
						//try {
							//System.out.println("Arquivo n�o encontrado... ");
							//Thread2.sleep(20000);
						//}catch (Exception e) {
							
						//}
					//}
				//}
			}
			

			public void gravarDados(String texto, String nomeArquivo) throws IOException {
				
				FileWriter gravar = new FileWriter("Pasta3/resultado.txt", true);
				BufferedWriter s = new BufferedWriter(gravar);
				s.write(nomeArquivo + ": " + texto);
				s.flush();
				s.close();
				gravar.close();
				System.out.println("Resultados gravados!");
			}
		
}



