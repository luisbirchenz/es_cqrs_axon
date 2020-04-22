# Even sourcing & CQRS by going through Axon stuff
By continuing the work started here [Even Sourcing Demo](https://github.com/luisbirchenz/even_sourcing), I added CQRS stuff. Just to clarify a little bit, CQRS - Command Query Responsibility Segregation - is an architectural style in which we have two different subsystems, one responsible for commands, and another responsible for queries. 

* By command we understand a request by the user or another system, in order to take care of a business operation, to transition the system from one state to another. 
* The query subsystem is usually much simpler than the other.The execution of the query simply consists of exporting the data from the DB as DTOs and serializing them in a suitable format.

Each of these subsystems has a different design, information model and persistence mechanism, optimized for the tasks that must be faced. Both subsystems can evolve separately, maintenance and deployment can be differentiated. 

In order to show how CQRS works I created a separated entity to take care of the query. And at the same time I created a repository taking advantage of spring data jpa. Additionally, I created a class responsable for managing the entity so every time an event ocurr for a particular aggregate the event is stored and in this example the query on the entity is stored as well.

# Project Settings

I used the same stack of dependencies:

Spring boot
Spring data jpa
H2 database
Swagger 2
Axon for spring

# Test application
I'm going to explain what was added to the project. The other tests can be performed by following the previus guide in [Even Sourcing Demo](https://github.com/luisbirchenz/even_sourcing).

###### Getting appointment by ID

By considering the Id: 37828176-17d3-4bae-a868-d33ed5169ed4

```
curl -X GET "http://localhost:8080/appointment/37828176-17d3-4bae-a868-d33ed5169ed4" -H "accept: */*"
```
It will get the information related to the entity appointment defined for the query model.

The result can be verified in the APPOINTMENT_ENTITY table.

Remember that the event store can be checked by running this query:
SELECT PAYLOAD_TYPE , AGGREGATE_IDENTIFIER, SEQUENCE_NUMBER , PAYLOAD FROM DOMAIN_EVENT_ENTRY
