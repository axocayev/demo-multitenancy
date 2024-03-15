package com.xocayev.multitanancy.demoapp.config;


import org.hibernate.context.spi.CurrentTenantIdentifierResolver;
import org.springframework.stereotype.Component;

@Component
public class CurrentTenantIdentifierResolverImpl implements CurrentTenantIdentifierResolver<String> {
    @Override
    public String resolveCurrentTenantIdentifier() {
        String tenant = AppTenantContext.getCurrentTenant();
        System.out.println(tenant);
        if (tenant != null) {
            return tenant;
        } else {
            return "public";
        }

    }

    @Override
    public boolean validateExistingCurrentSessions() {
        return true;
    }
}
