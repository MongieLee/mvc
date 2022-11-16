package cn.mgl.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

/**
 * @author MongieLee
 * @version 1.0
 * @date 2022/10/28 10:53
 */
@PropertySource("classpath:jdbc.properties")
public class JDBCConfig {
    @Value("${jdbc.username}")
    private String username;

    @Value("${jdbc.url}")
    private String url;

    @Value("${jdbc.password}")
    private String password;

    @Value("${jdbc.driverClassName}")
    private String driverClassName;

    /**
     * 配置数据源
     *
     * @return
     */
    @Bean
    public DataSource dataSource() {
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setPassword(password);
        druidDataSource.setUsername(username);
        druidDataSource.setUrl(url);
        druidDataSource.setDriverClassName(driverClassName);
        return druidDataSource;
    }

    /**
     * 配置事务
     *
     * @param dataSource
     * @return
     */
    @Bean
    public PlatformTransactionManager platformTransactionManager(@Autowired DataSource dataSource) {
        DataSourceTransactionManager dataSourceTransactionManager = new DataSourceTransactionManager();
        dataSourceTransactionManager.setDataSource(dataSource);
        return dataSourceTransactionManager;
    }
}
