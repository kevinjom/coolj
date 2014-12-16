package com.kevinfan.coolj.rest.dropwizard.hello;

import io.dropwizard.Application;
import io.dropwizard.assets.AssetsBundle;
import io.dropwizard.cli.Command;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import net.sourceforge.argparse4j.inf.Namespace;
import net.sourceforge.argparse4j.inf.Subparser;

/**
 * Created by kevinjom on 14-9-12.
 */
public class HelloApplication extends Application<HelloConfiguration> {
    @Override
    public void initialize(Bootstrap<HelloConfiguration> bootstrap) {
        bootstrap.addBundle(new AssetsBundle());
        bootstrap.addCommand(new ListResourcesCommand(this, "ls", "list resources"));
    }

    @Override
    public void run(HelloConfiguration configuration, Environment environment) throws Exception {
        //register resources
        HelloResource helloResource = new HelloResource(configuration.getTemplate());
        environment.jersey().register(helloResource);

        environment.jersey().register(new UserResource());


        //register health checks
        environment.healthChecks().register("templateCheck", new TemplateHealthCheck(configuration.getTemplate()));
    }

    @Override
    public String getName() {
        return "Hello Service!";
    }

    public static void main(String[] args) throws Exception {
        new HelloApplication().run(args);
    }
}
