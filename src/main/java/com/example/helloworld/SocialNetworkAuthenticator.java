package com.example.helloworld;

import io.dropwizard.auth.Authenticator;
import io.dropwizard.auth.basic.BasicCredentials;

import io.dropwizard.auth.AuthenticationException;
import io.dropwizard.jersey.caching.CacheControl;

import java.util.HashMap;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

public class SocialNetworkAuthenticator implements Authenticator<BasicCredentials, User> {
    HashMap<String,String> validCredentials;
    SocialNetworkAuthenticator(HashMap<String,String> credentialList)
    {
        validCredentials = new HashMap<String, String>();
        validCredentials.putAll(credentialList);
    }
    @Override
    public Optional<User> authenticate(BasicCredentials credentials) throws AuthenticationException
    {
        if(validCredentials.containsKey(credentials.getUsername()))
        {
            String username = credentials.getUsername();
            if(credentials.getPassword().equals(validCredentials.get(username)))
                return Optional.of(new User(username));
        }
        return Optional.empty();
    }
}
