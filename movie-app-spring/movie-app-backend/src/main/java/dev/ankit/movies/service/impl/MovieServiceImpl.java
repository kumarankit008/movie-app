package dev.ankit.movies.service.impl;

import dev.ankit.movies.dto.Movie;
import dev.ankit.movies.repository.MovieRepository;
import dev.ankit.movies.service.MovieService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieServiceImpl implements MovieService {
    @Autowired
    private MovieRepository movieRepository;
    @Override
    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }
    @Override
    public Optional<Movie> getMovieById(String imdbid){
        return movieRepository.findMovieByImdbId(imdbid);
    }
}
