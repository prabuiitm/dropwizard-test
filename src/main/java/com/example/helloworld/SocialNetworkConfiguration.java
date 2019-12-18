package com.example.helloworld;

import io.dropwizard.Configuration;
import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.HashMap;

public class SocialNetworkConfiguration extends Configuration {
    @NotEmpty
    @NotNull
    private String usernames;

    @NotEmpty
    @NotNull
    private String passwords;

    private HashMap<String,String> creds = new HashMap<String, String>();

    @JsonProperty
    public void setUsernames(String u)
    {
        usernames = u;
    }
    @JsonProperty
    public void setPasswords(String p)
    {
        passwords = p;
    }
    public void createMap()
    {
        String[] s = usernames.split(",");
        String[] t = passwords.split(",");
        if(s.length==t.length) {
            for (int i = 0; i < s.length; i++) {
                creds.put(s[i].trim(),t[i].trim());
            }
        }else {
            for (int i = 0; i < Math.min(s.length, t.length); i++) {
                creds.put(s[i].trim(), t[i].trim());
            }
        }
    }
    public HashMap<String,String> getMap()
    {
        return creds;
    }
}
