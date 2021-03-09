@echo off
call mvn clean package
call docker build -t es.iespuertolacruz.jpexposito/wsRestJava .
call docker rm -f wsRestJava
call docker run -d -p 9080:9080 -p 9443:9443 --name wsRestJava es.iespuertolacruz.jpexposito/wsRestJava