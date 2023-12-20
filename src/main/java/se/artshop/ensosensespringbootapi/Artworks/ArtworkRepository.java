package se.artshop.ensosensespringbootapi.Artworks;

import com.google.cloud.spring.data.firestore.FirestoreReactiveRepository;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface ArtworkRepository extends FirestoreReactiveRepository<Artwork> {
  Flux<Artwork> findBy(Pageable pageable);
}
