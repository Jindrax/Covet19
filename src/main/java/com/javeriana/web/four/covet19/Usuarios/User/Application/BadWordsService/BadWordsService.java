package com.javeriana.web.four.covet19.Usuarios.User.Application.BadWordsService;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.javeriana.web.four.covet19.Usuarios.User.Domain.Ports.ValidateWordService;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

public class BadWordsService implements ValidateWordService {

    @Override
    public boolean validate(String word) {
        String Body = "censor-character=*&content=" + word;
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://neutrinoapi-bad-word-filter.p.rapidapi.com/bad-word-filter"))
                .header("content-type", "application/x-www-form-urlencoded")
                .header("x-rapidapi-key", "cb37442b86msh68d5d1635f690a5p1c2800jsnd56863cd5419")
                .header("x-rapidapi-host", "neutrinoapi-bad-word-filter.p.rapidapi.com")
                .method("POST", HttpRequest.BodyPublishers.ofString(Body))
                .build();

        try {
            HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
            Response responseObject = new ObjectMapper().readValue(response.body(), Response.class);
            return responseObject.getBad();
        }
        catch (Exception ex)
        {
            System.out.println(ex.getMessage());
            return false;
        }
    }
}

final class Response
{
    @JsonProperty("censored-content")
    private String censored;

    @JsonProperty("is-bad")
    private Boolean isBad;

    @JsonProperty("bad-words-total")
    private Integer total;

    @JsonProperty("bad-words-list")
    private List<String> words;

    public String getCensored() {
        return censored;
    }

    public void setCensored(String censored) {
        this.censored = censored;
    }

    public Boolean getBad() {
        return isBad;
    }

    public void setBad(Boolean bad) {
        isBad = bad;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public List<String> getWords() {
        return words;
    }

    public void setWords(List<String> words) {
        this.words = words;
    }
}
