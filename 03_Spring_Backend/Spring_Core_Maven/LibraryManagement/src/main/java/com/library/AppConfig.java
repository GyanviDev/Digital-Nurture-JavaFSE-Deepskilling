package com.library;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.library")
public class AppConfig {
    // Spring will automatically scan the com.library package for @Service and @Repository annotations
}