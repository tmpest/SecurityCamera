package com.tmpest.securitycamera.cli;

import com.google.inject.Inject;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.ParseException;

import java.util.Optional;

public class CommandLineInputReader {

    private final CommandLineParser commandLineParser;
    private final SecurityCameraOptionsManager optionsFactory;

    @Inject
    public CommandLineInputReader(CommandLineParser commandLineParser,
                                  SecurityCameraOptionsManager optionsFactory) {
        this.commandLineParser = commandLineParser;
        this.optionsFactory = optionsFactory;
    }

    public Optional<CommandLine> handleInput(String[] input) {
        try {
            return Optional.of(commandLineParser.parse(optionsFactory.getDefaultCommandLineOptions(), input));
        } catch (ParseException pe) {
            String errorMsg = "Parse Exception while trying to process command line input." +
                    "\nInput: " + input
                    + "\nException Message: " + pe.getMessage()
                    + "\n" + pe.getStackTrace();

            //TODO Log error Msg
            System.out.println(errorMsg);

            return Optional.empty();
        }
    }
}
