# spring-boot-angularjs-yeoman
A simple example on using spring-boot with angularjs and yeoman

This is an application with demonstrates how to split the UI (Javascript SPA app) from the backend which is written using Spring-Boot.

The application contains two modules, first is the back-end (Spring-Boot based) and second is a UI based on AngularJS.
At build time, maven will pack the UI module into the backend, so as a result, there will be one .jar file packed everything in it.

This kind of application structure will allow UI teams and Backend teams work much easier on the same project without interfering with each other but at the same time the app result will a single .jar file which will be easy to deploy anywhere, from command line to a docker or cloudfoundry PaaS.

It is a work in progress.
!!!! At the moment there is no UI part yet.!!!!