FROM fabric8/java-jboss-openjdk8-jdk:1.5.1
ENV JAVA_APP_JAR ms-ssi-1.0.0.jar
ADD target/
ENV AB_ENABLED off
ENV AB_JOLOKIA_AUTH_OPENSHIFT true
ENV JAVA_OPTIONS -Xmx256m -Djava.security.egd=file:///dev/./urandom

ADD target/ms-ssi-1.0.0.jar /deployments/

EXPOSE 8005