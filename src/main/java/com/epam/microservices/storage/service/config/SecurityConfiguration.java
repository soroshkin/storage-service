package com.epam.microservices.storage.service.config;

import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
public class SecurityConfiguration {

  private final CorsCustomizer corsCustomizer;

  public SecurityConfiguration(CorsCustomizer corsCustomizer) {
    this.corsCustomizer = corsCustomizer;
  }

  @Bean
  SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    corsCustomizer.corsCustomizer(http);
    http
      .authorizeRequests()
      .antMatchers(HttpMethod.GET, "/storages/**")
      .permitAll()
      .mvcMatchers("/storages/**")
      .access("hasAuthority('SCOPE_storages.write')")
      .and()
      .oauth2ResourceServer()
      .jwt();

    return http
      .csrf()
      .disable()
      .build();
  }
}