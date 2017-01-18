package org.aprendendojee.jsonb;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import javax.json.bind.JsonbConfig;
import javax.json.bind.JsonbException;

public class TestesJSONB {

	public static void main(String[] args) throws JsonbException, FileNotFoundException {

		// lendo de um arquivo somente
		Jsonb jsonb = JsonbBuilder.create();
		InputStream arquivoPessoa = TestesJSONB.class.getResourceAsStream("/pessoa.json");
		Pessoa pessoa1 = jsonb.fromJson(arquivoPessoa, Pessoa.class);
		System.out.println(pessoa1);

		// transformando o objeto em JSON
		Pessoa pessoa2 = new Pessoa(20, "Antônio", 1);
		String json = jsonb.toJson(pessoa2);
		System.out.println(json);

		// transformando o objeto em JSON formatado
		JsonbConfig conf = new JsonbConfig();
		conf.withFormatting(true);
		jsonb = JsonbBuilder.create(conf);
		pessoa2 = new Pessoa(20, "Antônio", 1);
		json = jsonb.toJson(pessoa2);
		System.out.println(json);

		// lendo uma lista de pessoa
		Type LISTA_PESSOA_TIPO = new ArrayList<Pessoa>() {}.getClass().getGenericSuperclass();
		InputStream arquivoPessoas = TestesJSONB.class.getResourceAsStream("/pessoas.json");
		List<Pessoa> pessoas = jsonb.fromJson(arquivoPessoas, LISTA_PESSOA_TIPO);
		System.out.println(pessoas);
	}

}
