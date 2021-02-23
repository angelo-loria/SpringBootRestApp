package com.angelo.restservice.RestApp;

import org.springframework.stereotype.Component;

@Component
public interface TextWriter {

    public String writeText(String s);
}
