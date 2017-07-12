package com.config.secure;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * Created by weber on 2017/7/12.
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    UserServiceDetails userServiceDetails;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.
                authorizeRequests()                                 //对Request请求进行验证
                .antMatchers("/index","/register").permitAll()   //不需要通过验证就能访问的url
                .anyRequest().authenticated()                       //其他的请求就需要经过验证才能访问
                .and()
                .formLogin()                                        //启用默认的登录页
//                 .loginPage("/login")                              //自定义登录页
                .failureHandler(new AjaxLoginFailureHandler())      //登录失败后的处理
                .successHandler(new AjaxLoginSuccessHandler())      //登录成功后的处理
                .and().logout().logoutUrl("/logout").logoutSuccessUrl("/login")  //登出的url和登出成功的url
                .and().rememberMe()
                .tokenValiditySeconds(2419200)                       //记住密码，可以设置alwaysRemeberMe（true）或者设置时间
                .key("webKey")
                .and()
                .httpBasic();
        http.csrf().disable();
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/WEB/static/**");  //忽略对静态资源的访问验证
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser("qw").password("qw").roles("USER");

        //auth.userDetailsService(userServiceDetails).passwordEncoder(new StandardPasswordEncoder());
    }
}
