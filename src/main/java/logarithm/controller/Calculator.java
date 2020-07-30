package logarithm.controller;

import logarithm.model.Data;
import logarithm.model.Response;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    Counter counter;

    @RequestMapping("/log")
    public String log() {
        return "Please use POST method with JSON argument value";
    }

    @PostMapping(value = "/log", consumes = "application/json", produces = "application/json")
    public Response calculate(@RequestBody Data data) {
        if (data.argument != null && data.base != null) {
            if (data.base >= 10) {
                counter.setCount(counter.getCount()+1);
            }
            return new Response(Math.log(data.argument)/Math.log(data.base));
        }
        return new Response("Something wrong with data");
    }
}
