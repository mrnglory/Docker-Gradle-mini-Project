# JAVA Connector Application
FROM openjdk:8

# Install Packages
RUN apt-get update
RUN apt-get -y install gradle

# Deploy Application
COPY . /usr/src/connector
WORKDIR /usr/src/connector

