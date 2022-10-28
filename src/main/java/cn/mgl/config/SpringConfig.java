package cn.mgl.config;

import cn.mgl.interceptor.LoginInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author MongieLee
 * @version 1.0
 * @date 2022/10/28 11:24
 */
@Configuration
@MapperScan("cn.mgl.dao")
@ComponentScan("cn.mgl.service")
@Import({JDBCConfig.class, MybatisConfig.class})
@EnableTransactionManagement
public class SpringConfig {
}
