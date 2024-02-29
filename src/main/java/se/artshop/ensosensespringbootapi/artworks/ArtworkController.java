package se.artshop.ensosensespringbootapi.artworks;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import se.artshop.ensosensespringbootapi.utils.ExtractJWT;


@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("/api/artworks")
public class ArtworkController {

  private ArtworkService artworkService;

  public ArtworkController(ArtworkService artworkService) {
    this.artworkService = artworkService;
  }

  @PutMapping("/secure/checkout")
  public Artwork checkoutArtwork(@RequestHeader(value = "Authorization") String token,
      @RequestParam Long artworkId) throws Exception {
    String userEmail = ExtractJWT.payLoadExtraction(token, "\"sub\"");

    return artworkService.checkoutArtwork(userEmail, artworkId);
  }

}
