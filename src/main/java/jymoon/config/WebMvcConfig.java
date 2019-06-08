package jymoon.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
@EnableWebMvc
public class WebMvcConfig implements WebMvcConfigurer {
	public static final String RESOURCE_LOCATION = "/static/";
	public static final String RESOURCE_PATTERN = "/static/**";

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry
			.addResourceHandler(RESOURCE_PATTERN).addResourceLocations(RESOURCE_LOCATION);
	}

	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		final InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/templates");
		viewResolver.setSuffix(".jsp");
		viewResolver.setViewClass(JstlView.class);

		registry.viewResolver(viewResolver);
	}
}