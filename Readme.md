# JAVA

## Ressources

* [https://dev.java/learn/](https://dev.java/learn/)

## Installation

Une fois java téléchargé et installé. Vérifier son installation à l'aide des ligne de commandes suivantes :

```sh
java -version
```

Retourne

```sh
openjdk version "25.0.2" 2026-01-20 LTS
OpenJDK Runtime Environment Temurin-25.0.2+10 (build 25.0.2+10-LTS)
OpenJDK 64-Bit Server VM Temurin-25.0.2+10 (build 25.0.2+10-LTS, mixed mode, sharing)
```

```sh
echo %JAVA_HOME%
```

Retourne

```sh
C:\Program Files\Eclipse Adoptium\jdk-25.0.2.10-hotspot\
```

Dans le cas contraire, vous devez :

* Ajouter une variable d'environnement pointant sur le repertoire java, exemple :

> setx JAVA_HOME "D:\jdk\jdk-25" /M

* Ajouter une variable d'environnement PATH sur le bin java, exemple :

> setx PATH "%JAVA_HOME%\bin;%PATH%" /M

