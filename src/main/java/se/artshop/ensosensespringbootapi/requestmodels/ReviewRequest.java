package se.artshop.ensosensespringbootapi.requestmodels;

import java.util.Optional;
import lombok.Data;

@Data
public class ReviewRequest {

  private double rating;

  private long artworkId;

  private Optional<String> reviewDescription;

}
