# SpringKafkaConsumer

## Description

SpringKafkaConsumer est une application Spring Boot conçue pour consommer des données de capteurs simulées via Apache Kafka. L'application désérialise des objets `SensorData` depuis JSON, les traite, et peut potentiellement les transmettre à d'autres systèmes ou les afficher via une interface WebSocket. Ce service fait partie d'une solution IoT plus large, travaillant en tandem avec SpringKafkaMockData.

## Technologies Utilisées

- Java 17
- Spring Boot
- Apache Kafka
- WebSocket
- Maven
- Docker
- Kubernetes
- Helm

## Image Docker

L'image Docker de ce projet est disponible sur Docker Hub :

```bash
doomthedocker/springkafkaconsumer
```

Pour récupérer l'image :

```bash
docker pull doomthedocker/springkafkaconsumer:latest
```

## Configuration

L'application utilise des profils Spring pour gérer différents environnements :

- `local` : pour le développement local
- `kubernetes` : pour le déploiement dans un cluster Kubernetes

### Configuration Locale

Pour le développement local, assurez-vous d'avoir Kafka en cours d'exécution sur votre machine. Les paramètres de connexion par défaut sont configurés dans `application.properties`.

### Configuration Kubernetes

La configuration pour l'environnement Kubernetes est gérée via un ConfigMap Kubernetes, défini dans les fichiers de déploiement.

## Exécution du Projet

### Localement

1. Clonez le dépôt :
   ```
   git clone https://github.com/dominicpotvin/springkafkaconsumer.git
   ```
2. Naviguez vers le répertoire du projet :
   ```
   cd springkafkaconsumer
   ```
3. Exécutez le projet avec Maven :
   ```
   mvn spring-boot:run -Dspring-boot.run.profiles=local
   ```

### Avec Docker

1. Récupérez l'image :
   ```
   docker pull doomthedocker/springkafkaconsumer:latest
   ```
2. Exécutez le conteneur :
   ```
   docker run -p 8088:8088 -e SPRING_PROFILES_ACTIVE=local doomthedocker/springkafkaconsumer:latest
   ```

### Dans Kubernetes

1. Assurez-vous que le namespace "develop" existe :
   ```
   kubectl create namespace develop
   ```

2. Appliquez les fichiers de déploiement :
   ```
   kubectl apply -f kubernetes/deployment.yaml -n develop
   kubectl apply -f kubernetes/service.yaml -n develop
   ```

3. Pour mettre à jour le déploiement :
   ```
   kubectl rollout restart deployment springkafkaconsumer -n develop
   ```

## Vérification du Déploiement

Pour vérifier que l'application est correctement déployée dans le namespace "develop" :

```bash
kubectl get pods -n develop
kubectl get services -n develop
```

## Accès à l'Application

L'application consomme des données Kafka et peut les exposer via WebSocket. Dans un environnement de production, vous pouvez accéder à ces données via une interface web ou d'autres services connectés.

## Surveillance et Logs

Pour surveiller les logs de l'application dans Kubernetes :

```bash
kubectl logs -f deployment/springkafkaconsumer -n develop
```

## Validation de la Consommation Kafka

Pour vérifier que les données sont correctement consommées depuis Kafka :

1. Accédez aux logs de l'application comme indiqué ci-dessus.
2. Vérifiez les messages indiquant la réception et le traitement des données de capteurs.

## Versions de l'Image Docker

L'image est taguée avec deux identifiants :
- `latest` : toujours la version la plus récente
- Version spécifique (ex: `0.0.1-SNAPSHOT`) : correspond à la version du projet

Pour utiliser une version spécifique :
```bash
docker pull doomthedocker/springkafkaconsumer:0.0.1-SNAPSHOT
```

## Déploiement vers Docker Hub

Le script `deploy-to-dockerhub.sh` automatise le processus de build et de push vers Docker Hub :

1. Il extrait la version du projet depuis le pom.xml
2. Construit le projet avec Maven (en sautant les tests)
3. Crée une image Docker avec les tags `latest` et la version spécifique
4. Pousse ces deux versions vers Docker Hub

Pour l'utiliser :
1. Assurez-vous d'être connecté à Docker Hub : `docker login`
2. Naviguez vers le dossier `bashcommands`
3. Rendez le script exécutable : `chmod +x deploy-to-dockerhub.sh`
4. Exécutez le script : `./deploy-to-dockerhub.sh`

## Contribution

Les contributions sont les bienvenues. Veuillez ouvrir une issue ou une pull request pour toute contribution ou suggestion d'amélioration.

## Licence

Ce projet est sous licence MIT. Voir le fichier `LICENSE` pour plus de détails.