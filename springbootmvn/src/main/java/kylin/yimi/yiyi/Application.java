package kylin.yimi.yiyi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import kylin.yimi.yiyi.config.Myconfig;
@Configuration
@EnableAutoConfiguration
@Import(Myconfig.class)
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
