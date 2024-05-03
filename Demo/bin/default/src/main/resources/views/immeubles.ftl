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
    <h2>List d'Immeubles</h2>
    <ul>
        <#list immeubles as immeuble>
            <li>
                ${immeuble.nom} - ${immeuble.adresse} - ${immeuble.getSyndicatNom()}
                <form action="/deleteImmeuble" method="post">
<<<<<<< HEAD
                    <input type="hidden" name="immeubleId" value="${immeuble.nom}">
=======
                    <input type="hidden" name="Nom" value="${immeuble.getNom()}">
>>>>>>> 5cdc075a4eb296895542d66ca65a07eff47463fe
                    <input type="submit" value="Delete">
                </form>
            </li>
        </#list>
    </ul>
    <form action="/createImmeuble" method="get">
<<<<<<< HEAD
        <input type="submit" value="Create New Immeuble">
=======
        <input type="submit" value="Créer un nouvel Immeuble">
>>>>>>> 5cdc075a4eb296895542d66ca65a07eff47463fe
    </form>
</body>
</html>