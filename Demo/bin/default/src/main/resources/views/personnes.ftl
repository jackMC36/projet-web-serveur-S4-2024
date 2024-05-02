<#ftl encoding="utf-8">
<html>
<head>
    <link rel="stylesheet" type="text/css" href="src/main/resources/static/style.css">
</head>
<body xmlns="http://www.w3.org/1999/html">
    <ul>
        <#list immeubles as immeuble>
            <li>${immeuble.nom} - ${immeuble.adresse} - ${immeuble.getSyndicatNom()}</li>
        </#list>
    </ul>
</body>
</html>