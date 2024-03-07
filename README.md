<div style="text-align: center; font-size: 20px; ">
	Application Requirements Specification
</div>
<div style="text-align: center; font-size: 20px; ">
	For
</div>
<div style="text-align: center; font-size: 20px; ">
	Inventory Management System
</div>






<div style="text-align: center; font-size: 20px; ">
  Prepared By:
</div>
<div style="text-align: center; font-size: 20px; ">
  Liang Chen
</div>
<div style="page-break-after: always;"></div>




## Purpose and Scope Statement

The goal of this project is to create a streamlined and user-friendly Inventory Management System (IMS) to assist businesses in efficiently managing their inventory, tracking stock levels, and optimizing inventory-related processes. The scope encompasses functionalities such as adding, updating, and removing products, as well as search Inventory.



## Usage

1. Run the application
2. Open your browser and enter http://localhost:8080
3. Enter Username & Password (See them from Below)



There are two types of users in this system: Admin and User.

### Admin

- Username: admin
- Password: admin

Admin has full access to all features including adding, updating, deleting, and viewing products.

### User

- Username: user
- Password: user

User has limited access and can only view and search the products in the inventory.



## Requirements Narrative

### Users and Functions

#### Admin

1. **Add Inventory:**
   - Admin can add new products to the inventory, specifying details like product name, category, quantity, and unit price.

2. **Update Inventory:**
   - Capability to modify inventory details, such as quantity, price, or category.

3. **Remove Inventory:**
   - Admin can remove products that are no longer part of the inventory.

4. **View Inventory:**
   - Display a comprehensive list of all products in the inventory, including their details.

#### User

1. **Search Inventory:**
   - Users can search for inventories by case-insensitive name.

2. **View Inventory:**
   - Display a comprehensive list of all products in the inventory, including their details.

<div style="page-break-after: always;"></div>

## Objectives

The basic login screen is as below:

<img src="/Users/mario/Desktop/Canvas/INFO5100.18913.202410/final-project/attachment/login.jpeg" alt="login" style="zoom:50%;" />



#### The screen for the admin is as follows:

Dashboard Page

<img src="/Users/mario/Desktop/Canvas/INFO5100.18913.202410/final-project/attachment/admin-dashboard.jpeg" alt="admin-dashboard" style="zoom:50%;" />



View Inventory

<img src="/Users/mario/Desktop/Canvas/INFO5100.18913.202410/final-project/attachment/view-inventory.jpeg" alt="view-inventory" style="zoom:50%;" />

Add Inventory

<img src="/Users/mario/Desktop/Canvas/INFO5100.18913.202410/final-project/attachment/add-inventory.png" alt="add-inventory" style="zoom:30%;" />

Update Inventory

<img src="/Users/mario/Desktop/Canvas/INFO5100.18913.202410/final-project/attachment/update-inventory.jpeg" alt="update-inventory" style="zoom:50%;" />

Remove Inventory

<img src="/Users/mario/Desktop/Canvas/INFO5100.18913.202410/final-project/attachment/remove-inventory.jpeg" alt="remove-inventory" style="zoom:50%;" />

#### The screen for the user is as follows:

Dashboard Page

<img src="/Users/mario/Desktop/Canvas/INFO5100.18913.202410/final-project/attachment/user-dashboard.jpeg" alt="user-dashboard" style="zoom:50%;" />

View Inventory

<img src="/Users/mario/Desktop/Canvas/INFO5100.18913.202410/final-project/attachment/view-inventory.jpeg" alt="view-inventory" style="zoom:50%;" />

Seach Inventory

<img src="/Users/mario/Desktop/Canvas/INFO5100.18913.202410/final-project/attachment/search-inventory.jpeg" alt="search-inventory" style="zoom:50%;" />



<div style="page-break-after: always;"></div>

## Functional Specification

The program is essentially categorized into two user roles: Admin and User.

The invoked functionality depends on the user logging into the system.

#### Admin Functions:

 1. View Inventory
 2. Add Inventory
 3. Remove Inventory
 4. Update Inventory

#### User Functions:

1. View Inventory
2. Search Inventory

#### Login Functions:

1. Filter Chain
2. CustomAuthenticationSuccessHandler (Role-Based Redirect)
3. User Details Service (Create two default users username and password)
4. Password Encoder



### Classes Needed

The basic classes needed for application are

1. **InventoryController Class:**
   - **Description**: Controller class for handling inventory-related requests
   - **Attributes**: inventoryService
   - **Methods**: viewInventory(), showAddProductForm(), addInventory(), showRemoveInventoryForm(), removeInventory(), showUpdateInventoryForm(), updateInventory(), showSearchInventoryForm(), searchInventory()
2. **Inventory Class**:
   - **Description**: Model class for the inventory table
   - **Attributes**: id, name, category, quantity, price
   - **Methods**: Constructors, Getters and setters
3. **InventoryService Class:**
   - **Description**: Service class for handling inventory-related requests
   - **Attributes**: inventoryRepository
   - **Methods**: addInventory(), getAllInventories(), removeInventory(), updateInventory(), getInventoryById(), searchInventory()
4. **InventoryRepository Interface:**
   - **Description**: Repository interface for the inventory table
   - **Methods**: findByNameContainingIgnoreCase()
5. **InventoryNotFoundException Class:**
   - **Description**: Exception thrown when an inventory is not found
   - **Attributes**: None
   - **Methods**: InventoryNotFoundException()
6. **LoginController Class:**
   - **Description**: Controller class for handling login-related requests
   - **Attributes**: None
   - **Methods**: login(), adminDashboard(), userDashboard()
7. **SecurityConfiguration Class**
   - **Description**: Configuration class for security-related beans
   - **Attributes**: passwordEncoder
   - **Methods**: filterChain(), userDetailsService(), passwordEncoder()
8. **CustomAuthenticationSuccessHandler Class**
   - **Description**: Redirects the user to the appropriate dashboard based on their role
   - **Attributes**: redirectStrategy
   - **Methods**: onAuthenticationSuccess()

### Technologies Needed

1. **Backend:**
   - Language: Java.
   - Framework: Spring Boot, Spring Security

2. **Frontend:**
   - UI:  HTML generated by Thymeleaf

3. **Database:**
   - H2 database for storing inventory data.

<div style="page-break-after: always;"></div>

## Logic Specification

The backend will handle the logic for adding, updating, and removing products. The frontend will provide an intuitive interface for users to interact with the inventory management system.

![logic-specification](/Users/mario/Desktop/Canvas/INFO5100.18913.202410/final-project/attachment/logic-specification.png)



## License

[MIT](https://choosealicense.com/licenses/mit/)