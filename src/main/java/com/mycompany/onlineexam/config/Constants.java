package com.mycompany.onlineexam.config;

import java.net.URI;

public class Constants {

    public static final String ERR_CONCURRENCY_FAILURE = "error.concurrencyFailure";
    public static final String ERR_VALIDATION = "error.validation";
    public static final String PROBLEM_BASE_URL = "https://www.parsian-bank.ir/problem";
    public static final URI DEFAULT_TYPE = URI.create(PROBLEM_BASE_URL + "/problem-with-message");
    public static final URI CONSTRAINT_VIOLATION_TYPE = URI.create(PROBLEM_BASE_URL + "/constraint-violation");
    public static final String SPRING_PROFILE_DEVELOPMENT = "dev";
    public static final String SPRING_PROFILE_TEST = "test";
    public static final String SPRING_PROFILE_PRODUCTION = "prod";
    public static final String SPRING_PROFILE_CLOUD = "cloud";
    public static final String SPRING_PROFILE_HEROKU = "heroku";
    public static final String SPRING_PROFILE_AWS_ECS = "aws-ecs";
    public static final String SPRING_PROFILE_AZURE = "azure";
    public static final String SPRING_PROFILE_SWAGGER = "swagger";
    public static final String SPRING_PROFILE_NO_LIQUIBASE = "no-liquibase";
    public static final String SPRING_PROFILE_K8S = "k8s";
}
