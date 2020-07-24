package com.plurasight.review;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class ReviewServiceTest {

    @Autowired
    private ReviewService service;

    @MockBean
    private ReviewRepository repository;

    @Test
    @DisplayName("Test findById Success")
    void testFindByIdSuccess() {
        Review mockReview = new Review("reviewId", 1, 1);
        Date now = new Date();
        mockReview.getEntries().add(new ReviewEntry("test-user", now, "Great product"));
        doReturn(Optional.of(mockReview)).when(repository).findById("reviewId");

        Optional<Review> returnedReview = service.findById("reviewId");

        Assertions.assertTrue(returnedReview.isPresent(), "Review was not found");
        Assertions.assertSame(returnedReview.get(), mockReview, "Review should be the same");
    }

    @Test
    @DisplayName("Test findById Not Found")
    void testFindByIdNotFound() {
        doReturn(Optional.empty()).when(repository).findById("1");

        Optional<Review> returnedReview = service.findById("1");
        Assertions.assertFalse(returnedReview.isPresent(), "Review was found, when it shouldn't be");
    }

    @Test
    @DisplayName("Test findAll")
    void testFindAll() {
        Review mockReview = new Review("reviewId", 1, 1);
        Review mockReview2 = new Review("reviewId2", 2, 1);
        doReturn(Arrays.asList(mockReview, mockReview2)).when(repository).findAll();

        List<Review> reviews = service.findAll();
        Assertions.assertEquals(2, reviews.size(), "findAll should return 2 reviews");
    }

    @Test
    @DisplayName("Test save")
    void testSave() {
        Review mockReview = new Review("reviewId", 1, 1);
        doReturn(mockReview).when(repository).save(any());

        Review returnedReview = service.save(mockReview);
        Assertions.assertNotNull(returnedReview, "The saved review should not be null");
        Assertions.assertEquals(1,
                returnedReview.getVersion().intValue(),
                "The version for a new review should be 1");
    }


}
