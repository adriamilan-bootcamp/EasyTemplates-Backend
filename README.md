<p align="center">
<picture>
  <source media="(prefers-color-scheme: light)" srcset="https://raw.githubusercontent.com/adriamilan-bootcamp/EasyTemplates-Backend/main/res/logo_dark.png">
  <source media="(prefers-color-scheme: dark)" srcset="https://raw.githubusercontent.com/adriamilan-bootcamp/EasyTemplates-Backend/main/res/logo_light.png">
  <img alt="Logo">
</picture>
</p>

![Heroku CI/CD](https://pyheroku-badge.herokuapp.com/?app=easy-templates-backend&path=/&style=flat)

## 📃 General Information

A feature-rich Spring-based Backend for our EasyTemplates Project

## ✨ Features

* Simple easy-to-use and intuitive public API
  - Register and Login Endpoints
  - Application-related Endpoints (User, groups info...)
* Baked in Security Layer
  - Bearer Auth-Protected Endpoints
  - Roles system
  - CORS Filtering
* Amazon's S3 SDK for File Storage
* Heroku deploy w/MySQL database interconnection for data persistence
* Built with 💙 by and for Developers

## 📖 API Endpoints

To get information about the API, head over to /swagger-ui/ !

Constraints:

* This endpoint returns a Authentication Bearer Token, it must be set in future requests to authenticate yourself
* Users have privilege levels (ADMIN, USER), even if authenticated; some endpoints are not available for Users with USER Privilege


## 🔧 Compiling

### Required software stack

```bash
* Java JDK & JRE >= 8 (1.8.x)
* Spring Tool Suite 4 (ver >= 4.15.2.RELEASE)
```

In order to try this project, you first need to clone the repository; by default (Unless specified) we'll clone the ```main``` branch.

To do so:

```bash
$ git clone https://github.com/adriamilan-bootcamp/EasyTemplates-Backend
```

Right after, you'll need to import the repository into STS4 as a Maven project, next, STS will start processing the ```pom.xml``` file in order to gather the required Maven artifacts that need to exist in order for it to compile successfully.

As soon as it finished, you can build the Project as a ```Spring Boot``` Project.

Afterwards, once compilation finishes; a ```tomcat``` server will spawn at port 8080 (Be sure to check if it's available, in that case, change it for something else in the ```application.properties``` file) serving the project's backend.
