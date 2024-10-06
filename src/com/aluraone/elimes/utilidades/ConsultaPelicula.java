package com.aluraone.elimes.utilidades;

import com.aluraone.elimes.modelos.PeliculaOmdb;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaPelicula {

    Gson gson =  new GsonBuilder()
            .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
            .setPrettyPrinting()
            .create();


    public PeliculaOmdb buscarPelicla(int numeroPelicula)  {
        String direccion = "https://swapi.py4e.com/api/films/"+numeroPelicula+"/";

        //Usando HTTP Request
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(direccion))
                .build();

        try {
            //Recibiendo respuesta
            HttpResponse<String> response = null;
            response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            //Creando una clase PeliculaOmdb donde se pasará el JSON a la claseOMDB
            return gson.fromJson(response.body(), PeliculaOmdb.class);
        } catch (Exception e) {
            throw new RuntimeException("No encontré esta pelicula");
        }


    }
}
