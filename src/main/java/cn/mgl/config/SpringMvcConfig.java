package cn.mgl.config;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("cn.mgl.controller")
public class SpringMvcConfig {
    /**
     * 1. Configuration 相当于定义类SpringMvcConfig.xml配置文件
     * 2。 需要将Controller进行注册，添加@ComponentScan进行扫包
     * 3。 再SpringMvc原理中，所有请求过来会先达到DispatchServlet 分发具体控制类方法执行
     */

}
