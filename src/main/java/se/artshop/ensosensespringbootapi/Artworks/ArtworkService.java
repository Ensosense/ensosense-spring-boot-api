package se.artshop.ensosensespringbootapi.Artworks;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;
import javax.transaction.Transactional;
import org.hibernate.annotations.Check;
import org.springframework.stereotype.Service;
import se.artshop.ensosensespringbootapi.Checkouts.Checkout;
import se.artshop.ensosensespringbootapi.Checkouts.CheckoutRepository;

@Transactional
@Service
public class ArtworkService {

  private ArtworkRepository artworkRepository;

  private CheckoutRepository checkoutRepository;

  //constructor injection
  public ArtworkService(ArtworkRepository artworkRepository,
                        CheckoutRepository checkoutRepository) {
    this.artworkRepository = artworkRepository;
    this.checkoutRepository = checkoutRepository;
  }


  public Artwork checkoutArtwork(String userEmail, Long artworkId) throws Exception{

    Optional<Artwork> artwork = artworkRepository.findById(artworkId);
    Checkout validateCheckout = checkoutRepository.findByUserEmailAndArtworkId(userEmail, artworkId);

    if(!artwork.isPresent() || validateCheckout != null || artwork.get().getCopiesAvailable() <= 0){
      throw new Exception("Artwork doesn't exist or checked out by user");
    }

    artwork.get().setCopiesAvailable(artwork.get().getCopiesAvailable() - 1);

    artworkRepository.save(artwork.get());

    Checkout checkout = new Checkout(
        userEmail,
        LocalDate.now().toString(),
        artwork.get().getId()
    );

    checkoutRepository.save(checkout);

    return artwork.get();
  }

}
