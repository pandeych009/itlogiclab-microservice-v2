#! /bin/bash -e

version=$1
echo 'Image will be create with version '$version

cd '/Users/pandeych445/dev/github/itlogiclab-restaurant-microservices'
source ~/.bash_profile 
mvn clean install 

docker build -f itlogiclab-restaurant-infrastructure/docker-files/Order-Dockerfile -t pandeych009/itlogiclab-order-microservice:$version .
docker push pandeych009/itlogiclab-order-microservice:${version}
echo "Docker build completed for pandeych009/itlogiclab-order-microservice project: build Image: pandeych009/itlogiclab-order-microservice:"$version