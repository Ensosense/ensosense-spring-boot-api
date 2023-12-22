package se.artshop.ensosensespringbootapi.Artworks;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



public interface ArtworkRepository extends JpaRepository<Artwork, Long> {

}
