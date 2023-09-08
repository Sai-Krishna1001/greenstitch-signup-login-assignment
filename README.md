# greenstitch-signup-login-assignment

# Signup and Login Process

Step 1: clone the repository

Step 2: import the maven project in any IDE(Eclipse, Intellij, STS)

Step 3: update the maven project

Step 4: Run the project as springboot application

Step 5: Before the user login the user has to register by providing userdetails in json format(Check API Reference mentioned below)

Step 6: After Signup user has to login by providing username and password in json format(Check API Reference mentioned below)

Step 7: RESULT
User will get JWT token after the user credentials are valid






## API Reference

#### User Signup

```http
  POST http://localhost:8080/api/auth/register
```

| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `username` | `string` | Body Parameter |
| `email` | `string` | Body Parameter|
| `password` | `string` |Body Parameter |
| `name` | `string` | Body Parameter |

Post body of Signup
{
    "name":"sai",
    "username":"sai",
    "email": "sai@gmail.com",
    "password":"sai"

}
#### User Signin

```http
  POST http://localhost:8080/api/auth/login
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `usernameOrEmail` | `string` | Body Parameter |
| `password` | `string` | Body Parameter |

POST Body of login
{
    "usernameOrEmail":"sai",
    "password":"sai"
}




