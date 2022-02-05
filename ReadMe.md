SE-car-rental - End to End system to manage car rental (dev- branch, rest api full implemented and security integrated)

Run the program on your localhost and go to the http://localhost:8082/swagger-ui.html to check the rest-api implemented endpoints.
Because LogIn is implemented make sure to allow add-employee privilages and use that as your entry.

1. add "/rental/api/employee/add-new/**' to edu.miu.project.configuration.SecurityConfiguration file to the permit.all set of endpoints
2. run the application
3. go to http://localhost:8082/swagger-ui.html and on the employee/add-employee endpoint, create an employee with Role - 'ADMIN', username and password
4. you can now access any of the other endpoints using that username and password
5. you can also create an employee with Role 'EMPLOYEE' this will restrict some of the links (those under customer and employee)
