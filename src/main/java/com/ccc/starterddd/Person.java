package com.ccc.starterddd;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "dtstarter")
public class Person {
    private String name;
    private String age;
}
