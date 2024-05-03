<#ftl encoding="utf-8">
<html>
<head>
    <link rel="stylesheet" type="text/css" href="src/main/resources/static/style.css">
</head>
<body xmlns="http://www.w3.org/1999/html">
    <h1>Valet Immobillier Co.</h1>
    <form action="/syndicats" method="get">
        <input type="submit" value="Syndicats">
    </form>
    <form action="/personnes" method="get">
        <input type="submit" value="Personnes">
    </form>
    <h2>List d'Immeubles</h2>
    <ul>
        <#list immeubles as immeuble>
            <li>
                <a href="/appartements?adresse=${immeuble.adresse}&immeubleNom=${immeuble.nom}">${immeuble.nom}</a> - ${immeuble.adresse} - ${immeuble.getSyndicatNom()}
                <form action="/deleteImmeuble" method="post">
                    <input type="hidden" name="Nom" value="${immeuble.getNom()}">
                    <input type="submit" value="Delete">
                </form>
            </li>
        </#list>
    </ul>
    <form action="/createImmeuble" method="get">
        <input type="submit" value="Créer un nouvel Immeuble">
    </form>
</body>
</html>