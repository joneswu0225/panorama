package com.jones.panorama;

//import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@MapperScan("com.jones.panorama.mapper")
public class PanoramaApplication {

	public static void main(String[] args) {
		SpringApplication.run(PanoramaApplication.class, args);
	}
//	@Configuration
//	public class TemplateLoader extends WebMvcConfigurerAdapter {
//		@Bean
//		public ViewResolver viewResolver() {
//			FreeMarkerViewResolver resolver = new FreeMarkerViewResolver();
//			resolver.setCache(true);
//			resolver.setPrefix("");
//			resolver.setSuffix(".ftl");
//			resolver.setContentType("text/html; charset=UTF-8");
//			return resolver;
//		}
//		@Bean
//		public FreeMarkerConfigurer freemarkerConfig() throws IOException, TemplateException {
//			FreeMarkerConfigurer configurer = new FreeMarkerConfigurer();
//			configurer.setTemplateLoaderPaths("file:绝对路径","http://www.xxx.com/");
//			configurer.setDefaultEncoding("UTF-8");
//			return configurer;
//		}
//	}
//	@Bean
//	public PageHelper pageHelper(){
//		PageHelper pageHelper = new PageHelper();
//		Properties properties = new Properties();
//		properties.setProperty("offsetAsPageNum","true");
//		properties.setProperty("rowBoundsWithCount","true");
//		properties.setProperty("reasonable","true");
//		properties.setProperty("dialect","mysql");    //配置mysql数据库的方言
//		pageHelper.setProperties(properties);
//		return pageHelper;
//	}
}
