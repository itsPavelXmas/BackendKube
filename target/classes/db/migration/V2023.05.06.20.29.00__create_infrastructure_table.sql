create table infrastructure_template
(
    id      bigint not null
        primary key,
    content varchar(100000),
    kind    varchar(255)
);


INSERT INTO public.infrastructure_template (id, content, kind) VALUES (4, 'apiVersion: v1
kind: Service
metadata:
  name: COMPONENT_NAME
  namespace: NAMESPACE_NAME
  labels:
    app: LABEL_NAME
spec:
  selector:
    app: LABEL_NAME
  type: TYPE
  ports:
  - protocol: PORT_NAME
    port: PORT
    targetPort: TARGET_PORT', 'SVC');
INSERT INTO public.infrastructure_template (id, content, kind) VALUES (2, 'apiVersion: apps/v1
kind: Deployment
metadata:
  name: DEPLOYMENT_NAME
  namespace: NAMESPACE_NAME
spec:
  replicas: REPLICA_NUMBER
  selector:
    matchLabels:
      app: LABEL_NAME
  template:
    metadata:
      labels:
        app: LABEL_NAME
    spec:
      containers:
      - name: CONTAINER_NAME
        image: IMAGE_NAME
        resources:
          requests:
            memory: MEMORY
            cpu: CPU
          limits:
            memory: MEMORY_LIMIT
            cpu: CPU_LIMIT
        ports:
          - name: PORT_NAME
            containerPort: CONTAINER_PORT', 'DEPLOYMENT');
INSERT INTO public.infrastructure_template (id, content, kind) VALUES (1, 'apiVersion: autoscaling/v2beta2
kind: HorizontalPodAutoscaler
metadata:
  name: COMPONENT_NAME
spec:
  scaleTargetRef:
    apiVersion: apps/v1
    kind: Deployment
    name: DEPLOYMENT_NAME
  minReplicas: MIN_REPLICAS
  maxReplicas: MAX_REPLICAS
  metrics:
  - type: TYPE
    resource:
      name: CPU
      target:
        type: UTIL_TIPE
        averageUtilization: AVG_UTIL', 'HPA');
INSERT INTO public.infrastructure_template (id, content, kind) VALUES (3, 'apiVersion: networking.k8s.io/v1
kind: Ingress
metadata:
  name: COMPONENT_NAME
spec:
  rules:
  - host: HOST
    http:
      paths:
      - path: PATH
        pathType: PATH_TYPE
        backend:
          service:
            name: SERVICE_NAME
            port:
              number: PORT', 'INGRESS');
INSERT INTO public.infrastructure_template (id, content, kind) VALUES (5, 'FROM IMAGE_URL

COPY PROV_PATH/SERVICE_NAME*.EXTENSION /SERVICE_NAME.EXTENSION

ENTRYPOINT [ENTRY_POINTS]

', 'DOCKERFILE');

INSERT INTO public.infrastructure_template (id, content, kind) VALUES (6, 'apiVersion: v1
kind: ConfigMap
metadata:
  name: cfgName
data: cfgData','CONFIGMAP');
