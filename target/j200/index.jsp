<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
    <link href="layout/styles.css" rel="stylesheet">
</head>
<body>
    <header>
        <a href="content/Лабораторная_работа_по_курсу_DEV_J200.pdf">
            <h1>J200 : разработка корпоративных приложений</h1>
        </a>
        <%-- <a  href="login-servlet">login Servlet</a> --%>
        <form class="loginForm" action="login-servlet" method="post">
            <input type="text" name="login" value="login"/>
            <br><br>
            <input type="password" name="password" value="login"/>
            <br><br>
            <input class="ButtonSubmit" type="submit" value="Sing in">
        </form>
    </header>
    <%-- <br> --%>
    <main>
        <embed src="content/Лабораторная_работа_по_курсу_DEV_J200.pdf" type="application/pdf">
    </main>
    <footer></footer>
</body>
</html>
