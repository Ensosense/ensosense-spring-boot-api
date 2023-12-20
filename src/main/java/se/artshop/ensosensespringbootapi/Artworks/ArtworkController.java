package se.artshop.ensosensespringbootapi.Artworks;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/artworks")
public class ArtworkController {

  @Autowired
  public Firestore firestore;
  @Autowired
  private ArtworkService artworkService;


  @GetMapping
  public Flux<Artwork> getArtworks(
      @RequestParam(defaultValue = "0") int page,
      @RequestParam(defaultValue = "500") int size) {
    return artworkService.findAllArtworks(PageRequest.of(page, size));
  }


  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public Mono<Artwork> createArtwork(@RequestBody Artwork artwork) {
    return artworkService.createArtwork(artwork);
  }
}
