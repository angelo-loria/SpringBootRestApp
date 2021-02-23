package com.angelo.restservice.RestApp;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Qualifier("FancyWriter")
@Component
public class FancyWriter implements TextWriter {

    public String writeText(String s) {
        return s + " fancy text";
    }
}
