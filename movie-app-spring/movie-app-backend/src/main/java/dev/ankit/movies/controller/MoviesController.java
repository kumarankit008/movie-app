package dev.ankit.movies.controller;

import dev.ankit.movies.dto.Movie;
import dev.ankit.movies.dto.Review;
import dev.ankit.movies.service.MovieService;
import dev.ankit.movies.service.ReviewService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/movies")
@CrossOrigin(origins = "http://localhost:3000")
public class MoviesController {
    @Autowired
    private MovieService movieService;
    @Autowired
    private ReviewService reviewService;
    @GetMapping
    public ResponseEntity<List<Movie>> allMovies(){
        return new ResponseEntity<List<Movie>>(movieService.getAllMovies(),HttpStatus.OK);
    }
    @GetMapping("/{imdbid}")
    public  ResponseEntity<Optional<Movie>> getMovieById(@PathVariable String imdbid){
        return new ResponseEntity<Optional<Movie>>(movieService.getMovieById(imdbid),HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<Review> createReview(@RequestBody Map<String,String> payload){
        return new ResponseEntity<Review>(reviewService.createReview(payload.get("reviewBody"),payload.get("imdbId") ),HttpStatus.CREATED);
    }

}
