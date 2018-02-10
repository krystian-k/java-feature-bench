FROM anapsix/alpine-java:latest

COPY build/libs/java-feature-bench-jmh.jar .

ENTRYPOINT ["java", "-jar", "java-feature-bench-jmh.jar", "-wi", "10",  "-i", "10"]