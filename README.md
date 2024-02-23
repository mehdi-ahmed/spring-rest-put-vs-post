# Post vs Put Dilemma

    - The POST method call will create a child resource under a collection of resources.
    - The PUT method call will either create a new resource or update an existing one.
    - PUT is an idempotent method, while POST isn’t:
        - For instance, calling the PUT method multiple times will either create or update the same resource. 
        - In contrast, multiple POST requests will lead to the creation of the same resource multiple times.   

-   Article from Baeldung: https://www.baeldung.com/rest-http-put-vs-post
-   H2 console is accessible here: http://localhost:8080/h2-console/