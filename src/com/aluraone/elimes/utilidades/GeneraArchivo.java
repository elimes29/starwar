package com.aluraone.elimes.utilidades;

import com.aluraone.elimes.modelos.Pelicula;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class GeneraArchivo {

    public void guardaPelicula(List<Pelicula> peliculas) throws IOException {

        //Generando gson
        Gson gson =  new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .setPrettyPrinting()
                .create();

        //Creamos un archivo .json
        FileWriter escritura = new FileWriter("StarWar.json");
        //Escribimos en él el arreglo de peliculas que está en el array peliculas
        escritura.write(gson.toJson(peliculas));
        escritura.close();
        System.out.println("Archivo creado exitosamente");
    }
}
