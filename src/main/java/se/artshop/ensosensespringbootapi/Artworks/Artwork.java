package se.artshop.ensosensespringbootapi.Artworks;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.google.cloud.firestore.annotation.DocumentId;
import com.google.cloud.spring.data.firestore.Document;
import lombok.Data;



@Document(collectionName = "artworks")
@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class Artwork {

  @DocumentId
  private String id;
  private String title;
  private String description;
  private String category;
  private int price;
  private boolean available;
  private String img;

}
