package se.artshop.ensosensespringbootapi.Artworks;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RequestParam;


public interface ArtworkRepository extends JpaRepository<Artwork, Long> {

  Page<Artwork> findByTitleContaining(@RequestParam ("title") String title, Pageable pageable);

  Page<Artwork> findByCategory (@RequestParam ("category") String category, Pageable pageable);

}
