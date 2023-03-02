package com.coding404.myweb.WebConfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.coding404.myweb.util.intercepter.MenuHandler;
import com.coding404.myweb.util.intercepter.UserAuthHandler;


@Configuration //스프링설정파일
public class WebConfig implements WebMvcConfigurer{
	
	//프리핸들러
	@Bean
	public UserAuthHandler userAuthHandler() {
		return new UserAuthHandler();
	}
	
	//포스트핸들러
	@Bean
	public MenuHandler menuHandler() {
		return new MenuHandler();
	}

	//인터셉터추가
	@Override
	public void addInterceptors(InterceptorRegistry registry) {

//		registry.addInterceptor(userAuthHandler())
//				.addPathPatterns("/main")
//		 		.addPathPatterns("/product/*")
//		 		.addPathPatterns("/user/*")
//		 		.excludePathPatterns("/user/login")
//		 		.excludePathPatterns("/user/join");
		
		
//		registry.addInterceptor(userAuthHandler())
//				.addPathPatterns("/**")
//				.excludePathPatterns("/user/login")
//				.excludePathPatterns("/user/join")
//				.excludePathPatterns("/js/*")
//				.excludePathPatterns("/css/*")
//				.excludePathPatterns("/img/*");
//				//REST API 패스에서 제외..
		
		registry.addInterceptor(menuHandler())
				.addPathPatterns("/main")
				.addPathPatterns("/product/*")
				.addPathPatterns("/user/*");
		
		
	}
	
	
	
	

}
