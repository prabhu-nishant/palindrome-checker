# palindrome-checker

This application checks if the given string is palindrome or not using rest api

A palindrome is a word, number, phrase, or other sequence of
characters which reads the same backward as forward, such as madam or kayak

1. The application has been implemented using SpringBoot with Java 17 and gradle 7.6.
2. Please download the project from github and set it up in your IDE.
3. The app uses Redis cache for caching string along with palindrome flag. So you need to have a redis instance running on your server.

    Please follow below link to set up Redis instance locally
    https://redis.io/docs/getting-started/installation/

   Please ensure to start the redis server before you start the application.

4. The app uses in memory H2 database file store, and it would be created under C:/Users/<username>/test.mv

5. You can build project using gradle cli 

    Go to /<path to this folder>/palindrome-checker folder.
    execute below commands as per your choice.
   1. Running tests
      1. ./gradlew clean test  -> This command runs all the unit tests.
      2. ./gradlew clean integrationTest -> This command runs all the integration tests.
   2. Building the project jar
      1. ./gradlew clean build -x test -> Builds the project excluding unit tests.
      2. ./gradlew clean build -x integrationTest -> Builds the project excluding integration tests.
      3. ./gradlew clean build  -> Builds the project with both unit and integration tests.
   
6. Starting the application
   Go to /<path to this folder>/palindrome-checker/build/libs
   Run below command
   java -jar palindrome-checker-1.0-SNAPSHOT.jar

7. Application rest endpoint : http://localhost:8080/api/palindrome

   You need to send a request using Postman or any other tool with following details

   RequestMethod : Post
   RequestType: JSON
   RequestBody :
                {
                    "username": "Johnny",
                    "value": "madam"
                }        

