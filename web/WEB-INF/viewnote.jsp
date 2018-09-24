<%-- 
    Document   : viewnote
    Created on : Sep 20, 2018, 12:23:48 PM
    Author     : 687159
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Simple Note Keeper</title>
    </head>
    <body>
        <h1>Simple Note Keeper</h1><br>
        <h2>View Note</h2>
        <form method="GET" action="note">
            <span><h3>Title: ${note.title}</h3></span>
            <h3>Contents: ${note.content}</h3>    
        </form>
        <a href="note?edit">Edit</a>       
    </body>
</html>
