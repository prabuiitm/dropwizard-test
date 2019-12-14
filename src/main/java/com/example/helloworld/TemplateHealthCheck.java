package com.example.helloworld.health;

import com.codahale.metrics.health.HealthCheck;

public class TemplateHealthCheck extends HealthCheck {
    private final String template;

    public TemplateHealthCheck(String template) {
        this.template = template;
    }

    @Override
    protected Result check() throws Exception {
        final String saying = String.format(template, "TEST", "REST");
        if (!saying.contains("TEST")) {
            return Result.unhealthy("template doesn't include a name");
        }
        if(!saying.contains("REST"))
        {
            return Result.unhealthy("template doesn't include the second name");
        }
        return Result.healthy();
    }
}
