FROM maven:3.6-jdk-8-alpine
RUN apk add git
RUN git clone --depth 1 --single-branch --branch master https://github.com/pontusvision/pontus-natty.git
RUN cd pontus-natty && \
    mvn clean install package -DskipTests
