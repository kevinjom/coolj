package com.kevinfan.coolj.rest.dropwizard.hello;

import com.sun.org.apache.xpath.internal.SourceTreeManager;
import io.dropwizard.Application;
import io.dropwizard.cli.EnvironmentCommand;
import io.dropwizard.setup.Environment;
import net.sourceforge.argparse4j.inf.Namespace;

import java.util.Set;

/**
 * Created by kevinjom on 14-9-13.
 */
public class ListResourcesCommand extends EnvironmentCommand<HelloConfiguration> {
    /**
     * Creates a new environment command.
     *
     * @param application the application providing this command
     * @param name        the name of the command, used for command line invocation
     * @param description a description of the command's purpose
     */
    protected ListResourcesCommand(Application<HelloConfiguration> application, String name, String description) {
        super(application, name, description);
    }

    @Override
    protected void run(Environment environment, Namespace namespace, HelloConfiguration configuration) throws Exception {
        Set<Object> resources = environment.jersey().getResourceConfig().getSingletons();
        System.out.println(resources);
    }
}
