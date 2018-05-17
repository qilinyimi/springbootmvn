package kylin.yimi.yiyi.groovy

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@SpringBootApplication
class App {
	@RequestMapping("/home")
	String home() {
		return "hello world groovy";
	}
	public static void main(String [] args) {
		SpringApplication.run(App.class, args);
	}
}
