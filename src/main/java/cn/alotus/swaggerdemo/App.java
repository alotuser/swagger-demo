package cn.alotus.swaggerdemo;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cn.alotus.core.collection.ListUtil;
import cn.alotus.swaggerdemo.entity.SysUser;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;



@Api(tags = {"app"})
@SpringBootApplication
@RestController
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
        System.out.println("Swagger Demo Application is running!"+"http://127.0.0.1:8080/swagger-ui/");
    }

    @ApiOperation(value = "#{api.hello.value} ", notes = "#{api.hello.notes}")
	@GetMapping(value = "/")
    String hello() {
        return "Hello World!";
    }
    
    
    @ApiOperation(value = "#{api.getSysUser.value}获取系统用户列表", notes = "#{api.getSysUser.notes}")
	@PostMapping(value = "/getSysUser")
	List<SysUser> getSysUser(
			@ApiParam(value = "#{api.current}		当前页"		, example = "1"  ) @RequestParam Long current, 
			@ApiParam(value = "#{api.size}			每页显示条数"	, example = "10" ) @RequestParam Long size, 
			@ApiParam(value = "#{api.sysUser.name}	姓名"		, example = "张三") @RequestParam(required = false) String name, 
			@ApiParam(value = "#{api.sysUser.age}	年龄"		, example = "11" ) @RequestParam(required = false) Integer age

	) {
		
     
    	List<SysUser> res = ListUtil.of(
    			new SysUser(1L, "张三", 1, "1@alotu.com"),
                new SysUser(2L, "李四", 2, "2@alotu.com"),
                new SysUser(3L, "王五", 3, "3@alotu.com") );
		

		return res;
	}
    
    
    @ApiOperation(value = "#{api.addSysUser.value}	新增系统用户信息", notes = "#{api.addSysUser.notes}")
	@PostMapping(value = "/addSysUser")
	List<SysUser> addSysUser(@RequestBody List<SysUser> users) {

		//TODO: 这里可以添加业务逻辑处理，比如保存到数据库等

		return users;
	}
    
    
}