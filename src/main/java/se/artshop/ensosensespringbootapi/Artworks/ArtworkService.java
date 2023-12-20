package se.artshop.ensosensespringbootapi.Artworks;


import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public interface ArtworkService {
  Mono<Artwork> createArtwork(Artwork artwork);

  Flux<Artwork> findAllArtworks(Pageable pageable);
}
