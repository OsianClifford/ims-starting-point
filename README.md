Coverage: 34%
# Project Title

The task here was to create an interactive database with use of Mysql and Junit to test it.

## Getting Started

1. Clone and pull this repositry into a new folder or downlaod as a zip and unpack.
2. use a programming IDE to load up and build the Ims.java found in Fundamental Project Specification (IMS)\ims-starting-point\src\main\java\com\qa\ims
3. From there you can look at the source code and build the project and try it out.
4. all extra and supporting documents are found in the root folder.

### Prerequisites

An IDE of your choice. I use "IntelliJ" myself or you could use something similar like "Eclipse"
You will also need Java version 14 or above to build and compiled the code.

### Installing

1. Depending on your choice of IDE, you first need to install one in order to open and build and compile the code in this project.
2. You need to clone and pull this repositry (https://github.com/OsianClifford/ims-starting-point), prefably using Git Bash.
3. You can then follow the steps found in Getting Started found above to unpack or to get started.
4. To add to this list and give extra details, You could also open the project structure which will then appear in your project viewer.
5. you are done. If you find ims.java and other java files then you are in the right place.
6. You can build the code by pressing the "Run" button at the top of your IDE (depending on your IDE) or you could go to Build > Run.
7. You will also need to setup a MySql local instance database using the file named "ims database" found in the root file. This file has all the required MySql statements required to build the database and access it.
8. From here you can then fully interact with the database through java.

## Running the tests

To run the automated tests you can find them in src/test/testcom.qa.ims

You can run each one by right clicking on each one and selecting "Run"

####Controller Folder/Package
CustomerControllerTest - This tests the controller functionality of CustomerControllerTest.java
ItemControllerTest - This tests the controller functionality of ItemControllerTest.java

####Persistence Folder/Package

#####Dao Folder/Package
CustomerDaoMysqlTest - This tests the functionality interaction between the java and the MySql database of CustomerDaoMysql.java

#####Domain Folder/Package
CustomerTest - This tests the functionality of the customer domain and the setters and getters that store the values of customers.
DomainTest - This tests the functionality of the main Domain that sets up the other domains that use it's functionality.
ItemTest - This tests the functionality of the item domain and the setters and getters that store the values of items.

####Controller Folder/Package
CustomerServicesTest - This tests the functionality of the customer services that is used by the domain and the main runner.

## Built With

* [Maven](https://maven.apache.org/) - Dependency Management

## Versioning

We use [SemVer](http://semver.org/) for versioning.

## Authors

* **Chris Perrins** - *Initial work* - [christophperrins](https://github.com/christophperrins)
* **Nick Johnson** - *Refinements* - [nickrstewarttds](https://github.com/nickrstewarttds)

## License

This project is licensed under the MIT license - see the [LICENSE.md](LICENSE.md) file for details 

*For help in [Choosing a license](https://choosealicense.com/)*

## Acknowledgments

* Hat-tip to anyone whose code was used
* Shout-out to anyone who helped you out
* Inspiration
* etc.
