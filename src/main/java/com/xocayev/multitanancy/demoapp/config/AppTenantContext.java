package com.xocayev.multitanancy.demoapp.config;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Objects;

@Component
public class AppTenantContext implements Filter {

    private static final String LOGGER_TENANT_ID = "tenant_id";
    public static final String PRIVATE_TENANT_HEADER = "X-PrivateTenant";
    private static final String DEFAULT_TENANT = "public";

    private static final ThreadLocal<String> currentTenant = new InheritableThreadLocal<>();


    public static String getCurrentTenant() {
        String tenant = currentTenant.get();
        return Objects.requireNonNullElse(tenant, DEFAULT_TENANT);
    }

    public static void setCurrentTenant(String tenant) {
        MDC.put(LOGGER_TENANT_ID, tenant);
        currentTenant.set(tenant);
    }

    public static void clear() {
        MDC.clear();
        currentTenant.remove();
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        String privateTenant = req.getHeader(PRIVATE_TENANT_HEADER);
        if (privateTenant != null) {
            AppTenantContext.setCurrentTenant(privateTenant);
        }
        chain.doFilter(request, response);
    }
}
