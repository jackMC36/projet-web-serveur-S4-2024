<#ftl encoding="utf-8">
<html>
<head>
    <link rel="stylesheet" type="text/css" href="main/resources/static/style.css">
</head>
<body xmlns="http://www.w3.org/1999/html">
    <ul>
        <#list users as user>
            <li>${user.id} - ${user.firstName} ${user.lastName}</li>
        </#list>
    </ul>
</body>
</html>