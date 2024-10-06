package com.aluraone.elimes.principal;
import com.aluraone.elimes.modelos.Pelicula;
import com.aluraone.elimes.modelos.PeliculaOmdb;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

public class Principal {
    public static void main(String[] args) {

        List<Pelicula> peliculas = new ArrayList<>();

        Gson gson =  new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .setPrettyPrinting()
                .create();

        try {
            //Haciendo un for para ir de la película  a la 6

            for (int i = 0; i < 6; i++) {

                //Creando URL
                int peliculaEpisodio = i+1;
                String direccion = "https://swapi.dev/api/films/"+peliculaEpisodio+"/";

                //Usando HTTP Request
                HttpClient client = HttpClient.newHttpClient();
                HttpRequest request = HttpRequest.newBuilder()
                        .uri(URI.create(direccion))
                        .build();
                //Recibiendo respuesta
                HttpResponse<String> response = client
                        .send(request, HttpResponse.BodyHandlers.ofString());

                //Creando una clase PeliculaOmdb donde se pasará el JSON a la claseOMDB
                PeliculaOmdb peliculaOmdb = gson.fromJson(response.body(), PeliculaOmdb.class);

                //Convirtiendo mi claseOMDB a clase normal
                Pelicula pelicula = new Pelicula(peliculaOmdb);
                peliculas.add(pelicula);
            }


            //Creamos un archivo .json
            FileWriter escritura = new FileWriter("StarWar.json");
            //Escribimos en él el arreglo de peliculas que está en el array peliculas
            escritura.write(gson.toJson(peliculas));
            escritura.close();
            System.out.println("Archivo creado exitosamente");

        }catch (Exception e){

            System.out.println("Falló");
            System.out.println(e.getMessage());

        }


    }
}
