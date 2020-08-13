package com.care4india.restapi;

/**
 * Created by rameshkale on 08/08/20.
 */
public class ApplicationToken {
    public String token;

    public ApplicationToken(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
