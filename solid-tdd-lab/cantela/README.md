# NOTE: THE COMMENTS IN THIS FOLDER ARE DONE BY AI TO DOCUMENT
## Minimum and Bonus are all met.

# Screenshots Unit Tests
### There are a total of 29 test, all of them passed
![img_5.png](refactoring-evidence/img_5.png)

# Red-Green-Blue cycle
### See the video to see the cycle in action. Found in Refactoring-evidence.

# Intellij Coverage
![img_6.png](refactoring-evidence/img_6.png)

# Jacoco Coverage
![img_7.png](refactoring-evidence/img_7.png)

# BONUS
- Parameterized test: FOUND IN EmployeeServiceImplTest
![img_8.png](refactoring-evidence/img_8.png)

Found in PaymentImplementationTest
![img_9.png](refactoring-evidence/img_9.png)


- Integration Test: found in EmployeeCrudIntegrationTest
![img_10.png](refactoring-evidence/img_10.png)


- DTO PATTERN: EmployeeRequest and EmployeeResponseDTO

![img_11.png](refactoring-evidence/img_11.png)

- Custom Exception: ResourceNotFound and NegativeAmountException

![img_12.png](refactoring-evidence/img_12.png)

- Better Package Organization: Package for Entity, DTO, Controller, Service, Exception, Mapper, PaymentPoly, Repository, Service, ValueObject

![img_13.png](refactoring-evidence/img_13.png)

# Review and Retrospect

- Which principle improved your design the most? DRY principle, because it helped me to  remove the duplicate codes. (see the details in Before and After md, in refactoring evidence folder)


- What bad design did you remove? well again I removed the duplicate code in employee service, and I also removed the overlapping responsibility between EmployeeMapper and EmployeeFactory.


- Which principle was hardest to apply? YAGNI, for me because I always think ahead resulting to adding uncessary code, that's why it took me long time to pass the previous activity (GRASP) because I was adding code that is not needed for the current requirement, and had to remove it later on.