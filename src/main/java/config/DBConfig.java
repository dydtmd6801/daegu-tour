package config;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DBConfig {

    public DataSource dataSource() {
        DataSource ds = new DataSource();
        ds.setDriverClassName("com.mysql.jdbc.Driver");
        ds.setUrl("jdbc:mysql://localhost/news?allowPublicKeyRetrieval=true&useSSL=false&characterEncoding=utf8");
        ds.setUsername("news");
        ds.setPassword("news");
        ds.setInitialSize(2);
        ds.setMaxActive(100);
        ds.setTestWhileIdle(true);
        ds.setMinEvictableIdleTimeMillis(60000 * 3);
        ds.setTimeBetweenEvictionRunsMillis(10 * 1000);
        return ds;
    }
}
