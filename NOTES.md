# TP 01 — Démarrer Bestioles 


### Étape 2 — Dépendances du pom


spring-boot-starter-actuator 
spring-boot-starter-webmvc 
spring-boot-devtools 
spring-boot-starter-actuator-test 
spring-boot-starter-webmvc-test 

Nombre de dépendances avec une balise : 0 sur 5.

Les versions des autres sont héritées du parent spring-boot-starter-parent (4.1.2)

### Étape 4 — Le test généré

Résultat (./mvnw verify) :
```
[INFO] Tests run: 1, Failures: 0, Errors: 0, Skipped: 0
[INFO] BUILD SUCCESS

Étape 5 — Démarrage

Le démarrage sur 8080 a réussi du premier coup pas de bloc donc l'application tourne sur le port 8080.

```
2026-11-17T13:53:00.694+01:00  INFO 22364 --- [bestioles] [  restartedMain] o.sebsy.bestioles.BestiolesApplication   : Started BestiolesApplication in 3.133 seconds (process running for 3.776)
```

Étape 6 — Sonde de santé

```
$ curl.exe localhost:8080/actuator/health
{"groups":["liveness","readiness"],"status":"UP"}
```

### Étape 8 — Trois appels à /hello

1. `curl.exe "localhost:8080/hello?name=Lea"`
Obtenu : Bonjour, Lea !

2. `curl.exe localhost:8080/hello`
Obtenu : Bonjour, monde !

3. `curl.exe "localhost:8080/hello?name="`
Obtenu : Bonjour, monde !

