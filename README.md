# Manipulation du HDFS avec l'API Java

Ce projet démontre comment interagir avec le **Hadoop Distributed File System (HDFS)** en utilisant l'API Java. Il inclut des opérations de base comme **l'écriture, la lecture et l'affichage de fichiers dans HDFS**.

## 📋 Prérequis

Avant de commencer, assurez-vous d'avoir installé les éléments suivants :

- **Java 8** (JDK 1.8)
- **Maven 3.6+** (pour la gestion des dépendances et la compilation)
- **Hadoop 3.x** (cluster local ou distant configuré)
- **Docker** (pour exécuter Hadoop en conteneurs)

## 🚀 Installation et configuration

### 1. Déploiement de Hadoop avec Docker

Exécutez la commande suivante pour démarrer les conteneurs Hadoop :

```sh
docker-compose up -d
```

Vérifiez ensuite que les conteneurs sont bien lancés avec :

```sh
docker ps
```

Vous devriez voir les conteneurs suivants en exécution :

- `hdfs-namenode-1`
- `hdfs-datanode-1`
- `hdfs-nodemanager-1`
- `hdfs-resourcemanager-1`

Deux dossiers importants seront créés automatiquement :

- `jars` : pour stocker les fichiers JAR du projet
- `hadoop-data` : contenant les fichiers HDFS

### 2. Accéder au conteneur HDFS Namenode

Pour exécuter des commandes HDFS, entrez dans le conteneur Namenode :

```sh
docker exec -it hdfs-namenode-1 bash
```

## 🛠 Utilisation

Ce projet contient deux fichiers principaux :

- `App.java` : permet d'écrire dans un fichier HDFS
- `App2.java` : permet d'afficher le contenu d'un fichier HDFS

### 1. Compilation et déploiement du projet

Si vous avez modifié `App.java`, exécutez :

```sh
mvn clean
```

Puis compilez et installez le projet avec :

```sh
mvn install
```

ou

```sh
mvn compile
```
lorsqu'on démarre la commande de mvn compile on aura un dossier target ou il contient le fichier .jar

Le fichier JAR généré doit être placé dans le dossier `jars`.

![Résultat](src/main/resources/images/img.png)

### 2. Configuration de `pom.xml`

Lors de l'exécution, vous devez parfois alterner entre `App.java` et `App2.java` en modifiant le `pom.xml` :

```xml
<plugin>
    <groupId>org.apache.maven.plugins</groupId>
    <artifactId>maven-jar-plugin</artifactId>
    <configuration>
        <archive>
            <manifest>
                <addClasspath>true</addClasspath>
                <mainClass>App2</mainClass> <!-- Modifier avec App si besoin -->
            </manifest>
        </archive>
    </configuration>
</plugin>
```

### 3. Visualisation des fichiers HDFS

Pour voir les fichiers stockés dans HDFS, accédez à l'interface Web Hadoop :

[http://localhost:9870/explorer.html#/](http://localhost:9870/explorer.html#/)

## 📎 Ressources

Pour plus d'informations, consultez le dépôt GitHub : [Manipulation-du-HDFS-avec-l-API-Java](https://github.com/Nouhaila1937/Manipulation-du-HDFS-avec-l-API-Java/)
