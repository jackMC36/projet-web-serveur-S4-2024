<#ftl encoding="utf-8">
<html>
<head>
    <link rel="stylesheet" type="text/css" href="style.css">
</head>
<body xmlns="http://www.w3.org/1999/html">
    <h1>Valet Immobillier Co.</h1>
<<<<<<< HEAD
=======
    <form action="/stats" method="get">
        <input type="hidden" name="numeroTel" value="0783087187">
        <input type="hidden" name="prenom" value="Killian">
        <input type="submit" value="Mon parc immobilier">
    </form>
    <form action="/connexion" method="get">
        <input type="submit" value="Connexion">
    </form>
>>>>>>> 3aa5dde958bc7c32c22c6b93c7418f3268a97e17
    <form action="/syndicats" method="get">
        <input type="submit" value="Syndicats">
    </form>
    <form action="/personnes" method="get">
        <input type="submit" value="Personnes">
    </form>
    <h2>List d'Immeubles</h2>
    <table>
        <tr>
            <th>Nom du bâtiment</th>
            <th>Adresse</th>
            <th>Nom du syndicat</th>
            <th></th>
        </tr>
        <#list immeubles as immeuble>
          <tr>
            <td><a href="/appartements?adresse=${immeuble.adresse}&immeubleNom=${immeuble.nom}">${immeuble.nom}</a></td>
            <td>${immeuble.adresse}</td>
            <td>${immeuble.getSyndicatNom()}</td>
            <td>
                <form action="/deleteImmeuble" method="post">
                    <input type="hidden" name="adresse" value="${immeuble.adresse}">
                    <input type="submit" value="Delete">
                </form>
            </td>                
          </tr>
        </#list>
    </table>
    <p>
      <form action="/createImmeuble" method="get">
        <input type="submit" value="Créer un nouvel Immeuble">
      </form>
    </p>
</body>
</html>