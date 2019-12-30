<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<html>
    <head>
        <title>login</title>
    </head>
    <body>
        <br method="post" action="/user/login">
            用户名：<input type="text" name="name" /></br>
            密码：<input type="text" name="pwd" />
            <input type="submit" value="登录">
        </form>
    </body>
</html>