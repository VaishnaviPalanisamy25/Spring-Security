# spring-boot3-jwt

Database Used :H2 (file) - records available after system restart

Steps for testting:

Step 1: Signup -Use postman
url: http://localhost:8080/signup
body: 
{
    "name":"Vaishnavi",
    "password":"vaishu",
    "roles":"ROLE_ADMIN",
    "email":"yyy@gmail.com"
}
response:
user added to system 

Step 2: Login 
http://localhost:8080/products/all
hit this url in your browser
username: Vaishnavi
password: vaishu

since this user signed up as admin , has access to products/all and not products/{id}

Step 3: -Use postman
url: http://localhost:8080/signup
body: 
{
    "name":"Subashni",
    "password":"suba",
    "roles":"ROLE_USER",
    "email":"yyy@gmail.com"
}
Step 4: Use incognito this time
http://localhost:8080/products/1
hit this url in your browser
username: Subashni
password: suba

since this user signed up as user , has access to products/{id} and not products/all

