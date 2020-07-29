package logarithm.controller;

import logarithm.model.Data;
import logarithm.model.Response;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import logarithm.controller.Readiness;

@SpringBootApplication
@RestController
public class Calculator {

    @RequestMapping("/")
    public String home() {
        return "Hello Docker World";
    }

    @RequestMapping("/log")
    public String log() {
        return "Please use POST method with JSON argument value";
    }

    @PostMapping(value = "/log", consumes = "application/json", produces = "application/json")
    public Response calculate(@RequestBody Data data) {
        if (data.argument != null) {
            return new Response(Math.log(data.argument));
        }
        return new Response("Something wrong with data");
    }
}
