package repository;
import formatter.ProvinceFormatter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import service.ProductServiceInterFace;
import service.ProvinceServiceInterface;
import service.impl.ProductService;
import service.impl.ProvinceService;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Properties;


@Configuration
@EnableSpringDataWebSupport
@EnableJpaRepositories("repository")
@EnableTransactionManagement
@ComponentScan("repository")
@ComponentScan("model")
@ComponentScan("service")
public class RepoConfig {
    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("Jdbc:mysql://52.187.177.166:3306/data?serverTimezone=UTC");
        dataSource.setUsername("root");
        dataSource.setPassword("Maiyeuem89");
        return dataSource;
    }

    private Properties additonalProperties() {
        Properties properties = new Properties();
        properties.setProperty("hibernate.show_sql", "true");
//        thuc hien lenh create moi khi mo hoac dong ung dung (destroy) can than khi dung  create drop
        properties.setProperty("hibernate.hbm2ddl.auto", "create-drop");
        properties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
        return properties;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory (DataSource dataSource) {
        LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
        entityManagerFactoryBean.setDataSource(dataSource);
        entityManagerFactoryBean.setJpaProperties(additonalProperties());
        entityManagerFactoryBean.setPackagesToScan("model");
        entityManagerFactoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        return entityManagerFactoryBean;
    }

    @Bean
    @Qualifier("entityManager")
    public EntityManager entityManager(EntityManagerFactory entityManagerFactoryBean) {
      return entityManagerFactoryBean.createEntityManager();
    }
    @Bean
    public PlatformTransactionManager transactionManager(EntityManagerFactory emfb) {
        JpaTransactionManager jpaTransactionManager = new JpaTransactionManager();
        jpaTransactionManager.setEntityManagerFactory(emfb);
        return jpaTransactionManager;
    }

    @Bean
    public ProductServiceInterFace ProductServiceInterFace() {
        return new ProductService();
    }

    @Bean
    public ProvinceServiceInterface ProvinceServiceInterface() {
        return new ProvinceService();
    }

}
