package trabalho1;

import java.io.File;

public class Thread3 extends Thread{

	@Override
	public void run() {
		
try {
			
			while(true) {
			
			File f = new File("Pasta3/*.txt");
			System.out.println("Verificando o diretorio...");
			Thread1.sleep(5000);
			if(f.exists()){
			    System.out.println("O arquivo existe!");
			    // Arquivo a ser movido
		        File arquivo = new File("Pasta2/Arq.txt");
		        
		        // Diretorio de destino
	            File diretorioDestino = new File("Pasta3");
	            
	            // Move o arquivo para o novo diretorio
	            boolean sucesso = arquivo.renameTo(new File(diretorioDestino, arquivo.getName()));
	            if (sucesso) {
	                System.out.println("Arquivo movido para '" + diretorioDestino.getAbsolutePath() + "'");
	            } else {
	                System.out.println("Erro ao mover arquivo '" + arquivo.getAbsolutePath() + "' para '"
	                        + diretorioDestino.getAbsolutePath() + "'");
	            }
			    
			    break;
			}else{
			    System.out.println("O arquivo não existe!");
			}
			
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Deu erro!");
		}
	}
}
