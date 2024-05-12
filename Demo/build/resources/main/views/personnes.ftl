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
    <h2>Liste des personnes :</h2>
    <table>
      <tr>
        <th>Prenom</th>
        <th>Nom</th>
        <th>Numero de téléphone</th>
        <th></th>
      </tr>
      <#list personnes! as personne>
        <tr>
            <td>${personne.getPrenom()}</td>
            <td>${personne.getNom()}</td>
            <td><#if personne.getNumTel()??> ${personne.numTel} <#else> Aucun Numéro </#if></td>
            <td>
                <form action="/deletePersonne" method="post">
                    <input type="hidden" name="numTel" value="${personne.getNumTel()}">
                    <input type="submit" value="Delete">
                </form>
            </td>                
        </tr>
      </#list>
    </table>
    <p>
      <form action="/createPersonne" method="get">
        <input type="submit" value="Créer une nouvelle Personne">
      </form>
    </p>
</body>
</html>
