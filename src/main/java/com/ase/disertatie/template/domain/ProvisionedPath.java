package com.ase.disertatie.template.domain;

public enum ProvisionedPath {
    MAVEN("target"),
    PYTHON("py"),
    NODEJS("js");
    private final String name;

    ProvisionedPath(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
}
