package com.javeriana.web.four.covet19.Shared.Infrastructure.Security.XMLSecurity;

import org.springframework.http.HttpMethod;

public class XMLSecurityDirective {
    private final String endpoint;
    private final String authority;
    private HttpMethod method;

    public XMLSecurityDirective(String endpoint, String authority, HttpMethod method) {
        this.endpoint = endpoint;
        this.authority = authority;
        this.method = method;
    }

    public XMLSecurityDirective(String endpoint, String authority) {
        this.endpoint = endpoint;
        this.authority = authority;
    }

    public String getEndpoint() {
        return endpoint;
    }

    public String getAuthority() {
        return authority;
    }

    public HttpMethod getMethod() {
        return method;
    }
}
