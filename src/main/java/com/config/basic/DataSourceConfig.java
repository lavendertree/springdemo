package com.config.basic;


import org.apache.commons.dbcp.BasicDataSource;
import org.hibernate.cfg.Environment;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by weber on 2017/7/11.
 */

@Configuration
@EnableAspectJAutoProxy(proxyTargetClass = false, exposeProxy = true)
@PropertySource(value="classpath:application.properties",encoding = "utf-8")
@EnableJpaRepositories(basePackages = {"com.dao"},
        entityManagerFactoryRef = "entityManagerFactory",
        transactionManagerRef = "transactionManager")
public class DataSourceConfig {

    @Value("${spring.datasource.driver-class-nama}")
    private String driver;

    @Value("${spring.datasource.url}")
    private String url;

    @Value("${spring.datasource.username}")
    private String dusername;

    @Value("${spring.datasource.password}")
    private String dpassword;

    @Value(value = "${hibernate.show_sql}")
    private boolean showSql;

    @Value(value = "${hibernate.format_sql}")
    private boolean formatSql;

    @Value(value = "${hibernate.hbm2ddl.auto}")
    private String hbm2ddl;

    @Value(value = "${hibernate.dialect}")
    private String dialect;

    @Bean
    public DataSource dataSource() {
        BasicDataSource ds = new BasicDataSource();
        ds.setDriverClassName(driver);
        ds.setUrl(url);
        ds.setUsername(dusername);
        ds.setPassword(dpassword);
        return ds;
    }


    @Bean(name="entityManagerFactory")
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(){
        LocalContainerEntityManagerFactoryBean factoryBean=new LocalContainerEntityManagerFactoryBean();
        factoryBean.setDataSource(dataSource());
        factoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        factoryBean.setPackagesToScan("com");
        Map<String, Object> jpaPropertyMap = new HashMap<>();
        jpaPropertyMap.put(Environment.DIALECT, dialect);
        jpaPropertyMap.put(Environment.SHOW_SQL, showSql);
        jpaPropertyMap.put(Environment.FORMAT_SQL, formatSql);
//        jpaPropertyMap.put(Environment.HBM2DDL_AUTO, hbm2ddl);
        factoryBean.setJpaPropertyMap(jpaPropertyMap);
        return factoryBean;

    }

    @Bean(name = "transactionManager")
    public JpaTransactionManager transactionManager() {
        return new JpaTransactionManager(entityManagerFactory().getObject());
    }

}
