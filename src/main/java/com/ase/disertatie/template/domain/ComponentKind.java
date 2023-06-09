package com.ase.disertatie.template.domain;

public enum ComponentKind {
    DEPLOYMENT("Deployment"),
    SVC("Service"),
    DOCKERFILE("Dockerfile"),
    HPA("HorizontalPodAutoscaler"),
    INGRESS("Ingress"),
    CONFIGMAP("ConfigMap");
    private final String name;

    ComponentKind(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
}
