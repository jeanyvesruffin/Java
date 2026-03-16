# Java

## Ressources

- <https://dev.java/learn/>

## Installation

Après avoir téléchargé et installé Java, vérifiez l'installation avec les commandes suivantes (Invite de commandes ou PowerShell) :

```bat
java -version
```

La sortie attendue ressemble à :

```text
openjdk version "25.0.2" 2026-01-20 LTS
OpenJDK Runtime Environment Temurin-25.0.2+10 (build 25.0.2+10-LTS)
OpenJDK 64-Bit Server VM Temurin-25.0.2+10 (build 25.0.2+10-LTS, mixed mode, sharing)
```

Vérifiez ensuite la variable d'environnement `JAVA_HOME` :

```bat
echo %JAVA_HOME%
```

La commande doit afficher le chemin du JDK, par exemple :

```text
C:\Program Files\Eclipse Adoptium\jdk-25.0.2.10-hotspot\
```

Si la variable n'est pas définie, ajoutez-la (exécutez l'invite de commandes en tant qu'administrateur) :

```bat
setx JAVA_HOME "D:\jdk\jdk-25" /M
setx PATH "%JAVA_HOME%\bin;%PATH%" /M
```

Après avoir utilisé `setx`, fermez puis rouvrez l'invite de commandes (ou redémarrez votre session) pour que les modifications prennent effet.

## Compilation

Les fichiers java sont des fichiers avec l'extension .java. Voir l'exemple Exemples\MyFirstApp.java.
Afin de compiler les fichiers pour produire des fichiers binaires il faut executer la commande java. Les fichiers compilé sont alors généré avec l'extension .class.
Exmeple :

```bat
java MyFirstApp.java
```

Retournera dans le terminal

```bat
Hello, World!
```

## Plusieurs clase dans le même fichiers

Plusieurs classes peuvent être définies dans le même fichier source si nécessaire à des fins d'encapsulation. Voir l'exmeple Exemples\MultipleClassesInSameFile.java.

## Objets, classes, interfaces, packages et héritage

[Objets, classes, interfaces, packages et héritage](https://dev.java/learn/oop/).

[liste complète des packages, interfaces, classes, champs et méthodes fournis par la plateforme Java SE](https://docs.oracle.com/en/java/javase/25/docs/api/index.html).

## Notions de base du langage Java

[Création et dénomination des variables](https://dev.java/learn/language-basics/variables/)

## Tableaux

[Tableaux](https://dev.java/learn/language-basics/arrays/)

Exemple : Exemples\MultiDimArrayDemo.java

## Utilisation de l'identificateur de type Var

[Var](https://dev.java/learn/language-basics/using-var/)

## Utilisation des opérateurs dans vos programmes

[Opérateurs](https://dev.java/learn/language-basics/using-operators/)

## Expressions, instructions et blocs

[Expressions, instructions et blocs](https://dev.java/learn/language-basics/expressions-statements-blocks/)

## Les boucles

[Les boucles](https://dev.java/learn/language-basics/controlling-flow/)

## Switch case

[Switch case](https://dev.java/learn/language-basics/switch-statement/)