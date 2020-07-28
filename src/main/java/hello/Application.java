package hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sun.security.provider.certpath.OCSPResponse;

import java.sql.Timestamp;

@SpringBootApplication
@RestController
public class Application {

	Long timestamp = null;

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
			timestamp = System.currentTimeMillis();
			throw new Exception("Error");

		}
		if (timestamp != null) {
			Long currentTimestamp = System.currentTimeMillis();
			if (currentTimestamp < timestamp + 60*1000) {
				throw new Exception("Error");
			}
		}
		return "Ok";
	}


	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}