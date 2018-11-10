package com.tmpest.securitycamera.cli;

import org.apache.commons.cli.CommandLine;

import java.util.Optional;

/**
 * May not need this, was using to inject CommandLine output into classes that needed it.
 */
@Deprecated
public class CommandLineSupplier {
    private static CommandLine commandLine = null;
    private static boolean isInitialized = false;

    public static void setCommandLine(CommandLine newCommandLine) {
        if (!isInitialized) {
            isInitialized = true;
            commandLine = newCommandLine;
        }

        throw new IllegalStateException("The command line has already been initialized.\nStored CommandLine: "
                + Optional.ofNullable(commandLine).map(CommandLine::toString).orElse("null")
                + "\nProvided CommandLine: "
                + Optional.ofNullable(newCommandLine).map(CommandLine::toString).orElse("null"));
    }

    public static Optional<CommandLine> get() {
        return Optional.ofNullable(commandLine);
    }
}
