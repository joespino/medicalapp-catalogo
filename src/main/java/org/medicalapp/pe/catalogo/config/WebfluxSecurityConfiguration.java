package org.medicalapp.pe.catalogo.config;

import org.medicalapp.pe.catalogo.security.CustomAuthorizeExchange;
import org.medicalapp.pe.spring.jwt.converter.AuthorizeExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WebfluxSecurityConfiguration {

	/**
	 * Claims para la parte de seguridad
	 * 
	 * @return JwtClaimConverter
	 */
    /*@Bean
    public JwtClaimConverter jwtClaimConverter() {
        return new CustomJwtClaimConverter();
    }*/

    /**
	 * Bean para la parte de seguridad
	 * 
	 * @return AuthorizeExchange
	 */
    @Bean
    public AuthorizeExchange authorizeExchange() { return new CustomAuthorizeExchange(); }

}
