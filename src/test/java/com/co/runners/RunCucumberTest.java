package com.co.runners;

import io.cucumber.junit.platform.engine.Constants;
import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;

@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("features")
// Use the official constant for the plugin key
@ConfigurationParameter(
        key = Constants.PLUGIN_PROPERTY_NAME,
        value = "io.cucumber.core.plugin.SerenityReporterParallel")
@ConfigurationParameter(key = Constants.GLUE_PROPERTY_NAME, value = "com.co.stepdefinitions")
public class RunCucumberTest {}
