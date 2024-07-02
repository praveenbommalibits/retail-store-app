# Retail Store Discount Application

## Overview

This application calculates net payable amounts on a retail website based on various discount criteria. It follows an object-oriented programming approach and includes unit tests for good coverage.


## How to Run

1. **Build the Project**
    ```bash
    ./mvnw clean install
    ```

2. **Run Unit Tests**
    ```bash
    ./mvnw test
    ```

3. **Generate Coverage Report**
    ```bash
    ./mvnw jacoco:report
    ```

4. **Run SonarQube Analysis**
    ```bash
    ./mvnw sonar:sonar
    ```

## API Endpoints
### Calculate Total Payable Amount

**URL:** `/api/bills/calculateTotal`

**example**: http://localhost:8080/api/bills/calculateTotal?discountType=employee&tenure=1

**Method:** `POST`

**Request Parameters:**
- `discountType` (String) - The type of discount to apply (**employee, affiliate, customer**).
- `tenure` (int) - The tenure of the customer in years (only applicable for customer discount).

**Request Body:**

```json
[
  {
    "id": "1",
    "name": "Laptop",
    "price": 1000,
    "isGrocery": false
  },
  {
    "id": "2",
    "name": "Milk",
    "price": 200,
    "isGrocery": true
  }
]
```
**Response:**
```
840.0
```
Note: Attached the complete postman collection for all other api calls [here](https://github.com/praveenbommalibits/retail-store-app/blob/master/retail-store-app-collection.postman_collection.json)
### Create Bill

**URL:** `/api/bills/create`

**Method:** `POST`

**Request Parameters:**
- `discountType` (String) - The type of discount to apply (employee, affiliate, customer).

**Sample Request:**

```http
POST /api/bills/create?discountType=employee
```
**Sample Response:**
```
{
  "id": "bill-1",
  "products": [],
  "discount": {
    "type": "EmployeeDiscount"
  },
  "customerTenure": 0
}
```

### Add Product to Bill

**URL:** `/api/bills/{billId}/addProduct`

**Method:** `POST`

**Request Body:**
```
{
  "id": "1",
  "name": "Laptop",
  "price": 1000,
  "isGrocery": false
}

```

**Sample Request:**

```http
POST /api/bills/bill-1/addProduct
```
**Sample Response:**
```
{
  "id": "bill-1",
  "products": [
    {
      "id": "1",
      "name": "Laptop",
      "price": 1000,
      "isGrocery": false
    }
  ],
  "discount": {
    "type": "EmployeeDiscount"
  },
  "customerTenure": 0
}

```

### Set Customer Tenure

**URL:** `/api/bills/{billId}/setCustomerTenure`

**Method:** `POST`

**Request Parameters:**
- `tenure (int) - The tenure of the customer in years.`

**Sample Request:**

```http
POST /api/bills/bill-1/setCustomerTenure?tenure=3

```
**Sample Response:**
```
{
  "id": "bill-1",
  "products": [
    {
      "id": "1",
      "name": "Laptop",
      "price": 1000,
      "isGrocery": false
    }
  ],
  "discount": {
    "type": "EmployeeDiscount"
  },
  "customerTenure": 3
}

```

### Calculate Total Payable Amount

**URL:** `/api/bills/{billId}/calculateTotal`

**Method:** `GET`

**Sample Request:**

```http
GET /api/bills/bill-1/calculateTotal

```
**Sample Response:**
```
840.0

```


## UML Diagram
![UML Diagram](https://www.plantuml.com/plantuml/dsvg/hLFDRd8X4DtVfvZSrTLF5z-Mc4RxawP95oRr1KOO3GaN30mBO_lkHGMDM3UshYvpnlDp2DF0w3dsff46Gu17RGpi6aY_CMoyKr5o4F2k0q_cn-D3HfKEqaNB7-oHQRqLy9mdUK76mAudlo0RFGbuiscD_07zTr3gRdCCyXegbNMxR4T07fILGFnq8TNLolhC9z78Q91fuHZD7BUuD3JhzvBTG81oCPsRhoRtaQLEbMWb89dLTfq75dkgHXkl9HMgyh_mwfqadn8kdJE4DlifuSx4emlEqINTw0Uc4crDpEG3e5KGZj_x8DgchnLAEdKBkxgCWbntV5r9wRfYktdVTzpIVSPU-ernMwA_YJbRhRJHoB-cEpofyVZyEaw4ayyqhkkiu2fK1L-xFCgr_riO9hWTjiKJ293ECceRcYbP5Nlp3G00)

## Code Coverage
![img.png](img.png)

## Future Scope of Development
- **Future Scope Features:**
   - Dynamic and configurable discount rules
   - Tiered discounts
   - Item-level discounts
   - Detailed billing breakdown
   - Role-Based Access Control (RBAC)
   - User profiles with membership levels and purchase history

- **Performance Enhancements:**
   - Caching mechanism
   - Microservices architecture for scalability

- **Testing and Quality Assurance:**
   - Comprehensive unit and integration tests
   - Continuous Integration/Continuous Deployment (CI/CD) pipeline
   - SonarQube integration for code quality monitoring