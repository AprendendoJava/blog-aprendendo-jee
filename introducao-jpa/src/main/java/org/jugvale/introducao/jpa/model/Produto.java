package org.jugvale.introducao.jpa.model;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement
public class Produto{
	
	@Id
	@GeneratedValue
	private long id;
	private String nome;
	private float preco;

	public void setId(long id){ this.id = id;}
	public void setNome(String nome){this.nome = nome;}
	public void setPreco(float preco){this.preco = preco;}

	public long getId(){return this.id;}
	public String getNome(){return this.nome;}
	public float getPreco() {return this.preco;}
}
