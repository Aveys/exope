# Readme
Exercice algorithmique réalisé :
* en Kotlin
* avec Gradle
* JUnit 5 pour les tests
* avec IntelliJ IDEA

## Jar
1. compilation du jar avec `gradlew jar`
2. le jar est compilé dans /build/libs
> Usage : 
>  exope-fat-1.0-SNAPSHOT.jar -f <javanais> : traduction de javanais en français
>
>  exope-fat-1.0-SNAPSHOT.jar -j <français> : traduction de français en javanais

## Execution depuis gradle
`gradlew run --args="-f <javanais>"`

## Execution des tests
`gradlew test`