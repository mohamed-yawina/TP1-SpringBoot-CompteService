
# TP1 — Développement d'une application Spring Boot

## Description

Ce TP consiste à développer une application de gestion de comptes bancaires avec Spring Boot.

L'objectif est de découvrir la création d'API REST, la persistance des données avec Spring Data JPA et l'utilisation de GraphQL pour interroger et manipuler les données.

## Technologies utilisées

- Java 17
- Spring Boot
- Spring Web
- Spring Data JPA
- Spring GraphQL
- H2 Database
- Swagger / OpenAPI
- Maven
- IntelliJ IDEA

## Architecture

```text
Client HTTP / GraphQL
        |
        v
Spring Boot Application
        |
        +-- REST Controllers
        |
        +-- GraphQL Controllers
        |
        +-- Repositories (JPA)
        |
        +-- Entities
        |
        v
    H2 Database
```

## Fonctionnalités

- Création de comptes bancaires
- Consultation de la liste des comptes
- Recherche d'un compte par identifiant
- Modification des informations d'un compte
- Suppression d'un compte
- Exposition des données via REST
- Interrogation des données via GraphQL
- Documentation et test des API avec Swagger
- Persistance avec Spring Data JPA et H2

## Structure du projet

```text
src/
└── main/
    ├── java/
    │   └── .../
    │       ├── entities/
    │       ├── repositories/
    │       ├── web/
    │       └── Application.java
    └── resources/
        ├── application.properties
        └── graphql/
            └── schema.graphqls
```

La structure exacte peut varier selon l'organisation du projet.

## Installation et exécution

### Prérequis

- JDK 17
- Maven ou Maven Wrapper
- IntelliJ IDEA

### Démarrage

Cloner le dépôt :

```bash
git clone <URL_DU_DEPOT_TP1>
```

Accéder au projet :

```bash
cd <DOSSIER_DU_TP1>
```

Lancer l'application sous Windows :

```powershell
.\mvnw.cmd spring-boot:run
```

## Test des API

### REST API

Exemples d'opérations :

| Méthode | Fonctionnalité |
|---------|----------------|
| GET | Consulter les comptes |
| GET | Consulter un compte par ID |
| POST | Ajouter un compte |
| PUT | Modifier un compte |
| DELETE | Supprimer un compte |

Les chemins exacts des endpoints dépendent des contrôleurs du projet.

### GraphQL

GraphQL permet de sélectionner les champs souhaités et d'exécuter des requêtes ou des mutations.

Exemple de requête :

```graphql
query {
  allAccounts {
    id
    balance
    currency
  }
}
```

Cet exemple suppose que le schéma expose une requête `allAccounts`.

## Objectifs pédagogiques

- Comprendre l'architecture Spring Boot
- Développer des API REST
- Utiliser Spring Data JPA
- Manipuler une base H2
- Découvrir GraphQL
- Tester et documenter les API

## Auteur

**Mohamed Yawina**

Projet réalisé dans le cadre des travaux pratiques de développement Java et Spring Boot.


\## Démonstration et résultats



Cette section présente les captures d'écran des fonctionnalités développées et testées dans le cadre du TP1 Spring Boot.



\### 1. Documentation REST avec Swagger



Visualisation des endpoints REST permettant de consulter, créer, modifier et supprimer des comptes bancaires.



!\[Swagger UI](docs/screenshots/01-swagger.png)



\### 2. Test de l'API REST



Exécution d'une requête REST pour consulter les comptes bancaires et vérifier la réponse de l'API.



!\[API REST](docs/screenshots/02-rest-api.png)



\### 3. Base de données H2



Consultation de la base H2 utilisée par Spring Boot pour stocker les comptes bancaires.



!\[H2 Database](docs/screenshots/03-h2-database.png)



\### 4. Test de GraphQL avec Postman



Exécution d'une requête GraphQL `allComptes` pour récupérer les identifiants, soldes et types des comptes bancaires.



!\[GraphQL avec Postman](docs/screenshots/04-graphql-result.png)



\### Bilan



Les démonstrations présentent les fonctionnalités principales du TP : API REST, documentation Swagger, persistance avec H2 et interrogation des données avec GraphQL.

