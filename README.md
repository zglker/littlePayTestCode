## Assumptions
- Only focusing on "tap on" and "tap off" logic, ignoring time gap consideration.

- Trip should start from "tap on".

- "tap on" stop and "tap off" stop share the same companyId and BusId

- In order to keep the right format of credit card number shown in CSV, I add '/t' to each record

## Requirements

- Implemented and tested using Java jdk1.8.0_201

- Tests require JUnit

- Project dependencies and compiling managed by Maven

- Please name your trip record CSV file to test.csv and put it under resources folder

- trips.csv would be generated at the same location as ReadMe.md

## Compile, Test, Run and Packaging
## Make sure you have mvn ready

- Compile: `mvn compile`

- Test: `mvn test`

- Run: `mvn exec:java`

