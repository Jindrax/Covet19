package com.javeriana.web.four.covet19.Shared.Infrastructure.Mail.ElasticEmail;

import com.javeriana.web.four.covet19.Shared.Domain.Ports.MailSender;
import org.springframework.http.HttpStatus;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.io.IOException;

public class MailSenderElasticEmail implements MailSender {
    @Override
    public void send(String email, String subject, String content) throws IOException {
        WebClient cliente = WebClient.create("https://api.elasticemail.com/v2/email");
        cliente.post().uri(uriBuilder -> uriBuilder
                .path("/send")
                .queryParam("apikey", System.getenv("ELASTICMAIL_API"))
                .queryParam("from", System.getenv("MAIL_SENDER_EMAIL"))
                .queryParam("subject", subject)
                .queryParam("bodyText", content)
                .queryParam("to", email)
                .build()).exchangeToMono(clientResponse -> {
            if (clientResponse.statusCode().equals(HttpStatus.OK)) {
                return clientResponse.bodyToMono(ElasticEmailResponse.class);
            } else {
                return Mono.error(new IOException());
            }
        }).block();
    }

    static class ElasticEmailResponse {

        static class ElasticEmailResponseData {
            private String transactionid;
            private String messageid;

            public String getTransactionid() {
                return transactionid;
            }

            public void setTransactionid(String transactionid) {
                this.transactionid = transactionid;
            }

            public String getMessageid() {
                return messageid;
            }

            public void setMessageid(String messageid) {
                this.messageid = messageid;
            }
        }

        private boolean sucess;
        private ElasticEmailResponseData data;

        public boolean isSucess() {
            return sucess;
        }

        public void setSucess(boolean sucess) {
            this.sucess = sucess;
        }

        public ElasticEmailResponseData getData() {
            return data;
        }

        public void setData(ElasticEmailResponseData data) {
            this.data = data;
        }
    }
}
