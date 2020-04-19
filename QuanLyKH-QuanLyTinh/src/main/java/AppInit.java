import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
import repository.RepoConfig;

public class AppInit extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected Class<?>[] getRootConfigClasses() {
//        return new Class[0];
        return new Class[]{RepoConfig.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{WebConfig.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}
