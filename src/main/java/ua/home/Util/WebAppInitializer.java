package ua.home.Util;


import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
import ua.home.Config;

//import ua.home.config.PersistenceJPAConfig;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

public class WebAppInitializer extends  AbstractAnnotationConfigDispatcherServletInitializer implements WebApplicationInitializer


{

    @Override
    public void onStartup(ServletContext servletContext)

throws ServletException
    {

        AnnotationConfigWebApplicationContext context =
                new AnnotationConfigWebApplicationContext();
        context.register(Config.class);
        //context.register(PersistenceJPAConfig.class);
        ServletRegistration.Dynamic registration =
                servletContext.addServlet("main", new DispatcherServlet(context));

        registration.setLoadOnStartup(1);
        registration.addMapping("/");
    }

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[] { PersistenceConfig.class };
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[] { Config.class };
    }

    @Override
    protected String[] getServletMappings() {
        return new String[] { "/" };
    }

}
