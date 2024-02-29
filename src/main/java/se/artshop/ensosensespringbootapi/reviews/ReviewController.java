package se.artshop.ensosensespringbootapi.reviews;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import se.artshop.ensosensespringbootapi.requestmodels.ReviewRequest;
import se.artshop.ensosensespringbootapi.utils.ExtractJWT;

@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("/api/reviews")
public class ReviewController {

  private ReviewService reviewService;

  public ReviewController(ReviewService reviewService) {
    this.reviewService = reviewService;
  }

  @GetMapping("/secure/user/artwork")
  public Boolean reviewArtworkByUser(@RequestHeader(value = "Authorization") String token,
                                     @RequestParam Long artworkId) throws Exception {
    String userEmail = ExtractJWT.payLoadJWTExtraction(token, "\"sub\"");

    if (userEmail == null) {
      throw new Exception("User email is missing");
    }
    return reviewService.userReviewListed(userEmail, artworkId);
  }

  @PostMapping("/secure")
  public void postReview(@RequestHeader(value = "Authorization") String token,
                         @RequestBody ReviewRequest reviewRequest) throws Exception {
    String userEmail = ExtractJWT.payLoadJWTExtraction(token, "\"sub\"");

    if (userEmail == null) {
      throw new Exception("User email is missing");
    }
    reviewService.postReview(userEmail, reviewRequest);
  }
}
