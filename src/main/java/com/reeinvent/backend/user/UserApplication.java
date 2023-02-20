package com.reeinvent.backend.user;

import com.reeinvent.backend.BaseApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class UserApplication extends BaseApplication {

	public static void main(String[] args) {
		new SpringApplicationBuilder(UserApplication.class)
				.web(WebApplicationType.NONE)
				.build()
				.run(args);
	}

	@Bean
	public BCryptPasswordEncoder encoder(){
		return new BCryptPasswordEncoder();
	}
}
