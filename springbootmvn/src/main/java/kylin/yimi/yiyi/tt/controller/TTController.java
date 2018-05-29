package kylin.yimi.yiyi.tt.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="home1/",method={RequestMethod.GET})
public class TTController {
	@RequestMapping("h1") @ResponseBody String h1(@RequestParam String name,@RequestParam int age){
		
		return "名字："+name  +"--年龄："+age;
	}
	@RequestMapping("h2") @ResponseBody String h2(){
		return "home2";
	}
	
}
