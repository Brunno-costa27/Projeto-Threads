package trabalho1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Thread1 extends Thread{

	
	@Override
	public void run() {
		
		
		
		try {
			
			while(true) {
			
//				    String path = "Pasta1";
//					String pesquisar = ".txt";	
//					File caminho = new File(path);
//					boolean caminhoValido = caminho.exists();
//					boolean eDiretorio = caminho.isDirectory();				
//					if(caminhoValido && eDiretorio){
//						String[] conteudo = caminho.list();
//						for (String arquivo : conteudo) {
//							if(arquivo.contains(pesquisar)){
//								System.out.println(arquivo);
//							}
//						}
//					}	
				
				
				
			File f = new File("Pasta1/Arq1.txt");
			System.out.println("Verificando o diretorio...");
			Thread1.sleep(5000);
			if(f.exists()){
			    System.out.println("O arquivo existe!");
			    	
			    // Arquivo a ser movido
		        File arquivo = new File("Pasta1/Arq1.txt");
		        
		        // Diretorio de destino
	            File diretorioDestino = new File("Pasta2");
	            
	            // Move o arquivo para o novo diretorio
	            boolean sucesso = arquivo.renameTo(new File(diretorioDestino, arquivo.getName()));
	            if (sucesso) {
	                System.out.println("Arquivo movido para '" + diretorioDestino.getAbsolutePath() + "'");
	                
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
								File arquivo1 = new File("Pasta3/resultado.txt");
				                System.out.println("o arquivo foi criado com sucesso em " + arquivo1.getAbsolutePath() + "'");
				            } else {
				                System.out.println("O arquivo de resultados ja existe!");
				                gravarDados(r,"Arq1.txt");  
				                File f1 = new File("Pasta2/Arq1.txt");  
				                f1.delete();
				            }
						}while(linha != null && linha != "");
						
						} catch (Exception e) {
					// TODO: handle exception
						}
	               
	            } else {
	                System.out.println("Erro ao mover arquivo '" + arquivo.getAbsolutePath() + "' para '"
	                        + diretorioDestino.getAbsolutePath() + "'");
	            }
			    
			}else{
			    System.out.println("O arquivo não existe!");
			       
			   
			}
			
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Deu erro!");
		}
		
		}
	
	public void gravarDados(String texto, String nomeArquivo) throws IOException {
		
		FileWriter gravar = new FileWriter("Pasta3/resultado.txt", true);
		BufferedWriter s = new BufferedWriter(gravar);
		s.write(nomeArquivo + " : " + texto);
		s.write("\n");
		s.flush();
		s.close();
		gravar.close();
		System.out.println("Resultados gravados!");
	}
	
	
	
	
	
	}

