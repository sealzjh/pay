# Account Pay Center

* A Account Pay Center with Spring-boot、Hibernate、Jetty、Gradle

## How to build

     $ git clone git@github.com:sealzjh/pay
     $ cd pay
     $ gradle build

## Run
     $ java -jar build/libs/app-pay-0.1.0.jar

* now run success and you can test:

     $ curl http://localhost:8080/hello/

## Module
* Bank
* City
* Account
* Card
* Money

## DB
* pay_provice
* pay_city
* pay_bank
* pay_subbank
* pay_account
* pay_account_money
* pay_card
* pay_account_type
* pay_money_record
* pay_money_record_type

## License
* Account Pay Center is Open Source software released under the
[Apache 2.0 license](http://www.apache.org/licenses/LICENSE-2.0.html).
