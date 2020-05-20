package in.com.flycatch.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@EnableWebMvc
@Configuration
@ComponentScan({"in.com.flycatch.*" })
/*@Import(DBConfig.class)*/
public class AppConfig extends WebMvcConfigurerAdapter {
	
	/**
	 * @return
	 */
	@Bean(name = "internalResourceViewResolver")
	public InternalResourceViewResolver getViewResolver()
	{
		InternalResourceViewResolver internalResourceViewResolver = new InternalResourceViewResolver();
		internalResourceViewResolver.setPrefix("/WEB-INF/views/");
		internalResourceViewResolver.setSuffix(".jsp");
		return internalResourceViewResolver;
	}
//	
//	/* (non-Javadoc)
//	 * @see org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter#addResourceHandlers(org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry)
//	 */
//	public void addResourceHandlers(ResourceHandlerRegistry registry) {
//	    registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
//	}
//
//	/**
	
//	 * @return
//	 */
//	@Bean(name = "localeChangeInterceptor")
//	 public LocaleChangeInterceptor getLocaleChangeInterceptor(){
//	     LocaleChangeInterceptor localeChangeInterceptor=new LocaleChangeInterceptor();
//	     localeChangeInterceptor.setParamName("language");
//	     return localeChangeInterceptor;
//	 }
//	 
//	 /**
//	 * @return
//	 */
//	@Bean(name = "localeResolver")
//	 public LocaleResolver getSessionLocaleResolver(){
//	     SessionLocaleResolver localeResolver=new SessionLocaleResolver();
//	     localeResolver.setDefaultLocale(new Locale("en"));	      
//	     return localeResolver;
//	 }  
//	  
//	 /* (non-Javadoc)
//	 * @see org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter#addInterceptors(org.springframework.web.servlet.config.annotation.InterceptorRegistry)
//	 */
//	/*public void addInterceptors(InterceptorRegistry registry) {
//	     registry.addInterceptor(getLocaleChangeInterceptor());
//	     registry.addInterceptor(new AuthenticationInterceptor());
//	 }*/
//	  
//	 /**
//	 * @return
//	 */
//	@Bean(name = "messageSource")
//	 public MessageSource getMessageSource() {
//	        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
//	        messageSource.setBasenames("classpath:messages","classpath:standalone");
//	        return messageSource;
//	 } 

	public void addResourceHandlers(ResourceHandlerRegistry registry) {
	    registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
	}
	
	
}
