package com.javeriana.web.four.covet19.Shared.Infrastructure.Security.XMLSecurity;

import com.thoughtworks.xstream.XStream;
import org.springframework.http.HttpMethod;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class XMLSecurityParser {
    public static void read(){
        XStream xstream = new XStream();
        xstream.alias("directive", XMLSecurityDirective.class);
        xstream.alias("directives", List.class);
        xstream.useAttributeFor(String.class);
        xstream.useAttributeFor(HttpMethod.class);
        try {
            SecurityDirectives.directives = (List<XMLSecurityDirective>) xstream.fromXML(new FileReader("./src/main/resources/securityDirectives.xml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
