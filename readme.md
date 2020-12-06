1.User Micro Service based on spring boot with 2 REST Endpoints 
    a) Get user details 
    b) Update user details (user can update any field)
   
All the user details should be fetched from in memory database (look at the JSON example below to design the tables in memory database Eg: H2, HSQLDB, Apache Derby)

Note:  Insert 5 to 10 users in memory database during the start-up to perform the above operations

2.	Implement the circuit breaker and transaction rollback for the database call.
3.	Intercept the incoming request to validate the user id is only numeric or else return appropriate validation error.
4.	Implement the entry/exit logging for the project.
5.	Write Unit tests

