<p align="center">
<picture>
  <source media="(prefers-color-scheme: light)" srcset="https://raw.githubusercontent.com/adriamilan-bootcamp/EasyTemplates-Backend/main/res/logo_dark.png">
  <source media="(prefers-color-scheme: dark)" srcset="https://raw.githubusercontent.com/adriamilan-bootcamp/EasyTemplates-Backend/main/res/logo_light.png">
  <img alt="Logo">
</picture>
</p>

![Heroku CI/CD](https://pyheroku-badge.herokuapp.com/?app=easy-templates-backend&path=/&style=flat)
[![Snyk Analysis](https://github.com/adriamilan-bootcamp/EasyTemplates-Backend/actions/workflows/snyk-analysis.yml/badge.svg)](https://github.com/adriamilan-bootcamp/EasyTemplates-Backend/actions/workflows/snyk-analysis.yml)
![Known Vulnerabilities](https://snyk.io/test/github/adriamilan-bootcamp/EasyTemplates-Backend/badge.svg)

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
  - Snyk Dependency Analyzer and Up-to-date Deps.
  - SonarQube Code Analysis and Vuln. Fixing
  - Safe REST Interactions w/JPA (Doesn't use DTOs Directly)
  - REST API contains privilege-division
    - An user can't edit another user's details
    - User info returned for a determinate id isn't the same for user or admin
    - Many other, and not only for users
  - 0 secrets included in repository history; osint-leak-free and secure
* Amazon's S3 SDK for File Storage
* Heroku deploy w/MySQL database interconnection for data persistence
* Built with 💙 by and for Developers

## 📖 API Endpoints

To get information about the API, head over to [/api/docs/docs.html](https://easy-templates-backend.herokuapp.com/api/docs/docs.html) !

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
