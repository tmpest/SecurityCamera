package com.tmpest.securitycamera;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.tmpest.securitycamera.cli.CommandLineInputReader;
import com.tmpest.securitycamera.cli.SecurityCameraOptionsManager;
import com.tmpest.securitycamera.cli.guice.CLIModule;
import org.apache.commons.cli.CommandLine;

import java.util.Optional;

public class SecurityCamera {

    public static void main(String[] argsv) {
        Injector injector = Guice.createInjector(new CLIModule());

        CommandLineInputReader inputReader = injector.getInstance(CommandLineInputReader.class);
        SecurityCameraOptionsManager optionsManager = injector.getInstance(SecurityCameraOptionsManager.class);

        Optional<CommandLine> commandLineOptional = inputReader.handleInput(argsv);
        if (!commandLineOptional.isPresent()) {
            return;
        }

        CommandLine commandLine = commandLineOptional.get();

        if (commandLine.hasOption(optionsManager.getVideoOptionName())) {
            // Do Motion Analysis
        }
        // Nothing left to do TODO log error for now because nothing else is supported
    }
}
