package org.jugvale.crud.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Encontro {
    
    @Id
    @GeneratedValue
    private long id;

    private String titulo;
    
    public Encontro() {
    }

    public Encontro(String titulo) {
        this.titulo = titulo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Encontro [id=" + id + ", titulo=" + titulo + "]";
    }
    
}