package com.buForumCalender.config;


import com.mchange.v2.c3p0.ComboPooledDataSource;
import java.beans.PropertyVetoException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.DataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableTransactionManagement
@EnableWebMvc
@ComponentScan(basePackages="com.buForumCalender")
@PropertySource("/WEB-INF/resources/persistence-mysql.properties")
public class DemoAppConfig extends WebMvcConfigurerAdapter {
        
        //Set up variables to hold properties
        @Autowired
        Environment env;
        
        //set up logger for diagnostics
        private Logger logger = Logger.getLogger(getClass().getName());

        @Override
        public void addResourceHandlers(ResourceHandlerRegistry registry) {
           registry.addResourceHandler("/resources/**").addResourceLocations("/WEB-INF/resources/");
        }

        @Override
        public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
          configurer.enable();
        }
        
        
	// define a bean for ViewResolver

	@Bean
	public ViewResolver viewResolver() {
		
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		
		viewResolver.setPrefix("/WEB-INF/view/");
		viewResolver.setSuffix(".jsp");
		
		return viewResolver;
	}
	
        //Define bean for dataSource
        
        @Bean
        public DataSource securityDataSource(){
            //Create connection Pool
            ComboPooledDataSource securtiyDataSource = new ComboPooledDataSource();
            try {
                // Set JDBC Driver class
                securtiyDataSource.setDriverClass(env.getProperty("jdbc.driver"));
            } catch (PropertyVetoException ex) {
               throw new RuntimeException(ex);
            }
                //log the commection props
                logger.log(Level.INFO, ">>>jdbc url: {0}", env.getProperty("jdbc.url"));
                logger.log(Level.INFO, ">>>jdbc user: {0}", env.getProperty("jdbc.user"));
                
                //set connection props
                securtiyDataSource.setJdbcUrl(env.getProperty("jdbc.url"));
                securtiyDataSource.setUser(env.getProperty("jdbc.user"));
                securtiyDataSource.setPassword(env.getProperty("jdbc.password"));
                
                securtiyDataSource.setInitialPoolSize(getIntProperty("connection.pool.initialPoolSize"));
                securtiyDataSource.setMinPoolSize(getIntProperty("connection.pool.minPoolSize"));
                securtiyDataSource.setMaxPoolSize(getIntProperty("connection.pool.maxPoolSize"));
                securtiyDataSource.setMaxIdleTime(getIntProperty("connection.pool.maxIdleTime"));
                
            return securtiyDataSource;
        }
        
        //need helper method to read
        //read env properties and convert to int
        
        private int getIntProperty(String propName){
        String propVal = env.getProperty(propName);
        //convert to int
        int propValInt = Integer.parseInt(propVal);
        return propValInt;
        }
        
        
        //Set up seesion Factory
        
        @Bean
        public LocalSessionFactoryBean sessionFactory() {
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(securityDataSource());
        sessionFactory.setPackagesToScan(new String[]{"com.buForumCalender.entity"});
        sessionFactory.setHibernateProperties(hibernateProperties());
        return sessionFactory;
        }
        
        //Properties for hibernate
        Properties hibernateProperties() {
        return new Properties() {
            {
                setProperty("hibernate.hbm2ddl.auto", "update");
                setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5InnoDBDialect");
                setProperty("hibernate.show_sql", "true");
            }
        };
    }
        
        @Bean
        @Autowired
        public HibernateTransactionManager transactionManager(SessionFactory sessionfactory){
            HibernateTransactionManager txManager = new HibernateTransactionManager();
            txManager.setSessionFactory(sessionfactory);
                    return txManager;
        }
}









