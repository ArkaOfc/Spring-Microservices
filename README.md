# Spring-Microservices
A focused exploration of transitioning monolithic applications to microservices architectures.

TO RUN ANY PROJECT
$mvn clean package
$docker build -f docker/Dockerfile --tag [layered-monolith/clean-monolith/modular-monolith]:0.0.1-SNAPSHOT .      
$docker run --name [layered-monolith/clean-monolith/modular-monolith] -p 8080:8080 [layered-monolith/clean-monolith/modular-monolith]:0.0.1-SNAPSHOT
 
