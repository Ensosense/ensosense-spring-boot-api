package se.artshop.ensosensespringbootapi.Artworks;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/artworks")
public class ArtworkController {


  @Autowired
  private ArtworkService artworkService;






}
