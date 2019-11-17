# Well Id - Programming Test

This is my implementation of the Collinear Problem.

This project is written in **Kotlin** and uses **Ktor** 
as Web Server.   

In order to execute the web server just **run** the ```main``` module in  ```Application.kt```.

The following api are available:

* ```GET /space``` to obtain the list of points in the space.
* ```GET /lines/${n}``` to obtain the list of lines composed by at least ```n``` points.
* ```POST /point``` to create a new point in the space. The body must be a json like the following ```{"x": 1, "y":2}```.
* ```DELETE /space``` to delete all points the space.  

