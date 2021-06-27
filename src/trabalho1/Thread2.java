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
		
		FileReader fr = null;
			
			try {
				fr = new FileReader("Pasta2/Arq.txt");
				
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			
			}
			
			try (BufferedReader ler = new BufferedReader(fr)) {
				String linha = "";
				
				do {
				
					System.out.println(linha);
					linha = ler.readLine();
					int result = Integer.parseInt(linha); 
					int result1 = result + result;
					String r = Integer.toString(result1);
					
					
					for(int i = 0; i < r.length();i++) {
						
						gravarDados(r,"Arq.txt");
						
					}
					String nome = "Pasta2/Arq.txt";  
					File f = new File(nome);  
					f.delete();
				}while(linha != null && linha != "");
				
			
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Deu errado!");
		}
	}
	

	public void gravarDados(String texto, String nomeArquivo) throws IOException {
		
		FileWriter gravar = new FileWriter("Pasta3/resultado.txt");
		BufferedWriter s = new BufferedWriter(gravar);
		s.write(nomeArquivo + ":" + texto + "\n");
		s.flush();
		s.close();
		gravar.close();
	}
}
