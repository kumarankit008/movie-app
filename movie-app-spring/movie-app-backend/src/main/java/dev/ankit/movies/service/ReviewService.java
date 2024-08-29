package dev.ankit.movies.service;

import dev.ankit.movies.dto.Review;

public interface ReviewService {
    Review createReview(String reviewBody, String imdbId);
}
