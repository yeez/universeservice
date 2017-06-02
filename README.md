# universeservice
upgrade universe event micro-service

# General Info
This microservice is developed using Java SpringBoot framework. The microservice uses in memory h2database
and connects to it through JPA. Sample Data to test rest endpoints must be imported using the events/import
POST call.   



# Steps to run the application
1. Clone the repo from git repository: 
2. cd into the repo git root directory
3. Run: mvn clean package
4. To run the springboot application: java -jar target/universeservice-0.0.1-SNAPSHOT.jar
5. You can perform the REST test calls below through your fav. REST Client i.e Chrome RESTlet Clint, or postman




# Testing that the end point is reachable
After deploying the app you can test that the service is running by calling the GET end point:

http://localhost:8080/v1/ping



# Importing Sample data into in memory db
You can import sample data into the in memory-db by calling the import POST end point using data from upgrade_sample_json.txt:

http://localhost:8080/v1/events/import

P.S dont forget to use sample data json from universeservice/src/main/resources/upgrade_sample_json.txt



# To return closest 100 Planets
localhost:8080/v1/events/nearest100



# Perform Search Operation
You can perform search operations on Event objects by calling the POST end point:
localhost:8080/v1/events/findPlanets

POST the searchParameter object with the following format to specify your search parameter:

ex1 search by Date Range searchParameter JSON: {
	"eventNameParameter":null,
    "eventTypeParameter":null,
    "upperLimitEventDistancParameter":null,
    "lowerLimitEventDistancParameter":null,
    "upperLimitEventMassParameter":null,
    "lowerLimitEventMassParameter":null,
  	"upperLimitEventDiscoveryDateParameter":"2017-04-20",
  	"lowerLimitEventDiscoveryDateParameter":"2017-01-01"
}

ex2 search by EventName searchParameter JSON: {
	"eventNameParameter":"Event Name 6",
    "eventTypeParameter":null,
    "upperLimitEventDistancParameter":null,
    "lowerLimitEventDistancParameter":null,
    "upperLimitEventMassParameter":null,
    "lowerLimitEventMassParameter":null,
  	"upperLimitEventDiscoveryDateParameter":null,
  	"lowerLimitEventDiscoveryDateParameter":null
}
