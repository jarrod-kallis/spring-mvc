# spring-mvc

http://localhost:8080/login?language=fr

spring-mvc
DispatcherServlet AKA Front Controller in web.xml

DispatcherServlet uses config in web.xml to determine which request goes to which controller

/login url goes to LoginController AKA Handler, because of @RequestMapping(value = "/login")

To determine which view to display the LoginController returns "login", which uses a 
View Resolver (todo-servelet.xml) to attach a prefix & suffix to the return value.
If there is a @ResponseBody annotation then it would just display the returned value in the browser.
