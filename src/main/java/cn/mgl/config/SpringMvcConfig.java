package cn.mgl.config;

import cn.mgl.interceptor.LoginInterceptor;
import jdk.nashorn.internal.scripts.JD;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.*;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.*;

import java.nio.charset.StandardCharsets;
import java.util.List;

/**
 * 1. Configuration 相当于定义类SpringMvcConfig.xml配置文件
 * 2。 需要将Controller进行注册，添加@ComponentScan进行扫包
 * 3。 再SpringMvc原理中，所有请求过来会先达到DispatchServlet 分发具体控制类方法执行
 */
@Configuration
@ComponentScan("cn.mgl.controller")
@Import(LoginInterceptor.class)
public class SpringMvcConfig extends WebMvcConfigurationSupport {
    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        addDefaultHttpMessageConverters(converters);
        StringHttpMessageConverter httpMessageConverter = (StringHttpMessageConverter) converters.get(1);
        httpMessageConverter.setDefaultCharset(StandardCharsets.UTF_8);
    }


    private LoginInterceptor loginInterceptor;


    public SpringMvcConfig(LoginInterceptor loginInterceptor) {
        this.loginInterceptor = loginInterceptor;
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowedMethods("GET", "POST", "PUT", "PATCH", "DELETE", "OPTION")
                .maxAge(3600);
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loginInterceptor);
    }
}
