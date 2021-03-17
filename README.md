# Webflux-Storage

An API for storing characters from all sorts of media. Made for the DIO Inter Java Dev Bootcamp.

to run it, download the local version of DynamoDB and with a command prompt opened on the download directory, do:

java -Djava.library.path=./DynamoDBLocal_lib -jar DynamoDBLocal.jar -sharedDb
 
 aws dynamodb list-tables --endpoint-url http://localhost:8000
 
 Swagger documentation is available at :http://localhost:8080/swagger-ui-reactive-api.html
 
 Postman documentation is available at : https://documenter.getpostman.com/view/14969236/Tz5s5xNu
