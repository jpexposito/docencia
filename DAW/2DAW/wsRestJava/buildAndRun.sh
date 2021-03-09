#!/bin/sh
mvn clean package && docker build -t es.iespuertolacruz.jpexposito/wsRestJava .
docker rm -f wsRestJava || true && docker run -d -p 9080:9080 -p 9443:9443 --name wsRestJava es.iespuertolacruz.jpexposito/wsRestJava