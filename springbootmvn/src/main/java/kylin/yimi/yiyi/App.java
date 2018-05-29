package kylin.yimi.yiyi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Hello world!
 * componentscan 设置spring的扫描包，自动装载bean
 */
//@ComponentScan(basePackages={"kylin.yimi.yiyi.controller","kylin.yimi.yiyi.*.controller"})
@SpringBootApplication
public class App 
{
    public static void main( String[] args )
    {
    	SpringApplication.run(App.class, args);
//        System.out.println( "Hello World!" );
    }
}
