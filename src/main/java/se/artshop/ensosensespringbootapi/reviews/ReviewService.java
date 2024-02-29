package se.artshop.ensosensespringbootapi.reviews;


import java.sql.Date;
import java.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import se.artshop.ensosensespringbootapi.requestmodels.ReviewRequest;

@Service
@Transactional
public class ReviewService {

  private ReviewRepository reviewRepository;

  @Autowired
  public ReviewService(ReviewRepository reviewRepository) {
    this.reviewRepository = reviewRepository;
  }

  public void postReview(String userEmail, ReviewRequest reviewRequest) throws Exception {
    Review validateReview =
        reviewRepository.findByUserEmailAndArtworkId(userEmail, reviewRequest.getArtworkId());
    if (validateReview != null) {
      throw new Exception("Review already created");
    }
    Review review = new Review();
    review.setArtworkId(reviewRequest.getArtworkId());
    review.setRating(reviewRequest.getRating());
    review.setUserEmail(userEmail);

    if (reviewRequest.getReviewDescription().isPresent()) {
      review.setReviewDescription(reviewRequest.getReviewDescription().map(
          Object::toString).orElse(null));
    }
    review.setDate(Date.valueOf(LocalDate.now()));
    reviewRepository.save(review);
  }

  public boolean userReviewListed(String userEmail, Long artworkId) {
    Review validateReview = reviewRepository.findByUserEmailAndArtworkId(userEmail, artworkId);

    if (validateReview != null) {
      return true;
    } else {
      return false;
    }
  }
}
