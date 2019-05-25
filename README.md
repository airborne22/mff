# MFF
Main Web/Discord App in Spring Boot/Java

## Prerequisites
Install:
* Postgresql (for Macs, use https://postgresapp.com/)
    * During install, use the credentials `postgres` / `password` for now.
* git
* java 1.8.x
* maven 3.5.x

## Get a copy of repo
For the rest of this doc, we assume the project to be `~/dev/mff`. Substitute in wherever you use.

First, run this to get the repo:
```
cd ~/dev
git clone git@github.com:airborne22/mff.git
```
If prompted, enter the credentials for Github.

From this point on, you can pull latest code via this
```
cd ~/dev/mff
git pull origin master
```

## Install dependencies
You can install the libraries via maven command
```
mvn clean install
```
The above will install, among other things, Spring framework libraries, Postgresql library needed to have the app communicate to a Postgresql database.

## Create the DB
* IF YOU ARE USING Postgres app on the Mac, then click on the elephant and:
  * start the server if it's not started already
  * select "Open Postgres"
  * double-click on "postgres" DB
  * type these commands:
  ```
  create database mff;
  \q
  ```

* IF YOU ARE NOT USING Postgres app on the Mac:
  ```
  psql -h localhost -U postgres
  create database mff;
  \q
  ```

## Run the App
Now the app should come up:
```
spring-boot:run
```
This will first execute any missing database migrations it needs to run, and launch up the server locally. 

One way to check if this runs correctly is to hit the following:
```
localhost:8080
```

## Helpful tools
https://www.dbvis.com/

