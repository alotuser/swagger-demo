package cn.alotus.swaggerdemo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "#{tag.app}AppController")
@RestController
public class ThrC {

	@ApiOperation(value = "#{api.hello.value} ", notes = "#{api.hello.notes}")
	@GetMapping(value = "/hello")
	String hello() {
		return "Hello World!";
	}

}
