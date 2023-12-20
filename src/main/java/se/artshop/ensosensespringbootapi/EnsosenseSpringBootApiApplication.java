package se.artshop.ensosensespringbootapi;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.annotation.PostConstruct;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EnsosenseSpringBootApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(EnsosenseSpringBootApiApplication.class, args);
	}

	@PostConstruct
	public void initialize() {

		FileInputStream serviceAccount =
				null;
		try {
			serviceAccount = new FileInputStream("serviceAccountKey.json");
		} catch (FileNotFoundException e) {
			throw new RuntimeException(e);
		}

		FirebaseOptions options = null;
		try {
			options = new FirebaseOptions.Builder()
					.setCredentials(GoogleCredentials.fromStream(serviceAccount))
					.build();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}

		FirebaseApp.initializeApp(options);

	}

}
