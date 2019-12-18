package com.example.helloworld;

import com.example.helloworld.resources.Profile;
import io.dropwizard.Application;
import io.dropwizard.auth.AuthDynamicFeature;
import io.dropwizard.auth.AuthValueFactoryProvider;
import io.dropwizard.auth.basic.BasicCredentialAuthFilter;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import com.example.helloworld.resources.AuthenticationResource;

public class SocialNetworkApplication extends Application<SocialNetworkConfiguration> {
    public static void main(String[] args) throws Exception {
        new SocialNetworkApplication().run(args);
    }

    @Override
    public String getName() {
        return "social-network";
    }

    @Override
    public void initialize(Bootstrap<SocialNetworkConfiguration> bootstrap) {
        // nothing to do yet
    }

    @Override
    public void run(SocialNetworkConfiguration configuration,
                    Environment environment) {
        configuration.createMap();
		final AuthenticationResource resource = new AuthenticationResource();
		final Profile profile = new Profile();
		environment.jersey().register(profile);
		environment.jersey().register(resource);
		environment.jersey().register(new AuthDynamicFeature(new BasicCredentialAuthFilter.Builder<User>()
                .setAuthenticator(new SocialNetworkAuthenticator(configuration.getMap()))
                .setRealm("SOCIAL-AUTH-REALM")
                .buildAuthFilter()));
		environment.jersey().register(new AuthValueFactoryProvider.Binder<User>(User.class));
    }
}
