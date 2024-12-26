<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Home page</title>
    </head>
   <body>
       <div>
          <c:out value = "${name}"/>
       </div>
   </body>
</html>