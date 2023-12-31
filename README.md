# Mise en oeuvre d'une architecture Micro-Services E-Commerce

Création d'une application basée sur une architecture micro-service E-commerce qui
permet de gérer les factures contenant des produits et appartenant à un client.

## Architecture:
![sc](./captures/archi.PNG)

##### Lors de la creation de notre projet ,on aurra besoin d'installer les dependances suivantes:
![sc](./captures/0.PNG)

Travail à faire :

1. Créer le micro-service customer-service qui permet de gérer 
les clients  
##### L'entite JPA Customer
![sc](./captures/1.PNG)

#### Creation d'une projection
les projections servent à personnaliser les données extraites de la
base de donnée sans extraire l'ensemble complet des attributs de
l'entité ce qui permet d'améliorer la performances.

![sc](./captures/2.PNG)

#### L'interface JPA Repository basee sur Spring Data CustomerRepository
![sc](./captures/3.PNG)

#### Insertion de quelques customers
![sc](./captures/4.PNG)

#### Configuration le fichier propertise
![sc](./captures/5.PNG)

#### Consulter la db

![sc](./captures/6.PNG)

#### Consulter les listes des customers avec la projection

![sc](./captures/7.PNG)

2. Créer le micro-service inventory-service qui permet de gérer 
les produits
##### L'entite JPA Customer
![sc](./captures/8.PNG)

#### L'interface JPA Repository basee sur Spring Data ProductRepository
![sc](./captures/9.PNG)

#### Insertion de quelques products
![sc](./captures/10.PNG)

#### Configuration le fichier propertise
![sc](./captures/11.PNG)

#### Consulter la db
![sc](./captures/12.PNG)

### Consulter les listes des products
![sc](./captures/13.PNG)

3. Créer la Gateway Spring cloud Gateway
#### Ajouter les 3 dependancies:
 - Gateway : Provides a simple, yet effective way
to route to APIs and provide cross cutting
concerns to them such as security,
monitoring/metrics, and resiliency.
- Spring Boot Actuator : Supports built in (or
custom) endpoints that let you monitor and
manage your application - such as application
health, metrics, sessions, etc.
- Eureka Discovery Client : a REST based service
for locating services for the purpose of load
balancing and failover of middle-tier servers.

4. Configuration statique du système de routage
#### dans fichier application.yml

![sc](./captures/14.PNG)

#### resultat:

![sc](./captures/15.PNG)

![sc](./captures/16.PNG)

5. Créer l'annuaire Eureka Discrovery Service
#### Ajouter la dependance :
Eureka Server : spring-cloud- netflix Eureka Server.

![sc](./captures/17.PNG)

![sc](./captures/18.PNG)
6. Faire une configuration dynamique des routes de la gateway

#### Modification du fichier properties Customer-service, inventory-service et gateway:
spring.cloud.discovery.enabled=true

#### les services maintenant sont connectée:

![sc](./captures/19.PNG)

#### Configurer gatewayApplication:

![sc](./captures/20.PNG)

![sc](./captures/21.PNG)


7. Créer le service de facturation Billing-Service en utilisant Open Feign


8. Créer un client Web Angular (Clients, Produits, Factures)