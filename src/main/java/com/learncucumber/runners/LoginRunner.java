package com.learncucumber.runners;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "/home/xu97pc/workspaces/myspace/Cucumber-BDD/src/main/java/com/learncucumber/features",
    glue = "/home/xu97pc/workspaces/myspace/Cucumber-BDD/src/main/java/com/learncucumber/stepdefinitions")
public class LoginRunner {}
