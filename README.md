# Retail Discount Calculator

This project calculates the net payable amount for a bill considering various discounts.

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

## Project Structure

- `model` package contains the domain models.
- `service` package contains the discount strategy implementations.
- `test` package contains unit tests for the business logic.

## UML Diagram
![UML Diagram](https://www.plantuml.com/plantuml/dsvg/hLFDRd8X4DtVfvZSrTLF5z-Mc4RxawP95oRr1KOO3GaN30mBO_lkHGMDM3UshYvpnlDp2DF0w3dsff46Gu17RGpi6aY_CMoyKr5o4F2k0q_cn-D3HfKEqaNB7-oHQRqLy9mdUK76mAudlo0RFGbuiscD_07zTr3gRdCCyXegbNMxR4T07fILGFnq8TNLolhC9z78Q91fuHZD7BUuD3JhzvBTG81oCPsRhoRtaQLEbMWb89dLTfq75dkgHXkl9HMgyh_mwfqadn8kdJE4DlifuSx4emlEqINTw0Uc4crDpEG3e5KGZj_x8DgchnLAEdKBkxgCWbntV5r9wRfYktdVTzpIVSPU-ernMwA_YJbRhRJHoB-cEpofyVZyEaw4ayyqhkkiu2fK1L-xFCgr_riO9hWTjiKJ293ECceRcYbP5Nlp3G00)
