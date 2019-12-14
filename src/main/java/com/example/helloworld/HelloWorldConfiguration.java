package com.example.helloworld;

import io.dropwizard.Configuration;
import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class HelloWorldConfiguration extends Configuration {
    @NotEmpty
    @NotNull
    private String template;

    @NotEmpty
    private String defaultName = "Stranger";

    @NotEmpty
    private String defaultName2 = "None";

    @JsonProperty
    public String getTemplate() {
        return template;
    }

    @JsonProperty
    public void setTemplate(String template) {
        this.template = template;
    }

    @JsonProperty
    public String getDefaultName() {
        return defaultName;
    }

    @JsonProperty
    public void setDefaultName(String name) {
        this.defaultName = name;
    }

    @JsonProperty
    public void setDefaultName2(String name)
    {
    	this.defaultName2 = name;
    }

    @JsonProperty
    public String getDefaultName2()
    {
    	return defaultName2;
    }
}
