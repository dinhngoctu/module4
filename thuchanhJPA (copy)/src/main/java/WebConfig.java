import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;
import org.thymeleaf.templatemode.TemplateMode;
import repository.IUserRepo;
import repository.UserRepo;
import service.UserService;

import javax.persistence.EntityManager;


@Configuration
@EnableWebMvc
@ComponentScan("controller")
public class WebConfig implements ApplicationContextAware,WebMvcConfigurer {
    @Autowired
    private ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
    this.applicationContext=applicationContext;
    }

    @Bean
    public SpringResourceTemplateResolver templateResolver() {
        SpringResourceTemplateResolver sr = new SpringResourceTemplateResolver();
        sr.setApplicationContext(applicationContext);
        sr.setPrefix("/WEB-INF/views/");
        sr.setSuffix(".html");
        sr.setTemplateMode(TemplateMode.HTML);
        sr.setCharacterEncoding("UTF-8");
        return sr;
    }

    @Bean
    public SpringTemplateEngine templateEngine() {
        SpringTemplateEngine templateEngine = new SpringTemplateEngine();
        templateEngine.setTemplateResolver(templateResolver());
        return templateEngine;
    }

    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        ThymeleafViewResolver resolver = new ThymeleafViewResolver();
        resolver.setTemplateEngine(templateEngine());
        registry.viewResolver(resolver);
    }

    @Bean
    public UserRepo userRepo() {
        return new UserRepo();
    }

    @Bean
    public UserService userService(IUserRepo userRepo) {
        return new UserService(userRepo);
    }
}