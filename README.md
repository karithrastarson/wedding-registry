# wedding-registry

Web App for wedding registry. Used to track the items, and reserve for purchase.

## System Requirements
* Docker
* Java12
* Maven

## How to run this service
1. Navigate to project root
2. run `docker compose up`
3. run ``mvn spring-boot:run``

4. Run GUI. See instructions [here](webapp/README.md).

## Endpoints

1. Run service, according to the instructions above.
2. Navigate to [http://localhost:8484/swagger-ui.html](http://localhost:8484/swagger-ui.html)
to see available endpoints and their description.

## Preliminary user stories

* As a bride/groom I would like to add item to the registry
* As a bride/groom I would like to add multiple units of item to registry
* As a bride/groom I would like to remove items from the registry
* As a guest I would like to see what items are available, and how many.
* As a guest I would like to reserve an item for me to give the bride and groom.
* As a guest I would like to cancel my reserved item.
