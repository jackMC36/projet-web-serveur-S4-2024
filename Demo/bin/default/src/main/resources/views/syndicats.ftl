<#ftl encoding="utf-8">
<html>
<head>
    <link rel="stylesheet" type="text/css" href="style.css">
</head>
<body xmlns="http://www.w3.org/1999/html">
    <h1>Valet Immobillier Co.</h1>
    <form action="/immeubles" method="get">
        <input type="submit" value="Home">
    </form>
    <h2>Liste des syndicats :</h2>
    <table>
      <tr>
        <th>Nom du syndicat</th>
        <th>Adresse du bâtiment sur lequel il agit</th>
        <th>Nom du référent</th>
        <th>Numéro de téléphone</th>
        <th>Adresse mail</th>
        <th></th>
      </tr>
      <#list syndicats as syndicat>
        <tr>
            <td>${syndicat.nom}</td>
            <td>${syndicat.adresse}</td>
            <td><#if syndicat.nom_referent??> ${syndicat.nom_referent} <#else> Aucun nom de référent </#if></td>
            <td><#if syndicat.numeroTel??> ${syndicat.numeroTel} <#else> Aucun numéro </#if></td>
            <td><#if syndicat.adresse_mail??> ${syndicat.adresse_mail} <#else> Aucune adresse mail </#if></td>
            <td>
                <form action="/deleteSyndicat" method="post">
                    <input type="hidden" name="Nom" value="${syndicat.getAdresse()}">
                    <input type="submit" value="Delete">
                </form>
            </td>                
        </tr>
      </#list>
    </table>
    <p>
      <form action="/createSyndicat" method="get">
        <input type="submit" value="Créer un nouvel Syndicat">
      </form>
    </p>
</body>
</html>