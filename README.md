# spring-security

Dependencies used:
- spring-boot-starter-data-jpa
- com.h2database
- io.jsonwebtoken
- spring-boot-starter-security

Installation steps:
1. clone the repo
2. maven update
3. build
4. run
  
Steps for testing:

Step 1: Signup : Use Postman
- POST URL: http://localhost:8080/signup
- body: 
{
    "name":"Vaishnavi",
    "password":"vaishu",
    "roles":"ROLE_ADMIN",
    "email":"yyy@gmail.com"
}
- response:
user added to the system 

Step 2: Log in 
- POST http://localhost:8080/login
{
    "username":"Vaishnavi",
    "password":"vaishu"
}
- response: token, copy the token

Step 3: Test authorization - positive test
- This user has the role of admin, hence will have access to method products/all
- GET URL: http://localhost:8080/products/all 
In the authorization tab select the type as Bearer token and paste the token.
- response: list of products

Step 4: Test authorization - negative test
- This user has the role of admin, hence will not have access to method products/{id}
- GET URL: http://localhost:8080/products/1 
- In the authorization tab select the type as Bearer token and paste the token.
- response: Forbidden

Step 5: Signup 
- POST URL: http://localhost:8080/signup
- body: 
{
    "name":"Subashni",
    "password":"suba",
    "roles":"ROLE_USER",
    "email":"xxx@gmail.com"
}
- response:
user added to the system 

Step 2: Log in 
- POST http://localhost:8080/login
{
    "username":"Subashni",
    "password":"suba"
}
- response: token, copy the token

Step 3: Test authorization - positive test
- This user has the role of user, hence will have access to method products/{id}
- GET URL: http://localhost:8080/products/1 
- In the authorization tab select the type as Bearer token and paste the token.
- response: product of the respective id

Step 4: Test authorization - negative test
- This user has the role of user, hence will not have access to method products/all
- GET URL: http://localhost:8080/products/all
- In the authorization tab select the type as Bearer token and paste the token.
- response: Forbidden

