<#ftl encoding="utf-8">
<html>
<head>
    <link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
    <h1>Bienvenue dans votre espace personnel ${prenom}</h1>
    <form action="/immeubles" method="get">
        <input type="submit" value="Acceuil">
    </form>
    <h2>Quelques statistiques concernant votre parc immobilier</h2>
    <p>Nombre de logements : ${nbLogement}</p>
    <p>Pourcentage de logements loués : ${nbLogementLoue}%</p>
    <p>Pourcentage de logements vides : ${nbLogementVide}%</p>
    <h2>Vos statistiques par immeuble</h2>
    <table>
        <tr>
            <th>Nom du bâtiment</th>
            <th>Adresse</th>
        </tr>
        <#list immeubles as immeuble>
          <tr>
            <td><a href="/statsImmeuble?nom=${immeuble.nom}&adresse=${immeuble.adresse}&numeroTel=${numeroTel}">${immeuble.nom}</a></td>
            <td>${immeuble.adresse}</td>          
          </tr>
        </#list>
    </table>
</body>
</html>