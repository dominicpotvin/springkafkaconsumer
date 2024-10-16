#!/bin/bash

# Fichier: deploy-to-dockerhub.sh

# Naviguer vers le répertoire contenant le pom.xml
cd ..

# Définir la version
VERSION=$(mvn help:evaluate -Dexpression=project.version -q -DforceStdout)

# Construire le projet sans exécuter les tests
mvn clean package -DskipTests

# Retourner dans le dossier bashcommands
cd bashcommands

# Construire l'image Docker
docker build -t doomthedocker/springkafkaconsumer:latest ..
docker tag doomthedocker/springkafkaconsumer:latest doomthedocker/springkafkaconsumer:$VERSION

# Pousser les images
docker push doomthedocker/springkafkaconsumer:latest
docker push doomthedocker/springkafkaconsumer:$VERSION

echo "Image poussée vers Docker Hub : doomthedocker/springkafkaconsumer:$VERSION"
