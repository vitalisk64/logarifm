package hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class Application {

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

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}