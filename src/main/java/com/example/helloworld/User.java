package com.example.helloworld;

import java.security.Principal;

public class User implements Principal {
    private final String name;
    User(String n)
    {
        name = n;
    }
    public String getName() {
        return name;
    }
}
