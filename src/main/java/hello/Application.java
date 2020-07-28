package hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;

@SpringBootApplication
@RestController
public class Application {

	Timestamp timestamp;

	@RequestMapping("/")
	public String home() {
		return "Hello Docker World";
	}

	@RequestMapping("/log")
	public String log() {
		return "Please use POST method with argument";
	}

	@PostMapping("/log")
	public Response calculate(@RequestBody Data data) {
		if (data.argument != null) {
			return new Response(Math.log(data.argument));
		}
		return new Response("aa");
	}

	@RequestMapping("/health")
	public String health() throws Exception {
		if (timestamp == null) {
			timestamp = new Timestamp(System.currentTimeMillis());
			throw new Exception("Initialisation...");
		}
		if (timestamp != null) {
			Timestamp currentTimestamp = new Timestamp(System.currentTimeMillis());
			if (currentTimestamp.after(timestamp)) {
				throw new Exception("Initialisation...");
			}
		}
		return "Ok";
	}


	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}