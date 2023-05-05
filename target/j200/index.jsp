<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>j200</title>
    <link href="layout/styles.css" rel="stylesheet">
</head>
<body>
    <header>
        <a href="content/Лабораторная_работа_по_курсу_DEV_J200.pdf">
            <h1>J200 : разработка корпоративных приложений</h1>
        </a>
        <%-- <a  href="login-servlet">login Servlet</a> --%>
        <%-- <form class="loginForm" action="login-servlet" method="post">
            <input type="text" name="login" value="login"/>
            <input type="password" name="password" value="login"/>
            <input class="button" type="submit" value="Sing in">
        </form> --%>
        <form class="createForm" action="create-servlet" method="post">
            <input class="button" type="submit" value="C">
        </form>
    </header>
    <main>
        <embed src="content/Лабораторная_работа_по_курсу_DEV_J200.pdf" type="application/pdf">
    </main>
    <aside>
        <a>Create</a>
        <a>Create</a>
        <a>Create</a>
        <a>Create</a>
        <a>Create</a>
        <a>Create</a>
    </aside>
    
    
    <footer></footer>
</body>
</html>
