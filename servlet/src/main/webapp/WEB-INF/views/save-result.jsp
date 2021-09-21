<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>MVC 패턴</title>
</head>
<body>
성공
<ul>
    <li>id=${member.id}</li> <!-- ((Member)request.getAttribute("member")).getId(); -->
    <li>username=${member.username}</li> <!-- ((Member)request.getAttribute("member")).getUsername(); -->
    <li>age=${member.age}</li> <!-- ((Member)request.getAttribute("member")).getAge(); -->
</ul>
<a href="/index.html">메인</a>
</body>
</html>
