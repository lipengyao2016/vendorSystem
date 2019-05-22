package com.vendor.config;

import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableApolloConfig
public class ApolloBootConfig {

    public String getPlatFormCode() {
        return PlatFormCode;
    }

    public void setPlatFormCode(String platFormCode) {
        PlatFormCode = platFormCode;
    }

    @Value("${server.domain}")
    private String PlatFormCode;
}
