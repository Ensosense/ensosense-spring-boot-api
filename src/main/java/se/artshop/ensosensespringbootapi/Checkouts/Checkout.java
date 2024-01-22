package se.artshop.ensosensespringbootapi.Checkouts;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "checkout")
@Data
public class Checkout {

  public  Checkout(){}

  public Checkout(String userEmail, String checkoutDate, Long artworkId){
    this.userEmail = userEmail;
    this.checkoutDate = checkoutDate;
    this.artworkId = artworkId;
  }
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;


  @Column(name = "user_email")
  private String userEmail;


  @Column(name = "checkout_date")
  private String checkoutDate;

  @Column(name = "artwork_id")
  private Long artworkId;
}
