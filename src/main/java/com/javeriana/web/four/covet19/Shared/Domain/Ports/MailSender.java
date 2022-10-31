package com.javeriana.web.four.covet19.Shared.Domain.Ports;

import java.io.IOException;

public interface MailSender {
    void send(String email, String subject, String content) throws IOException;
}
