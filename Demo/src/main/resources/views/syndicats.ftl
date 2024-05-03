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
    <h2>Liste de Syndicats Disponible:</h2>
    <ul>
        <#list syndicats as syndicat>
            <li>
                ${syndicat.nom} - ${syndicat.adresse} - $<#if syndicat.numeroTel??>
    ${syndicat.numeroTel}
<#else>
    Aucun Numéro
</#if> - $<#if syndicat.adresse_mail??>
    ${syndicat.adresse_mail}
<#else>
    Aucune Adresse Mail
</#if> - <#if syndicat.nom_referent??>
    ${syndicat.nom_referent}
<#else>
    Aucun nom de référent
</#if>

                <form action="/deleteSyndicat" method="post">
                    <input type="hidden" name="Nom" value="${syndicat.getAdresse()}">
                    <input type="submit" value="Delete">
                </form>
            </li>
        </#list>

    </ul>
    <form action="/createSyndicat" method="get">
        <input type="submit" value="Créer un nouvel Syndicat">
    </form>
</body>
</html>