# camel-poc
---

In order to build camel-poc project run following commands under root folder:
```bash
./mvnw clean install
```

After the build pass run docker compose also under root folder:
```bash
docker-compose up
```

---
After that application is up and running. In order to test the application run:
1. Soap example
   http://localhost:8080/camel/hello/soap
2. Rest example
   http://localhost:8080/camel/hello/rest

---
In order to change the apps ports you need to do the folowing:

soap-service
   * goto soap-service/src/resources/application.properties
   * change server.port property
   * goto root folder/docker-compose.yml
   * find soap-service block and change port, same as in application property

rest-service
   * goto rest-service/src/resources/application.properties
   * change server.port property
   * goto root folder/docker-compose.yml
   * find rest-service block and change port, same as in application property

camel-hub-service
   * goto camel-hub-service/src/resources/application.properties
   * change server.port property
   * goto root folder/docker-compose.yml
   * find camel-hub-service block and change port, same as in application property

In docker-compose.yml there is defined a local network with dedicated ip addresses.
If you change rest-service or soap-service ip address please note that you need to change
the urls under camel-hub-service.
   * goto camel-hub-service/src/resources/application.properties
   * change soap.service.url and/or rest.service.url property 