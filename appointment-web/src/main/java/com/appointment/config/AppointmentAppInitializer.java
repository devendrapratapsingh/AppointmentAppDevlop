package com.appointment.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration.Dynamic;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class AppointmentAppInitializer implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext container) throws ServletException {

		AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();
		rootContext.register(AppConfig.class);
		rootContext.setServletContext(container);
		container.addListener(new ContextLoaderListener(rootContext));
		// Manage the lifecycle of the root application context
		// container.addListener(new ContextLoaderListener(rootContext));

		AnnotationConfigWebApplicationContext dispatcherContext = new AnnotationConfigWebApplicationContext();
		dispatcherContext.register(AppConfig.class);

		Dynamic servlet = container.addServlet("dispatcher",
				new DispatcherServlet(dispatcherContext));

		servlet.setLoadOnStartup(1);
		servlet.addMapping("/");
		// servlet.addMapping("/");

	}

}
