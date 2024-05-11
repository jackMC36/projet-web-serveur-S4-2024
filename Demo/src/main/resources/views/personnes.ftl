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
                ${personne.getPrenom()} - ${personne.getNom()} - <#if personne.getNumTel()??>
    ${personne.numTel}
<#else>
    Aucun Numéro
</#if>
                <form action="/deletePersonne" method="post">
                    <input type="hidden" name="numTel" value="${personne.getNumTel()}">
                    <input type="submit" value="Delete">
                </form>
            </li>
        </#list>
    </ul>
    <form action="/createPersonne" method="get">
        <input type="submit" value="Créer une nouvelle Personne">
    </form>
</body>
</html>
