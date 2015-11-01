/*
package com.rb.filter;

import org.apache.commons.lang3.ObjectUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServletServerHttpResponse;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class ApplicationStatusCheckFilter implements Filter{

	private static final Logger logger = LoggerFactory.getLogger(ApplicationStatusCheckFilter.class);

	public static final String HUMAN_URL = "/public/static/page/starting.html";

	static final String SESSION_KEY = ApplicationStatusCheckFilter.class.getCanonicalName()+".reveal";

	ApplicationStatusService appStatusService;

	final HttpMessageConverter jsonConverter = AbstractWebConfig.createJacksonConverter();

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain filterChain) throws IOException, ServletException {
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		HttpServletRequest httpRequest = (HttpServletRequest) request;

		logger.info("Resource invoked: {}", httpRequest.getRequestURI());

		final String queryString = httpRequest.getQueryString();
		if(queryString != null && queryString.toLowerCase().contains("reveal")){
			logger.info("Reveal present in request, bypass blocking pages...");
			httpRequest.getSession().setAttribute(SESSION_KEY, true);
		}

		if(!revealEnabled(httpRequest) && !appStatusService.checkCacheStatus()){
			httpResponse.addHeader("Retry-After", "30");
			if(MediaType.APPLICATION_JSON_VALUE.equalsIgnoreCase(httpRequest.getContentType())) {
				httpResponse.setStatus(HttpServletResponse.SC_ACCEPTED);
				jsonConverter.write(makeAjaxResponse(httpResponse, httpRequest)
						, MediaType.APPLICATION_JSON
						, new ServletServerHttpResponse(httpResponse));
			}
			else {
				logger.info("Application not available for LOGIN, Returning STARTING page");
				httpResponse.sendRedirect(getRedirectUrl(httpResponse, httpRequest));
			}
			return;
		}
		else{
			logger.debug("Application available for request processing");
			filterChain.doFilter(request, response);
		}
	}

	private boolean revealEnabled(HttpServletRequest request) {
		return (boolean) ObjectUtils.defaultIfNull(request.getSession().getAttribute(SESSION_KEY), false);
	}

	private AjaxResponse makeAjaxResponse(HttpServletResponse httpResponse, HttpServletRequest httpRequest) {
		return new AjaxResponse(true
				, new StatusCheckResponse("NOT_READY"
						, getRedirectUrl(httpResponse, httpRequest)
						, "The server is starting up, please wait..."));
	}

	private String getRedirectUrl(HttpServletResponse httpResponse, HttpServletRequest httpRequest) {
		return httpResponse.encodeRedirectURL(httpRequest.getContextPath()+HUMAN_URL);
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {

		ServletContext servletContext = filterConfig.getServletContext();
		ApplicationContext ctx = WebApplicationContextUtils.getWebApplicationContext(
				servletContext);
		appStatusService = ctx.getBean(ApplicationStatusService.class);

	}

	@Override
	public void destroy() {}
}
*/
