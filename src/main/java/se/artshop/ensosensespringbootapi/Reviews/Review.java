package se.artshop.ensosensespringbootapi.Reviews;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "review")
@Data
public class Review {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;

  @Column(name = "user_email")
  private String userEmail;

  @Column(name = "date")
  @CreationTimestamp
  private Date date;

  @Column(name = "rating")
  private double rating;

  @Column(name = "artwork_id")
  private Long artworkId;

  @Column(name = "review_description")
  private String reviewDescription;
}
