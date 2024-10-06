package com.aluraone.elimes.principal;
import com.aluraone.elimes.modelos.Pelicula;
import com.aluraone.elimes.modelos.PeliculaOmdb;
import com.aluraone.elimes.utilidades.ConsultaPelicula;
import com.aluraone.elimes.utilidades.GeneraArchivo;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class Principal {
    public static void main(String[] args) {

        List<Pelicula> peliculas = new ArrayList<>();
        ConsultaPelicula consultaPelicula = new ConsultaPelicula();
        GeneraArchivo generaArchivo = new GeneraArchivo();
        try {
            //Haciendo un for para ir de la película  a la 6

            for (int i = 0; i < 6; i++) {

                //hacemos la búsqueda de la película de la web mediante una clase de utilidad
                PeliculaOmdb peliculaOmdb = consultaPelicula.buscarPelicla(i+1);

                //Convirtiendo mi claseOMDB a clase normal
                Pelicula pelicula = new Pelicula(peliculaOmdb);
                peliculas.add(pelicula);
            }

            //Creando archivo .Json
            generaArchivo.guardaPelicula(peliculas);

        }catch (RuntimeException | IOException e){
            System.out.println(e.getMessage());

        } catch (ParseException e) {
            throw new RuntimeException("No puede realizar la conversion "+ e.getMessage());
        }


    }
}
