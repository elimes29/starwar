package com.aluraone.elimes.modelos;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Pelicula {
    private String titulo;
    private int episodioNumero;
    private String mensajeInicial;
    private String director;
    private String productor;
    private Date fechaLanzamiento;
    private List<String> personajes;
    private List<String> planetas;
    private List<String> naves;
    private List<String> vehiculos;
    private List<String> especies;

    public Pelicula(PeliculaOmdb peliculaOmdb) throws ParseException {
        this.titulo = peliculaOmdb.title();
        this.episodioNumero = Integer.parseInt(peliculaOmdb.episodeId());
        this.mensajeInicial = peliculaOmdb.opening_crawl();
        this.director = peliculaOmdb.director();
        this.productor = peliculaOmdb.producer();
        this.fechaLanzamiento = formato.parse(String.valueOf(peliculaOmdb.release_date()));
        this.personajes = peliculaOmdb.characters();
        this.planetas = peliculaOmdb.planets();
        this.naves = peliculaOmdb.starships();
        this.vehiculos = peliculaOmdb.vehicles();
        this.especies = peliculaOmdb.species();
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getEpisodioNumero() {
        return episodioNumero;
    }

    public void setEpisodioNumero(int episodioNumero) {
        this.episodioNumero = episodioNumero;
    }

    public String getMensajeInicial() {
        return mensajeInicial;
    }

    public void setMensajeInicial(String mensajeInicial) {
        this.mensajeInicial = mensajeInicial;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getProductor() {
        return productor;
    }

    public void setProductor(String productor) {
        this.productor = productor;
    }

    public Date getFechaLanzamiento() {
        return fechaLanzamiento;
    }

    public void setFechaLanzamiento(Date fechaLanzamiento) {
        this.fechaLanzamiento = fechaLanzamiento;
    }

    public List<String> getPersonajes() {
        return personajes;
    }

    public void setPersonajes(List<String> personajes) {
        this.personajes = personajes;
    }

    public List<String> getPlanetas() {
        return planetas;
    }

    public void setPlanetas(List<String> planetas) {
        this.planetas = planetas;
    }

    public List<String> getNaves() {
        return naves;
    }

    public void setNaves(List<String> naves) {
        this.naves = naves;
    }

    public List<String> getVehiculos() {
        return vehiculos;
    }

    public void setVehiculos(List<String> vehiculos) {
        this.vehiculos = vehiculos;
    }

    public List<String> getEspecies() {
        return especies;
    }

    public void setEspecies(List<String> especies) {
        this.especies = especies;
    }

    @Override
    public String toString() {
        return "Pelicula{" +
                "titulo='" + titulo + '\'' +
                ", episodioNumero=" + episodioNumero +
                ", mensajeInicial='" + mensajeInicial + '\'' +
                ", director='" + director + '\'' +
                ", productor='" + productor + '\'' +
                ", fechaLanzamiento=" + fechaLanzamiento +
                '}';
    }


}
