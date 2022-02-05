В тестах заиспользовать аннотации и параметры TestNG.
Обязательные: @BeforeMethod, @AfterMethod, dataProvider, запуск в параллели (через .xml файл), dependsOnMethods, description, priority, invocationCount, threadPoolSize
Креды передыны в качестве параметров из .xml

Создать в корневой директории проекта SauceDemo файл README.md в котором разместить, команды для следующих операций:
1.Обновить версии всех библиотек в проекте и ее вывод, например
[INFO] The following dependencies in Dependencies have newer versions:
[INFO]   org.seleniumhq.selenium:selenium-java ...... 3.141.59 -> 4.0.0-alpha-5
### mvn versions:display-dependency-updates
The following dependencies in Dependencies have newer versions:
[INFO]   org.seleniumhq.selenium:selenium-java ................. 4.1.0 -> 4.1.2
[INFO]   org.testng:testng ....................................... 7.4.0 -> 7.5
### mvn versions:use-latest-versions
[INFO] Major version changes allowed
[INFO] Updated org.seleniumhq.selenium:selenium-java:jar:4.1.0 to version 4.1.2
[INFO] Updated org.testng:testng:jar:7.4.0 to version 7.5


2.Запустить тесты используя mvn clean test команду и ее вывод, например
Tests run: 1, Failures: 1, Errors: 0, Skipped: 0, Time elapsed: 11.302 sec <<< FAILURE!

### mvn clean test
[INFO] Results:
[INFO]
[INFO] Tests run: 7, Failures: 0, Errors: 0, Skipped: 0
[INFO]
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  20.516 s
[INFO] Finished at: 2022-02-05T22:46:52+03:00

3.Использовать параметры для запуска конкретных тестов и методов (может быть затык с запуск нескольких методов, здесь документация https://maven.apache.org/surefire/maven-surefire-plugin/examples/single-test.html , для работы необходим обновленный maven-surefire-plugin, как обновить написано здесь http://maven.apache.org/surefire/maven-surefire-plugin/usage.html )
запуск конкретных тестов:
#### 1) mvn test -Dtest=LoginTest - запуск тестовов класса LoginTest
#### 2) mvn test -Dtest=LoginTest#LoginTest запуск метода LoginTest класса LoginTest
#### 3) mvn test -Dtest=LoginTest#LoginTest+USERNAME_PLACEHOLDER_TEST запуск методов  LoginTest и USERNAME_PLACEHOLDER_TEST класса LoginTest

4.Пробросить параметр из mvn command line внутрь теста:
### mvn clean -Dtest=LoginTest#validCredentialsLoginTest -Dusername=standard_user -Dpasscode=secret_sauce test

