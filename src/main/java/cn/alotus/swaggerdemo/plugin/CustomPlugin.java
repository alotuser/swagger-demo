package cn.alotus.swaggerdemo.plugin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cn.alotuser.core.SwaggerMessagePlugin;
import cn.alotuser.properties.SwaggerProperties;
import cn.hutool.json.JSONUtil;


@Component
public class CustomPlugin implements SwaggerMessagePlugin {

	@Autowired
	private SwaggerProperties  swaggerProperties;
 
	@Override
	public String getMessage(String code) {
		
		//自定义语言
		
		//swaggerProperties.getLocale();
		
		//System.out.println(code);
		
		String msg=null;
		try {
			String json = "{\"api\":{\"hello\":{\"value\":\"自定义的"+swaggerProperties.getLocale().toString()+" App Controller\"}}}";
			
			msg = (String)JSONUtil.getByPath(JSONUtil.parse(json), code);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return msg;
	}

}
