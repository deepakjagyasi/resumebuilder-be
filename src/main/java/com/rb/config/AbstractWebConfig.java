/*
package com.rb.config;

import com.bt.nextgen.core.util.Properties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.core.annotation.Order;
import org.springframework.http.converter.ByteArrayHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.ResourceHttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJacksonHttpMessageConverter;
import org.springframework.mobile.device.DeviceResolver;
import org.springframework.mobile.device.DeviceResolverHandlerInterceptor;
import org.springframework.mobile.device.DeviceWebArgumentResolver;
import org.springframework.mobile.device.LiteDeviceResolver;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.mvc.WebContentInterceptor;
import org.springframework.web.servlet.mvc.annotation.AnnotationMethodHandlerExceptionResolver;
import org.springframework.web.servlet.mvc.method.annotation.ServletWebArgumentResolverAdapter;
import org.springframework.web.servlet.view.UrlBasedViewResolver;
import org.springframework.web.servlet.view.tiles2.SimpleSpringPreparerFactory;
import org.springframework.web.servlet.view.tiles2.TilesConfigurer;
import org.springframework.web.servlet.view.tiles2.TilesView;

import java.util.List;

import static com.bt.nextgen.core.util.SETTINGS.*;

@EnableWebMvc
@PropertySource(value =
{
	"classpath:/version-app.properties", "classpath:/common.properties", "classpath:/env.properties"
})
public class AbstractWebConfig extends WebMvcConfigurerAdapter
{
	private static final Logger logger = LoggerFactory.getLogger(AbstractWebConfig.class);

	@Override
	public void configureMessageConverters(List <HttpMessageConverter <? >> converters)
	{
		converters.add(new StringHttpMessageConverter());
		converters.add(new ByteArrayHttpMessageConverter());
		converters.add(new ResourceHttpMessageConverter());
		super.configureMessageConverters(converters);
	}


	@Override
	public void addInterceptors(InterceptorRegistry registry)
	{
		DeviceResolver resolver = new LiteDeviceResolver();
		registry.addInterceptor(new DeviceResolverHandlerInterceptor(resolver));

		WebContentInterceptor interceptor = new WebContentInterceptor();
		interceptor.setCacheSeconds(0);
		interceptor.setUseExpiresHeader(true);
		interceptor.setUseCacheControlHeader(true);
		interceptor.setUseCacheControlNoStore(true);
		registry.addInterceptor(interceptor);

	}

	@Override
	public void addArgumentResolvers(List <HandlerMethodArgumentResolver> argumentResolvers)
	{
		argumentResolvers.add(new ServletWebArgumentResolverAdapter(new DeviceWebArgumentResolver()));
	}

	@Bean
	public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer()
	{
		return new PropertySourcesPlaceholderConfigurer();
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry)
	{
		registry.addResourceHandler("/secure/app*/
/**")
			.addResourceLocations(WEBCLIENT_RESOURCE_LOCATION.value())
			.setCachePeriod(WEBCLIENT_CACHE_PERIOD.intValue());
	}

	@Bean
	public ViewResolver viewResolver()
	{
		UrlBasedViewResolver viewResolver = new UrlBasedViewResolver();
		viewResolver.setViewClass(TilesView.class);
		return viewResolver;
	}

	@Bean
	public ReloadableResourceBundleMessageSource messageSource()
	{
		ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
		messageSource.setBasenames("classpath:/message/cashMessages", "classpath:/validation/validationMessages");
		return messageSource;
	}

	@Bean
	@Order(value = 0)
	public AnnotationMethodHandlerExceptionResolver annotationMethodHandlerExceptionResolver()
	{
		return new AnnotationMethodHandlerExceptionResolver();
	}

	@Bean
	public TilesConfigurer tilesConfigurer()
	{
		TilesConfigurer tilesConfigurer = new TilesConfigurer();
		tilesConfigurer.setDefinitions(new String[]
		{
			"/WEB-INF/tiles-defs.xml", "/WEB-INF/tiles-defs/addressbook.xml", "/WEB-INF/tiles-defs/admin.xml",
			"/WEB-INF/tiles-defs/clients.xml", "/WEB-INF/tiles-defs/dashboard.xml", "/WEB-INF/tiles-defs/deposit.xml",
			"/WEB-INF/tiles-defs/global-elements.xml", "/WEB-INF/tiles-defs/logon.xml", "/WEB-INF/tiles-defs/message-centre.xml",
			"/WEB-INF/tiles-defs/payments.xml", "/WEB-INF/tiles-defs/products-and-news.xml",
			"/WEB-INF/tiles-defs/registration.xml", "/WEB-INF/tiles-defs/reporting.xml", "/WEB-INF/tiles-defs/term-deposit.xml",
			"/WEB-INF/tiles-defs/transactions.xml", "/WEB-INF/tiles-defs/avoka.xml", "/WEB-INF/tiles-defs/service-operator.xml",
			"/WEB-INF/tiles-defs/error.xml"
		});

		tilesConfigurer.setPreparerFactoryClass(SimpleSpringPreparerFactory.class);

		return tilesConfigurer;
	}

	@Bean
	public MultipartResolver multipartResolver()
	{
		CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
		multipartResolver.setMaxUploadSize(Long.parseLong(Properties.get("fileupload.max.file.size")));
		return multipartResolver;
	}

}*/
