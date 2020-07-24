package com.plurasight.review;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

@DataMongoTest
public class ReviewRepositoryTest {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Autowired
    private ReviewRepository repository;

    private ObjectMapper mapper = new ObjectMapper();

    private static File SAMPLE_JSON = Paths.get("src", "test", "resources", "data", "sample.json").toFile();

    @BeforeEach
    void beforeEach() throws IOException {
        Review[] reviews = mapper.readValue(SAMPLE_JSON, Review[].class);
        //Load each review into MongoDB
        Arrays.stream(reviews).forEach(mongoTemplate::save);
    }

    @AfterEach
    void afterEach(){
        mongoTemplate.dropCollection("Reviews");
    }

    @Test
    void testFindAll(){
        List<Review> reviews = repository.findAll();
        Assertions.assertEquals(2, reviews.size(), "Should be two reviews in the database");
    }

}
