package cn.alotus.swaggerdemo.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 *  系统用户实体类
 * 
 * @author Lotus
 * @date 2023年10月17日
 */
@ApiModel(value = "SysUser", description = "#{api.sysUser} 系统用户实体类")
public class SysUser {
	
	@ApiModelProperty("#{api.sysUser.id}    主键")
	private Long id;
	@ApiModelProperty("#{api.sysUser.name}  姓名")
    private String name;
	@ApiModelProperty("#{api.sysUser.age}   年龄")
    private Integer age;
	@ApiModelProperty("#{api.sysUser.email} 邮箱")
    private String email;
    
	
	
	public SysUser() {
		super();
	}

	public SysUser(Long id, String name, Integer age, String email) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.email = email;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
    
    
    
    
}
