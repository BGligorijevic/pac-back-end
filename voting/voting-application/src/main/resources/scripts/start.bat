@echo off
START cmd.exe /k "cd ../back-end && java -Xdebug -Xrunjdwp:transport=dt_socket,server=y,suspend=n,address=8888 -javaagent:voting-application-1.0-SNAPSHOT.jar -jar voting-application-1.0-SNAPSHOT.jar --voting.dev.mode=true --voting.app.secret.key=sample_dev_key"