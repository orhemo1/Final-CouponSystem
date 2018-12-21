package webServices;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterConfig {

	@Bean
	public FilterRegistrationBean <ClientURLFilter> filterRegistrationBean(){
				
		FilterRegistrationBean <ClientURLFilter> registerBean=new FilterRegistrationBean<>();
		ClientURLFilter clientURLFilter=new ClientURLFilter();
		
		registerBean.setFilter(clientURLFilter);
		registerBean.addUrlPatterns("/company/*","/customer/*","/admin/*");
		return registerBean;
	}
}
