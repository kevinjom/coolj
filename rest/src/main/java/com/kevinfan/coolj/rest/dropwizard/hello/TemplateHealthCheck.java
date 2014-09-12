package com.kevinfan.coolj.rest.dropwizard.hello;

import com.codahale.metrics.health.HealthCheck;

/**
 * Created by kevinjom on 14-9-12.
 */
public class TemplateHealthCheck extends HealthCheck {
    private final String template;

    public TemplateHealthCheck(String template) {
        this.template = template;
    }

    @Override
    protected Result check() throws Exception {
        String rendered = String.format(template, "test");
        if (rendered.contains("test")) {
            return Result.healthy();
        }
        return Result.unhealthy("invalid template format");
    }
}
