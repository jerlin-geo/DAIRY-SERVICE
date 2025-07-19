package com.vetri.erp.ds.config.datasorce;

import java.io.IOException;

import org.springframework.stereotype.Component;

import jakarta.servlet.FilterChain;
import jakarta.servlet.GenericFilter;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;

@Component
public class DataSourceRoutingFilter extends GenericFilter {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest httpReq = (HttpServletRequest) request;
		String dbKey = httpReq.getHeader("DB-ID");
		DataSourceContextHolder.setDataSourceKey(dbKey);

		try {
			chain.doFilter(request, response);
		} finally {
			DataSourceContextHolder.clear();
		}
	}
}
