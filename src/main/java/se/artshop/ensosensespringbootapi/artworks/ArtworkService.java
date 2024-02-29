package se.artshop.ensosensespringbootapi.artworks;

import java.time.LocalDate;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;
import se.artshop.ensosensespringbootapi.checkouts.Checkout;
import se.artshop.ensosensespringbootapi.checkouts.CheckoutRepository;

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
  //  Checkout validateCheckout = checkoutRepository.findByUserEmailAndArtworkId(userEmail, artworkId);

    if(!artwork.isPresent() || artwork.get().getCopiesAvailable() <= 0){
      throw new Exception("Artwork doesn't exist");
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
