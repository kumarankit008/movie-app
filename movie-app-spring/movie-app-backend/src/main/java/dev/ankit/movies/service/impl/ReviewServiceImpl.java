package dev.ankit.movies.service.impl;

import dev.ankit.movies.dto.Movie;
import dev.ankit.movies.dto.Review;
import dev.ankit.movies.repository.ReviewRepository;
import dev.ankit.movies.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

@Service
public class ReviewServiceImpl implements ReviewService {
    @Autowired
    private ReviewRepository reviewRepository;
    @Autowired
    private MongoTemplate mongoTemplate;
    @Override
    public Review createReview(String reviewBody, String imdbId) {
        Review review= reviewRepository.insert( new Review(reviewBody));

        mongoTemplate.update(Movie.class)
                .matching(Criteria.where("imdbId").is(imdbId))
                .apply(new Update().push("reviewIds").value(review))
                .first();
        return review;
    }
}
