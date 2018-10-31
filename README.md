# invoice

# Guide

 - Download the zip file invoice-project-master from github and extract the zip to your root folder
 
 - Make sure that you have java SDK(1.6 or high) and maven(3.2 or high) install and configured on your computer
 
 - open invoice-project-master folder and type cmd on your explorer
 
 - run this command :- mvn dependency:tree
 
 - run this command :- mvn spring-boot:run
 
 - then use postman or any other tool for restful service to test the project with the below pom
 
 {
    "client": "Ab",
    "vatRate": 15,
    "invoiceDate": "2018-10-25T22:00:00.000+0000",
    "lineItems":  [{ "quantity": 1, "description": "item1", "unitPrice": 0.2},
			        { "quantity": 10, "description": "item2", "unitPrice": 0.2}, 
			        { "quantity": 3, "description": "item3", "unitPrice": 0.3}]
}
