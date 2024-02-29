package se.artshop.ensosensespringbootapi.checkouts;


import org.springframework.data.jpa.repository.JpaRepository;

public interface CheckoutRepository extends JpaRepository<Checkout, Long> {

  Checkout findByUserEmailAndArtworkId(String userEmail, Long artworkId);
}
