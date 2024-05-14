<#ftl encoding="utf-8">
<html>
<head>
    <link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
    <h2>Information sur le n°${numeroAppt} au ${adresseAppt}</h2>
    <h3>Propriétaire(s)</h3>
    <table>
      <tr>
        <th>Prénom</th>
        <th>Nom</th>
        <th>Numéro de téléphone du propriétaire</th>
        <th></th>
      </tr>
      <#list proprios as proprio>
        <tr>
            <td>${proprio.prenom}</td>
            <td>${proprio.nom}</td>
            <td>${proprio.toStringNumTel(proprio.numTel)}</td>
            <td>
                Bouton suppression
            </td>                
        </tr>
      </#list>
    </table>
    <p>
      Bouton création
    </p>
    <h3>Locataire(s)</h3>
    <table>
      <tr>
        <th>Prénom</th>
        <th>Nom</th>
        <th>Numéro de téléphone du locataire</th>
        <th></th>
      </tr>
      <#list locataires as locataire>
        <tr>
            <td>${locataire.prenom}</td>
            <td>${locataire.nom}</td>
            <td>${locataire.toStringNumTel(locataire.numTel)}</td>
            <td>
                <form action="/deleteLocataire" method="post">
                    <input type="hidden" name="numeroTel" value="${locataire.numTel}">
                    <input type="hidden" name="numeroAppt" value="${numeroAppt}">
                    <input type="hidden" name="adresseAppt" value="${adresseAppt}">
                    <input type="submit" value="Retirer ce locataire">
                </form>
            </td>                
        </tr>
      </#list>
    </table>
    <p>
      <form action="/createLocataire" method="get">
        <input type="hidden" name="numeroAppt" value="${numeroAppt}">
        <input type="hidden" name="adresseAppt" value="${adresseAppt}">
        <input type="submit" value="Ajouter un locataire dans cet appartement">
      </form>
    </p>
</body>
</html>