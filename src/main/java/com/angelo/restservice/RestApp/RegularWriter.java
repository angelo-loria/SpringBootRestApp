package com.angelo.restservice.RestApp;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.Locale;

@Qualifier("RegularWriter")
@Component
public class RegularWriter implements TextWriter {
    public String writeText(String s) {
        return s.toUpperCase();
    }
}
