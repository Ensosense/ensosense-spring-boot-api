package se.artshop.ensosensespringbootapi.Artworks;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
import com.google.cloud.firestore.WriteResult;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ArtworkServiceImpl implements ArtworkService {

  @Autowired
  private ArtworkRepository artworkRepository;

  @Autowired
  private Firestore firestore;

  @Override
  public Mono<Artwork> createArtwork(Artwork artwork) {
    return artworkRepository.save(artwork);
  }

  @Override
  public Flux<Artwork> findAllArtworks(Pageable pageable) {
    return artworkRepository.findBy(pageable);
  }
}
