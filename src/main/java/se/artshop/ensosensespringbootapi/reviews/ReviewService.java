package se.artshop.ensosensespringbootapi.reviews;


import java.sql.Date;
import java.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import se.artshop.ensosensespringbootapi.artworks.ArtworkRepository;
import se.artshop.ensosensespringbootapi.requestmodels.ReviewRequest;

@Service
@Transactional
public class ReviewService {

  private ReviewRepository reviewRepository;
  private ArtworkRepository artworkRepository;

  @Autowired
  public ReviewService(ReviewRepository reviewRepository, ArtworkRepository artworkRepository) {
    this.reviewRepository = reviewRepository;
    this.artworkRepository = artworkRepository;
  }

  public void postReview(String userEmail, ReviewRequest reviewRequest) throws Exception {
    Review validateReview =
        reviewRepository.findByUserEmailAndArtworkId(userEmail, reviewRequest.getArtworkId());
    if (validateReview != null) {
      throw new Exception("Review already created");
    }
    Review review = new Review();
    review.setArtworkId(reviewRequest.getArtworkId());
    review.setRating(review.getRating());
    review.setUserEmail(userEmail);

    if (reviewRequest.getReviewDescription().isPresent()) {
      review.setReviewDescription(reviewRequest.getReviewDescription().map(
          Object::toString).orElse(null));
    }
    review.setDate(Date.valueOf(LocalDate.now()));
    reviewRepository.save(review);
  }
}
