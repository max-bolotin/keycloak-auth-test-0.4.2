## Local startup

To start application run.

```
./mvnw -pl ${PROJECT_NAME}-application spring-boot:run
```

The service will be accessible on http://localhost:8080.

## Testing

### Unit Tests
All unit tests are bound to `test` goal. Just run:
```
./mvnw test
```
### Integration Tests
All integration tests are bound to `integration-test` goal. Just run:
```
./mvnw integration-test
```

### Full Test Suite
All tests are bound to `verify` goal. Just run:
```
./mvnw verify
```

## Docker
To build a docker image to docker daemon, run:
```
./mvnw install -DskipTests
```

## Pipeline

### Project Version
To extract current project version, run:
```
mvn help:evaluate -Dexpression=project.version -q -DforceStdout
```

To create a release version without `-SNAPSHOT`, run first:
```
mvn versions:set -DremoveSnapshot -DprocessAllModules
```

### Sonar Integration
Sonar will be executed on `verify` goal, if properties are set:
```
-Dsonar.projectKey=$(SONAR_PROJECT_KEY)
-Dsonar.organization=appsfactory
-Dsonar.host.url=https://sonarcloud.io
-Dsonar.login=$(SONAR_TOKEN)
```
Values for `SONAR_PROJECT_KEY` and `SONAR_TOKEN` must be supplied by pipeline environment 

### Docker Registry Integration
You can specify following variables to controll how a docker image is named, tages and pushed:

```
# Include registry prefix in FULL_IMAGE_NAME 
-Ddocker.image.to.name=$(FULL_IMAGE_NAME)
```
```
# Use this to override default (Maven Project version)
-Ddocker.image.to.version=$(VERSION)
```
```
# push directly to a docker registry instead of docker daemon
-Ddocker.build.jib.goal=build
```
```
# Auth for docker registry
-Djib.to.auth.username=$(REGISTRY_USER)
-Djib.to.auth.password=$(REGISTRY_PW)
```
```
# to add additional tags use
-Djib.to.tags=latest,$(VERSION)
```

For more details on authentication, see officicial Jib documentation: https://github.com/GoogleContainerTools/jib/tree/master/jib-maven-plugin#authentication-methods