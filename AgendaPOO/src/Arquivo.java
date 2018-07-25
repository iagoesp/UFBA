import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Arquivo {
	private static File arquivo;

	Scanner scannerArquivo;

	static void criarArquivo(String arquivo) {
		try {
			File arquivoLogins = new File(arquivo);
			if (!arquivoLogins.exists()) {
				arquivoLogins.createNewFile();
			}

		} catch (IOException e2) {
			e2.printStackTrace();
		}

	}

	static boolean checarSeExiste(String arquivo, String stringChecar) {
		try {
			Scanner scannerArquivo = new Scanner(new File(arquivo));
			while (scannerArquivo.hasNextLine()) {
				String linha = scannerArquivo.nextLine();

				if (stringChecar.equals(linha)) {
					return true;
				}
			}
			return false;
		} catch (IOException e2) {
			e2.printStackTrace();
		}
		return false;

	}

	static void criarArquivoEescrever(String arquivo, String escrever) {
		File arquivoAux = null;

		try {
			arquivoAux = new File(arquivo);
			if (!arquivoAux.exists()) {
				arquivoAux.createNewFile();
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

		FileWriter fileWriter;
		try {
			fileWriter = new FileWriter(arquivoAux.getName(), true);
			BufferedWriter bw = new BufferedWriter(fileWriter);
			bw.write(escrever);
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	static void escreverNoArquivo(String arquivoNome, String escrever) {
		try {

			arquivo = new File(arquivoNome);
			if (!arquivo.exists()) {
				arquivo.createNewFile();
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			FileWriter fileWriter = new FileWriter(arquivo.getName(), true);
			BufferedWriter bw = new BufferedWriter(fileWriter);
			bw.write(escrever + "\n");
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	

}
