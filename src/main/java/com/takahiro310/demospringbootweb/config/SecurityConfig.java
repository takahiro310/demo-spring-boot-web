package com.takahiro310.demospringbootweb.config;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	/**
	 * セキュリティ設定を無視するリクエスト設定
	 */
	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers(
			"/img/**",
			"/css/**",
			"/js/**"
		);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		/**
		 * [sample]
		 * https://qiita.com/t-iguchi/items/9d12ab0b260e286ba18c
		 */
		http.csrf().ignoringAntMatchers("/simple-rest04");
	}

}