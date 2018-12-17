# Databáze
Vytvořit datbázi 'ristaurace' v postgresu.
Databáze musí běžet na localhostu port 5432
Pokud by byla potřeba změna databáze, lze to provést v souboru application.properties, ale následně je potřeba provést `mvn package` pro vygenerování nového artefaktu.

# Backend
Je nutná Java 1.8 (11 nefuguje)
Extrahovat zip target a v terminálu spustit: `java -jar target ristaurace-1.0-SNAPSHOT.jar`

# Frontend
Otevřít v prohlížeči adresu: `http://localhost:8080/index.html`
