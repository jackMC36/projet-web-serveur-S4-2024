<#ftl encoding="utf-8">
<html>
<head>
    <link rel="stylesheet" type="text/css" href="src/main/resources/static/style.css">
</head>
<body xmlns="http://www.w3.org/1999/html">
    <ul>
        <#list appartements as appartement>
            <li>
                ${appartement.etage} - ${appartement.numero} - ${appartement.superficie} - ${appartement.estLoue} - ${appartement.adresse}
            </li>
        </#list>
    </ul>
</body>
</html>