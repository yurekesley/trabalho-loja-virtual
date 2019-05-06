FROM adoptopenjdk/openjdk11:alpine as build
WORKDIR /workspace/


COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .
COPY app-ear app-ear
COPY app-ejb app-ejb
COPY app-web app-web
# COPY src src

RUN ./mvnw install -DskipTests
# RUN mkdir -p target/dependency && (cd target/dependency; jar -xf ../*.war)

FROM michelav/wildfly-alpine

WORKDIR /opt/wildfly/standalone/deployments/app-web/

ARG DEPENDENCY=/workspace

COPY --from=build ${DEPENDENCY}/ear/target/ear-1.0.ear .

CMD ["/opt/wildfly/bin/standalone.sh", "-b", "0.0.0.0", "-bmanagement", "0.0.0.0"]
