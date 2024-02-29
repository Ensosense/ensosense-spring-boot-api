package se.artshop.ensosensespringbootapi.artworks;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.Data;


@Entity
@Table(name = "artwork")
@Data
public class Artwork {


  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private long id;

  @Column(name = "title")
  private String title;

  @Column(name = "description")
  private String description;

  @Column(name = "category")
  private String category;

  @Column(name = "price")
  private int price;

  @Column(name = "available")
  private int copiesAvailable;

  @Column(name = "img")
  private String img;

}
