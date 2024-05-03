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
                <form action="/deleteappartement" method="post">
                    <input type="hidden" name="appartementId" value="${appartement.numero, appartement.adresse}">
                    <input type="submit" value="Delete">
                </form>
            </li>
        </#list>
    </ul>
    <form action="/createappartement" method="get">
        <input type="submit" value="Create New appartement">
    </form>
</body>
</html>