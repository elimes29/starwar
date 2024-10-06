package com.aluraone.elimes.modelos;

import java.lang.reflect.Array;
import java.util.List;

public record PeliculaOmdb(String title, String episodeId, String opening_crawl, String director, String producer, String release_date, List<String> characters, List<String> planets, List<String> starships, List<String> vehicles, List<String> species) {
}
