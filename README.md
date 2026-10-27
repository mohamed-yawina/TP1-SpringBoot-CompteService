
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
