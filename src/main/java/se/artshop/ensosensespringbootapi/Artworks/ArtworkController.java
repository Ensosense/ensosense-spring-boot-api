package se.artshop.ensosensespringbootapi.Artworks;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("/api/artworks")
public class ArtworkController {

  private ArtworkService artworkService;

  public ArtworkController(ArtworkService artworkService) {
    this.artworkService = artworkService;
  }

  @PutMapping("/secure/checkout")
  public Artwork checkoutArtwork(@RequestParam Long artworkId) throws Exception {
    String userEmail = "userEmail@email.com";

    return artworkService.checkoutArtwork(userEmail, artworkId);
  }

}
