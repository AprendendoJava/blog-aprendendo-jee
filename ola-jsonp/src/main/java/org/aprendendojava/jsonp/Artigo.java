package org.aprendendojava.jsonp;

import java.util.Date;

public class Artigo {

	private String nome;
	private Date dataPublicacao;
	private String autor;
	String conteudo;

	public Artigo(String nome, Date dataPublicacao, String autor, String conteudo) {
		super();
		this.nome = nome;
		this.dataPublicacao = dataPublicacao;
		this.autor = autor;
		this.conteudo = conteudo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getDataPublicacao() {
		return dataPublicacao;
	}

	public void setDataPublicacao(Date dataPublicacao) {
		this.dataPublicacao = dataPublicacao;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getConteudo() {
		return conteudo;
	}

	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}

}