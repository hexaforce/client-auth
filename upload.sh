#!/bin/bash -ex
SCRIPT_DIR=$(cd $(dirname $0); pwd)

mvn clean install

scp -i server.pem target/dummy-0.0.1-SNAPSHOT.jar ec2-user@111.100.100.111:

# ssh -i Squid.pem ec2-user@111.100.100.111

# [ec2-user@ip-111-100-100-111 ~]$ java -jar dummy-0.0.1-SNAPSHOT.jar
