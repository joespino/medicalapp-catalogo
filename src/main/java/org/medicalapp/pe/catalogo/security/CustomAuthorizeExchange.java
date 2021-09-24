package org.medicalapp.pe.catalogo.security;

import org.medicalapp.pe.spring.jwt.converter.AuthorizeExchange;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.web.server.ServerHttpSecurity;

public class CustomAuthorizeExchange implements AuthorizeExchange {

    @Override
    public ServerHttpSecurity.AuthorizeExchangeSpec authorize(ServerHttpSecurity.AuthorizeExchangeSpec excange) {
        return excange.pathMatchers(HttpMethod.GET).permitAll();
    }
}
