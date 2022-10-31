package com.javeriana.web.four.covet19.Shared.Infrastructure.Mail.SendGrid;


import com.javeriana.web.four.covet19.Shared.Domain.Ports.MailSender;
import com.sendgrid.*;

import java.io.IOException;

public class MailSenderSendGridImpl implements MailSender {
    @Override
    public void send(String email, String subject, String content) throws IOException {
        Email from = new Email(System.getenv("MAIL_SENDER_EMAIL"));
        Email to = new Email(email);
        Content contentBuilded = new Content("text/plain", content);
        Mail mail = new Mail(from, subject, to, contentBuilded);

        SendGrid sg = new SendGrid(System.getenv("SENDGRID_API"));
        Request request = new Request();
        try {
            request.setMethod(Method.POST);
            request.setEndpoint("mail/send");
            request.setBody(mail.build());
            Response response = sg.api(request);
            System.out.println(response.getStatusCode());
            System.out.println(response.getBody());
            System.out.println(response.getHeaders());
        } catch (IOException ex) {
            throw ex;
        }
    }
}