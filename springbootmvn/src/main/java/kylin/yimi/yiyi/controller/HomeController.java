package kylin.yimi.yiyi.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(path="home/",method={RequestMethod.GET})
public class HomeController {
	@RequestMapping("h1") @ResponseBody String h1(){
		return "home1";
	}
	@RequestMapping("h2") @ResponseBody String h2(){
		return "home2";
	}
	
}
