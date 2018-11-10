package com.tmpest.securitycamera.cli.guice;

import com.google.inject.AbstractModule;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;

public class CLIModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(CommandLineParser.class).to(DefaultParser.class);
    }
}
