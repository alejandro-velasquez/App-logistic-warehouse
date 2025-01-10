# CRUD Logistic Pallet Management System
This project is a system designed to manage pallets used in a logistic warehouse.Pallets are essential
platforms for efficiently storing and transporting goods. With this system you can manage pallets and loads stored on them.

## Project Description
In the logistics industry, pallets are crucial for handling and transporting large quantities of goods.
This system enables the creation, modification,delete and retrieval pallets, as well as management of their loads.

### Main Features
- **GET**: Retrieve all pallets.
- **GET**: Retrieve the details of a specific pallet.
-  **POST**: Create a new pallet.
-  **PUT**: Update an existing pallet.
-  **DELETE**: Delete a pallet.

   ### System Validations
-  Loads cannot exceed the maximum capacity of the pallet.
-  A pallet's capacity must be greater than 0 and expressed as numeric value.
-  The pallet status must be valid value.
-  Only pallets that exist in the database can be queried.
-  If a load is associated with a non-existen pallet, the value will be set to null. 

### Access the Application

The application is deployed and available to everyone. You can access it through the provided URL and explore the API documentation via Swagger:

- **Application URL Swagger**:
- **Access Credentianls**:
   - Username: admin
   - Password: admin123

  ## Technologies Used

- **Spring Boot**: Backend framework.
- **Swagger**: Interactive API documentation and testing.
- **Render**: Platform for application deployment.
