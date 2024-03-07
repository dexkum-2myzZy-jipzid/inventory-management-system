# Inventory Management System

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

## Objectives

The basic login screen is as below:

![Login](https://github.com/dexkum-2myzZy-jipzid/inventory-management-system/blob/main/attachment/login.jpeg)

#### The screen for the admin is as follows:

Dashboard Page

![Admin Dashboard](https://github.com/dexkum-2myzZy-jipzid/inventory-management-system/blob/main/attachment/admin-dashboard.jpeg)

View Inventory

![View Inventory](https://github.com/dexkum-2myzZy-jipzid/inventory-management-system/blob/main/attachment/view-inventory.jpeg)

Add Inventory

![Add Inventory](https://github.com/dexkum-2myzZy-jipzid/inventory-management-system/blob/main/attachment/add-inventory.png)

Update Inventory

![Update Inventory](https://github.com/dexkum-2myzZy-jipzid/inventory-management-system/blob/main/attachment/update-inventory.jpeg)

Remove Inventory

![remove-inventory.jpeg](https://github.com/dexkum-2myzZy-jipzid/inventory-management-system/blob/main/attachment/remove-inventory.jpeg)

#### The screen for the user is as follows:

Dashboard Page

![User Dashboard](https://github.com/dexkum-2myzZy-jipzid/inventory-management-system/blob/main/attachment/user-dashboard.jpeg)

View Inventory

![View Inventory](https://github.com/dexkum-2myzZy-jipzid/inventory-management-system/blob/main/attachment/view-inventory.jpeg)

Seach Inventory

![Search Inventory](https://github.com/dexkum-2myzZy-jipzid/inventory-management-system/blob/main/attachment/search-inventory.jpeg)

## Functional Specification

The program is essentially categorized into two user roles: Admin and User.

The invoked functionality depends on the user logging into the system.

#### Admin Functions:

1.  View Inventory
2.  Add Inventory
3.  Remove Inventory
4.  Update Inventory

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

   - UI: HTML generated by Thymeleaf

3. **Database:**
   - H2 database for storing inventory data.

## Logic Specification

The backend will handle the logic for adding, updating, and removing products. The frontend will provide an intuitive interface for users to interact with the inventory management system.

![Logic Specification](https://github.com/dexkum-2myzZy-jipzid/inventory-management-system/blob/main/attachment/logic-specification.png)

## License

[MIT](https://choosealicense.com/licenses/mit/)
