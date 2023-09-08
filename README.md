# greenstitch-signup-login-assignment


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
#### Get item

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




