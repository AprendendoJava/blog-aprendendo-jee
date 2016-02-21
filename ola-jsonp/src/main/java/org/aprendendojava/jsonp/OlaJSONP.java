package org.aprendendojava.jsonp;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.json.JsonValue;
import javax.json.stream.JsonGenerator;

public class OlaJSONP {
	
	static SimpleDateFormat FORMATOR = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss"); 
	static String ARQUIVO = OlaJSONP.class.getResource("/artigos.js").getFile();

	public static void main(String[] args) throws Exception {
		javaParaJson();
		jsonParaJava();
	}

	public static void javaParaJson() throws IOException {
		// cria objetos do tipo artigo de exemplo
		Artigo a1 = new Artigo("Java 8", new Date(), "jesuino", "java 8 é a melhor release do Java... Tem Lambdas");
		Artigo a2 = new Artigo("Java EE 8", new Date(), "william", "Em breve...");
		Artigo a3 = new Artigo("Code", new Date(), "Linus Torwalds", "Talking is cheap, show the code");
		List<Artigo> artigos = Arrays.asList(a1, a2, a3);
		// abrimos o arquivo
		FileOutputStream fos = new FileOutputStream(ARQUIVO);
		// um gerador de JSON que escreve no arquivo
		JsonGenerator geradorJson = Json.createGenerator(fos);
		// começamos a escrever um Array JSON
		geradorJson.writeStartArray();
		for (Artigo artigo : artigos) {
			// vamos ler a data em um formato mais legível
			String data = FORMATOR.format(artigo.getDataPublicacao());
			// começando a escrever o objeto JSON e então as propriedades, por fim fecha o objeto
			geradorJson.writeStartObject()
				.write("nome", artigo.getNome())
				.write("dataPublicacao", data)
				.write("autor", artigo.getAutor())
				.write("conteudo", artigo.getConteudo())
			.writeEnd();		
		}
		// terminamos o array e escremos no Stream (agora devemos ver a saída no console)
		geradorJson.writeEnd().close();
		System.out.println("Lista de artigos convertidos para JSON: ");
		System.out.println(Files.readAllLines(Paths.get(ARQUIVO)));
		System.out.println("\n");
	}

	public static void jsonParaJava() throws Exception {
		// Nossa lista de artigos
		List<Artigo> artigos = new ArrayList<>();
		// aqui estamos lendo o arquivo
		InputStream isEntrada = Files.newInputStream( Paths.get(ARQUIVO));
		// criamos um leitor Json para o input Stream do arquivo
		JsonReader leitor = Json.createReader(isEntrada);
		// sabemos que tem um array no topo dele, assim lemos o array
		JsonArray arrayArtigos = leitor.readArray();
		// para cada valor do Array
		for (JsonValue valorJson : arrayArtigos) {
			// sabemos que temos um objeto nesse array, assim não precisamos verificar o tipo e já fazer casting
			JsonObject objetoJson = (JsonObject) valorJson;
			String nome = objetoJson.getString("nome");
			String dataPublicacaoStr = objetoJson.getString("dataPublicacao");
			String autor = objetoJson.getString("autor");
			String conteudo = objetoJson.getString("conteudo");
			Date dataPublicacao = FORMATOR.parse(dataPublicacaoStr);
			// agora estamos prontos para criar nosso artigo
			artigos.add(new Artigo(nome, dataPublicacao, autor, conteudo));
		}
		// fechando o leitor...
		leitor.close();
		// pronto! Vamos só imprimiro nossos objetos lidos do arquivo
		System.out.println("Artigos lidos: ");
		for (Artigo artigo : artigos) {
			System.out.println("\tNome: " + artigo.getNome());
			System.out.println("\tData Publicação: " + artigo.getDataPublicacao());
			System.out.println("\tAutor: " + artigo.getAutor());
			System.out.println("\tConteúdo: " + artigo.getConteudo());
			System.out.println("\t\t--");
		}
	}
}