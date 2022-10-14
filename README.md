# employee-appV1


//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

Github repo
===========
> https://github.com/rajapalai/employee-appV1

jar file url with build number
===============================
> http://34.228.64.200:8082/artifactory/libs-snapshot-local/com/synechron/employee/0.0.1-SNAPSHOT/employee-0.0.1-20221014.074925-16.jar

Jfrog artifact repo url with credential
=======================================
> http://34.228.64.200:8082/ui/repos/tree/General/libs-release (username- admin, pass- Raja@palai@1992)

Jenkins url with credential
===========================
> http://52.23.225.209:8080/  (username- admin, pass- Raja@palai@1992)

Docker hub repo credential
=========================
> https://hub.docker.com/  (username- rajapalai , pass- raja@palai@1992)

Docker demon url
================
Run application using docker demon url 
-------------------------------------
> http://18.215.145.23:9595/api/employee (username- user, pass- password)

Instructions to push/pull docker image and run Springboot application
=====================================================================
push docker image to docker hub
-------------------------------
> docker push rajapalai/employee-app:tagname  (tagname is your application build numeric digits)

pull docker image from docker hub and run application in docker engine with demon port
--------------------------------------------------------------------------------------
>1: Start your docker engine.
> 
>2: docker pull rajapalai/employee-app:tagname  (tagname is your application build numeric digits)
>
>3: Check your docker image -> $ docker images 
> 
>4: Run docker command to start springboot application -> $ docker run -p 9595:9595 rajapalai/employee-app:tagname  (tagname is your application build numeric digits)

Springboot application url with basic spring security login details
===================================================================
> http://18.215.145.23:9595/api/employee (auth : username- user, pass- password)

Some Screenshots
================

## > **Github repo**

![img.png](img.png)

> ## **Github action with maven for complete Continues Integration**

![img_1.png](img_1.png)
![img_3.png](img_3.png)
![img_2.png](img_2.png)

> ## **Jenkins server for CI/CD**

![img_4.png](img_4.png)
![img_5.png](img_5.png)

> ## **Jfrog Artifacts build with artifacts name with repo path**

![img_6.png](img_6.png)
![img_7.png](img_7.png)

> ## **Docker hub repo**

![img_8.png](img_8.png)
![img_9.png](img_9.png)

> ## **Run springboot application in docker engine**

![img_10.png](img_10.png)

> ## **Springboot application**

![img_11.png](img_11.png)
![img_12.png](img_12.png)
![img_13.png](img_13.png)