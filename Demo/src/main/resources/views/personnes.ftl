<#ftl encoding="utf-8">
<html>
<head>
    <link rel="stylesheet" type="text/css" href="src/main/resources/static/style.css">
</head>
<body xmlns="http://www.w3.org/1999/html">
    <h1>Valet Immobillier Co.</h1>
    <form action="/immeubles" method="get">
        <input type="submit" value="Home">
    </form>
    <h2>Liste de Personnes:</h2>
    <ul>
        <#list personnes! as personne>
            <li>
                ${personne.prenom} - ${personne.nom} - <#if personne.numeroTel??>
    ${personne.numeroTel}
<#else>
    Aucun Numéro
</#if>
                <form action="/deletePersonne" method="post">
                    <input type="hidden" name="numeroTel" value="${personne.numeroTel}">
                    <input type="submit" value="Delete">
                </form>
            </li>
        </#list>
    </ul>
</body>
</html>