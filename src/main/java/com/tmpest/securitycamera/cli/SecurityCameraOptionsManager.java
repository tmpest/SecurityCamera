package com.tmpest.securitycamera.cli;

import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;

public class SecurityCameraOptionsManager {

    private static final Option VIDEO = Option.builder()
            .argName("v")
            .longOpt("video")
            .desc("Path to a video to test motion detection on the sample")
            .hasArg()
            .type(String.class)
            .required(false)
            .build();


    public Options getDefaultCommandLineOptions() {
        Options results = new Options();
        results.addOption(VIDEO);

        return results;
    }

    public String getVideoOptionName() {
        return VIDEO.getArgName();
    }
}
