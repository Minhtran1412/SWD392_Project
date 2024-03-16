<%-- 
    Document   : login
    Created on : Mar 16, 2024, 9:44:27 PM
    Author     : dell
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h2>LOGIN</h2>       
    <form action="login" method="post">
        Username: <input type="text" name="username" required=""><br>
        Password: <input type="password" name="password" required=""><br>
        <input type="submit" value="Đăng nhập">
    </form>
        <div style="color: red; font-size: 30px;">
            
        
        <% String message = (String)request.getAttribute("message"); %>
        <% if(message != null && !message.isEmpty()) { %>
             <p><%= message %></p>
        <% } %>
        
        </div>
    </body>
</html>
