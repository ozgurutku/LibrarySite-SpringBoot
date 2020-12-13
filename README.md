# Spring Boot Intern Project

#### Projenin Özelikleri
* Yazar Tanımı yapılabilmeli ( Yazar Adı, Açıklama )
* Yayın Evi Tanımı yapılabilmeli ( Yayın Evi Adı, Açıklama )
* Kitap tanıtımı yapılabilmeli ( kitap adı, kitap alt adı, kitap seri adı, yazar, yayın evi, isbn numarası, açıklama )
* Bir Yazar için n tane kitap tanımlanabilmeli
* Bir Yayın evi için n tane kitap tanımlanabilmeli
* Kitap adı, Seri adı, Yazar ya da ISBN ile arama yapılabilmeli
* Var olan bir kayıt üzerinde değişiklik yapılabilmeli
* Var olan kayıtlar incelebilmeli
* Var olan bir kayıt silinebilmeli

**Dependencies:** Java 11.0.9, Maven, MySQL 8.0.22

### Create Database 
```sh
$ mysql -u root -p -e "create database kutuphane";
```

### Default Database Configuration
You can change these settings in the application.properties file. If you do not edit these properties, you will encounter an error in the **Install dependencies**  step.

`spring.datasource.url = jdbc:mysql://localhost:3306/kutuphane?useSSL=false&serverTimezone=UTC&useLegacyDatetimeCode=false`

`spring.datasource.username=root`

`spring.datasource.password=123456`

### Install depedencies

```sh
$ mvn clean install
```

### Start

```sh
$ mvn spring-boot:run
```
or

```sh
$ java -jar target/kutuphane-0.0.1-SNAPSHOT.jar
```

### Usage
For admin use

Admin user name = ozgurutku Admin password = ozgurutku

For member use

register as a member