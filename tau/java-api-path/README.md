# Java API Path

## API

- **API** -> Appication Programming Interface
- **API** is a set of rules and protocols for building and interacting with software applications.
- **API Contract**:
  - A formal agreement between the API provider and consumer.
  - Defines the expected behavior, inputs, outputs, and error handling.
  - Consist of:
    - **Request** -> What the consumer sends to the API
      - **Endpoint** -> The url where the API is accessed
      - **Headers** -> Metadata about the request
      - **Body** -> The data sent in the request
      - **Query Parameters** -> Additional parameters in the URL
      - **Method** -> The HTTP method used (GET, POST, PUT, DELETE)
  - **Response** -> What the API sends back to the consumer
    - **Status Code** -> Indicates the result of the request (e.g., 200 for success, 404 for not found)
    - **Headers** -> Metadata about the response
    - **Body** -> The data returned by the API
    - **Error Handling** -> How errors are communicated (e.g., error codes, messages)

<br>

| Status Code | Name                  | Description                                                                |
| ----------- | --------------------- | -------------------------------------------------------------------------- |
| 200         | OK                    | The request was successful                                                 |
| 201         | Created               | The request was successful and a new resource was created                  |
| 204         | No Content            | The request was successful but there is no content to return               |
| 400         | Bad Request           | The request was invalid or cannot be processed                             |
| 401         | Unauthorized          | Authentication is required and has failed or has not been provided         |
| 403         | Forbidden             | The server understood the request but refuses to authorize it              |
| 404         | Not Found             | The requested resource could not be found                                  |
| 500         | Internal Server Error | An error occurred on the server while processing the request               |
| 503         | Service Unavailable   | The server is currently unavailable (e.g., due to maintenance or overload) |
| 504         | Gateway Timeout       | The server did not receive a timely response from an upstream server       |

<br>

- Can change output by change header
  - **Content-Type** -> Indicates the media type of the resource (e.g., `application/json`, `text/html`)
  - **Accept** -> Indicates the media types that the client is willing to receive (e.g., `application/json`, `text/plain`)

### API are for developers

- Correct
- Provides value
- Intuitive
- **APIs are public!**

### View APIs in browser

- Chrome -> View | Developer | Developer Tools | Network
- Firefox -> Tools | Web Developer | Toogle Tools

### View APis from mobile device with a proxy tool

- Fiddler -> Optimized for Windows, Free
- Charles -> Works on Windows or Mac, License required

### GET, POST, PUT, DELETE

| Method     | Purpose                               | Example                                                     |
| ---------- | ------------------------------------- | ----------------------------------------------------------- |
| **GET**    | Retrieve data from the server         | `GET /users` → Get all users                                |
| **POST**   | Send data to create a new resource    | `POST /users` → Create a new user                           |
| **PUT**    | Update an existing resource           | `PUT /users/1` → Update user with ID 1                      |
| **PATCH**  | Partially update an existing resource | `PATCH /users/1` → Update specific fields of user with ID 1 |
| **DELETE** | Remove a resource from the server     | `DELETE /users/1` → Delete user with ID 1                   |

## API Testing

### POISED API Testing Strategy

| Letter | Area       | Description                                                  |
| ------ | ---------- | ------------------------------------------------------------ |
| **P**  | Parameters | Check if the API handles different parameters correctly      |
| **O**  | Output     | Verify the API returns the expected output                   |
| **I**  | Interop    | Ensure the API works well with formats and protocols         |
| **S**  | Security   | Test for security vulnerabilities and ensure data protection |
| **E**  | Errors     | Check how the API handles errors and unexpected inputs       |
| **D**  | Data       | Validate the data integrity and consistency                  |

<br>

- **Cross-site scripting (XSS)** -> A security vulnerability that allows an attacker to inject malicious scripts into web pages viewed by other users.

## Newman

- Run Postman collections from the command line

```bash
# Install Newman globally (Node.js must be installed)
npm install -g newman
```

```bash
# Run a Postman collection
newman run <collection-file.json> --environment <environment-file.json>
```

```bash
# Example command
newman run my-collection.json --environment my-environment.json
```
