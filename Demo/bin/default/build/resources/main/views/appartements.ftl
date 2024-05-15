<#ftl encoding="utf-8">
<html>
<head>
    <link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
    <h2>Liste des appartements de ${immeubleNom}</h2>
    <table>
      <tr>
        <th>Etage</th>
        <th>Numero</th>
        <th>Superficie</th>
        <th>Adresse</th>
        <th>Statut</th>
        <th></th>
      </tr>
      <#list appartements as appartement>
        <tr>
            <td>${appartement.etage}</td>
            <td><a href="/occupations?numeroAppt=${appartement.numero}&adresseAppt=${appartement.adresse}">${appartement.numero}</a></td>
            <td>${appartement.superficie}</td>
            <td>${appartement.adresse}</td>
            <td><#if appartement.estLoue==0> A louer <#else> Occupé </#if></td>
            <td>
                <form action="/deleteAppartement" method="post">
                    <input type="hidden" name="numero" value="${appartement.numero}">
                    <input type="hidden" name="adresse" value="${appartement.adresse}">
                    <input type="hidden" name="immeubleNom" value="${immeubleNom}">
                    <input type="submit" value="Delete">
                </form>
            </td>                
        </tr>
      </#list>
    </table>
    <p>
      <form action="/createAppartement" method="get">
        <input type="hidden" name="immeubleNom" value="${immeubleNom}">
        <input type="hidden" name="adresseImmeuble" value="${adresse}">
        <input type="submit" value="Créer un nouvel Appartement">
      </form>
    </p>
</body>
</html>