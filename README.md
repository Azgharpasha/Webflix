The backend branch has all the backend code that involves the technology Java8 and springboot .It has total 7 child microservices and 1 parent microservice .

Technlogies Used : 1. Java 
                   2. SpringBoot
                   3. maven
                   4. swagger(If not find . then removed due to compatible issues)
                    


WebFlix - Parent Micoservice 
child Microservices:
-> ApiGateway : This microservice responsible for single gateway endpoint . It contains ".yml" files inwhich all the endpoints are mentioned . Api gateay runs on port 8085.
-> Eureka : This mircoservcie is responsible for getting the mircoservices at one place like on same server.Eureka port runs on 8761
-> config server : this mircoservice to used to store the database configuartion at another place . so that data could be secured . as we have used RDS to config server has been commented out
-> UserProfile : This microservice responsible for user registartion . It contains all the crud operations that can be performed on the user data . It uses the MYSQL storage .
                In the above project it connected with the AWS cloud RDS instance . that's why it has RDS configuartion. User email and password are stored and also they are passed 
                to other microservcies using "Kafka".
-> authService : This service is responsible for token generation and usng the token wecan authenticate the other microservices.It gets the email and password from the user by using kafka
                 It stoqres in its database which is MYSQL or RDS
-> MovielIst : This service provides the data from thirdparty API . It doesn't require any database .
-> WishList : This service is responsible for adding the movies in the user favlist and perform thr crud operations on the database . It uses MYSQL or RDS .
              It gets the user email from user using kafka.
