# Java

## Sommaire

- [Ressources](#ressources)
- [Installation](#installation)
- [Compilation](#compilation)
- [Record](#record)
  - [Type de record d'identification](#type-de-record-didentification)
  - [Informations sur les composants](#informations-sur-les-composants)
  - [Accès aux champs record](#accès-aux-champs-record)

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
Exemple :

```bat
java MyFirstApp.java
```

Retournera dans le terminal

```bat
Hello, World!
```

## Record

Gestion des records.
Les records constituent un type particulier de classe, qui impose une stricte non-modification. Un record peut comporter un nombre quelconque de composants.
Ces deux éléments ont un impact sur l'API de réflexion.

### Type de record d'identification

Lors de l'introduction des records dans Java SE 16, plusieurs nouvelles méthodes et classes ont été ajoutées à l'API de réflexion. Parmi elles figure une méthode `Class` permettant de vérifier si une classe donnée est une classe de record `Class.isRecord()`.

Supposons que vous ayez le record suivant.

```java
public record Point(int x, int y) {
}
```

Vous pouvez observer cette méthode simple en action dans l'exemple suivant.

```java
Class<?> c1 = String.class;
Class<?> c2 = Point.class;
IO.println("Is " + c1.getSimpleName() + " a record class? " + c1.isRecord());
IO.println("Is " + c2.getSimpleName() + " a record class?  " + c2.isRecord());
```

L'exécution du code précédent affiche le résultat suivant.

Is String a record class? false
Is Point a record class?  true

Testez par vous même [Type de record d'identification](Records.java)

### Informations sur les composants

Les records définissent également un nouvel élément pour le langage Java : `record component`. Un composant de records est l’un des éléments déclarés lors de la déclaration d’un record. L’API de réflexion prend également en charge cette notion de composant de record.

L'API Reflection introduit une nouvelle classe `RecordComponent` qui modélise un composant d'un record. Cette classe comporte plusieurs méthodes.

| Component API | Comments |
| :--- | :--- |
| `getDeclaringRecord()` | Returns the class that declares this component |
| `getAccessor()` | Returns the method that models the accessor of this component |
| `getName()` | Returns the name of this component. |
| `getType()` | Returns the type of this component, as a Class object. |
| `getGenericType()` | Returns the generic type of this component, as a Type object. |

Voyons ces méthodes en action.

```java
record Point<T>(T x, T y) {}
Class<?> c = Point.class;

RecordComponent[] components = c.getRecordComponents();
Class<?> declaring = components[0].getDeclaringRecord();
IO.println("Declaring record: " + declaring);

String name = components[0].getName();
IO.println("name = " + name);

Method accessor = components[0].getAccessor();
IO.println("accessor = " + accessor);

Class<?> type = components[0].getType();
IO.println("type = " + type);

Type genericType = components[0].getGenericType();
IO.println("genericType = " + genericType);

String genericSignature = components[0].getGenericSignature();
IO.println("genericSignature = " + genericSignature);
```

L'exécution du code précédent affiche le résultat suivant. Testez par vous même [Component record](RecordComponentDemo.java)

```java
Declaring record: class org.devjava.Point
name = x
accessor = public int org.devjava.Point.x()
type = int
genericType = int
genericSignature = null
```

### Accès aux champs record

Notez qu'il n'existe aucune méthode dans cette RecordComponent classe permettant d'obtenir une référence à l'objet `Field` qui modélise le champ de ce composant.

Vous pouvez toujours obtenir une référence aux Field record à l'aide de cette Class.getDeclaredFields()méthode. Cependant, vous ne pouvez pas modifier le champ d'un record, même en appelant cette méthode Field.setAccessible(true). Ce comportement est spécifique aux records.

Prenons l'exemple suivant. Supposons que vous ayez le record suivant.

```java
public record Point(int x, int y) {}
```

Cet record comporte deux champs d'instance finaux x et y, que vous pouvez obtenir à l'aide de l'API de réflexion.

```java
Class<?> c = Point.class;
Field[] fields = c.getDeclaredFields();
for (Field field : fields) {
    IO.println("field = " + field);
}
```

L'exécution du code précédent affiche le résultat suivant. Testez par vous même [Field record](RecordField.java.java)

```java
field = private final int org.devjava.Point.x
field = private final int org.devjava.Point.y
```

Vous pouvez utiliser ces champs pour lire leurs valeurs, comme vous pouvez le constater dans l'exemple suivant.

```java
Point p = new Point(1, 2);
Field xField = p.getClass().getDeclaredField("x");
xField.setAccessible(true);
int x = (int)xField.get(p);
IO.println("x = " + x);
```

Notez que ce xchamp est privé, c'est pourquoi vous devez appeler xField.setAccessible(true).

L'exemple précédent affiche le résultat suivant. Testez par vous même [Read record](RecordReader.java)

```java
x = 1
```

Notez que vous auriez également pu utiliser cette méthode xField.getInt(p)pour obtenir la valeur de x, afin d'éviter le déballage automatique.

Mais vous ne pouvez pas utiliser ceci pour modifier la valeur de x. Vous pouvez essayer d'exécuter le code suivant.

```java
Point p = new Point(1, 2);
Field xField = p.getClass().getDeclaredField("x");
xField.setAccessible(true);
xField.setInt(p, 0);
IO.println("p = " + p);
```

Vous obtiendrez alors l'exception suivante IllegalAccessException.

```java
Exception in thread "main" java.lang.IllegalAccessException: Can not set final int field org.devjava.Point.x to (int)0
    at java.base/jdk.internal.reflect.FieldAccessorImpl.throwFinalFieldIllegalAccessException(FieldAccessorImpl.java:137)
    at java.base/jdk.internal.reflect.FieldAccessorImpl.throwFinalFieldIllegalAccessException(FieldAccessorImpl.java:161)
    at java.base/jdk.internal.reflect.MethodHandleIntegerFieldAccessorImpl.setInt(MethodHandleIntegerFieldAccessorImpl.java:160)
    at java.base/java.lang.reflect.Field.setInt(Field.java:1031)
    at org.devjava.Main.main(Main.java:25)
```

## Generics

### Pourquoi utiliser les générics

En résumé, les génériques permettent d'utiliser des types (classes et interfaces) comme paramètres lors de la définition de classes, d'interfaces et de méthodes. À l'instar des paramètres formels plus courants utilisés dans les déclarations de méthodes, les paramètres de type permettent de réutiliser le même code avec des entrées différentes. La différence réside dans le fait que les entrées des paramètres formels sont des valeurs, tandis que celles des paramètres de type sont des types.
Le code utilisant des génériques présente de nombreux avantages par rapport au code non générique:

- Contrôles de type plus stricts à la compilation. Un compilateur Java applique un contrôle de type strict au code générique et signale des erreurs si le code enfreint les règles de sécurité des types. Corriger les erreurs de compilation est plus simple que de corriger les erreurs d'exécution, qui peuvent être difficiles à détecter.
- Suppression des conversions de type. L'extrait de code suivant, sans génériques, nécessite une conversion de type.

```java
List list = new ArrayList();
list.add("hello");
String s = (String) list.get(0);
```

Une fois réécrit pour utiliser les génériques, le code ne nécessite plus de conversion de type :

```java
List<String> list = new ArrayList<String>();
list.add("hello");
String s = list.get(0);   // no cast
```

- Permettre aux programmeurs d'implémenter des algorithmes génériques. Grâce aux génériques, les programmeurs peuvent implémenter des algorithmes génériques qui fonctionnent sur des collections de types différents, sont personnalisables, sûrs au niveau des types et plus faciles à lire.

### Types génériques (Exemple)

Un type générique est une classe ou une interface générique paramétrée par des types. La classe `Box` suivante sera modifiée pour illustrer ce concept.

```java
public class Box {
    private Object object;

    public void set(Object object) { this.object = object; }
    public Object get() { return object; }
}
```

Puisque ses méthodes acceptent ou renvoient un Object `String` , vous pouvez lui passer n'importe quel type, à condition qu'il ne s'agisse pas d'un type primitif. Il est impossible de vérifier, à la compilation, comment la classe est utilisée. Une partie du code peut placer un `String Integer` dans la boîte et s'attendre à en obtenir des objets de type `IntegerString`, tandis qu'une autre partie du code peut lui passer par erreur un `String String`, ce qui entraînera une erreur d'exécution.

Une classe générique est définie selon le format suivant :

```java
class name<T1, T2, ..., Tn> { /* ... */ }
```

La section des paramètres de type, délimitée par des chevrons (<>), suit le nom de la classe. Elle spécifie les paramètres de type (également appelés `variables de type`) T1, T2, ..., et Tn.

Pour mettre à jour la classe Box afin qu'elle utilise les génériques, vous créez une déclaration de type générique en remplaçant le code «public class Box  » par «public class Box `<T>` ». Cela introduit la variable de type, T, qui peut être utilisée n'importe où dans la classe.

Avec cette modification, la Boxclasse devient :

```java
/**
 * Generic version of the Box class.
 * @param <T> the type of the value being boxed
 */
public class Box<T> {
    // T stands for "Type"
    private T t;

    public void set(T t) { this.t = t; }
    public T get() { return t; }
}
```

Comme vous pouvez le constater, toutes les occurrences de Object sont remplacées par T. Une variable de type peut être n'importe quel type non primitif que vous spécifiez : n'importe quel type de classe, n'importe quel type d'interface, n'importe quel type de tableau, ou même une autre variable de type.

Cette même technique peut être appliquée pour créer des interfaces génériques.

### Convention de nommage

| Syntaxe | Description |
| :--- | :--- |
| **E** | Élément (largement utilisé par le framework Java Collections) |
| **K** | Clé |
| **N** | Nombre |
| **T** | Type |
| **V** | Valeur |
| **S, U, V etc.** | 2e, 3e, 4e types |

### Invocation et instanciation d'un type générique

Pour faire référence à la classe générique `Box` depuis votre code, vous devez effectuer un appel de type générique, qui remplace T par une valeur concrète, telle que `Integer` :

```java
Box<Integer> integerBox;
```

On peut considérer un appel de type générique comme similaire à un appel de méthode ordinaire, mais au lieu de passer un argument à une méthode, on passe un argument de type — Integer dans ce cas — à la classe Box elle-même.

Pour instancier cette classe, utilisez le mot-clé `new`, comme d'habitude, mais placez-le `<Integer>` entre le nom de la classe et la parenthèse :

```java
Box<Integer> integerBox = new Box<Integer>();
```

### Diamond

Vous pouvez remplacer les arguments de type requis pour appeler le constructeur d'une classe générique par un ensemble vide d'arguments de type ( <>) à condition que le compilateur puisse déterminer, ou inférer, les arguments de type à partir du contexte. Cette paire de chevrons, <>, est communément appelée le `diamond`. Par exemple, vous pouvez créer une instance de Box `<Integer>` avec l'instruction suivante :

```java
Box<Integer> integerBox = new Box<>();
```

### Methode, parametre de type, héritage de generic

[Voir documentation officiel pour plus d'information](https://dev.java/learn/generics/intro/#why-using-generics)
