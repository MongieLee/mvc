package cn.mgl.config;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;


/**
 * @author MongieLee
 * @version 1.0
 * @date 2022/10/28 11:14
 */
public class MybatisConfig {
    @Bean
    @Autowired
    public SqlSessionFactoryBean sqlSessionFactoryBean(DataSource dataSource, ApplicationContext context) {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        sqlSessionFactoryBean.setConfigLocation(context.getResource("classpath:mybatis-config.xml"));
        return sqlSessionFactoryBean;
    }
}
