<#ftl encoding="utf-8">
<html>
<head>
    <link rel="stylesheet" type="text/css" href="src/main/resources/static/style.css">
</head>
<body xmlns="http://www.w3.org/1999/html">
    <h1>Valet Immobillier Co.</h1>
    <h2>créer un nouvel immeuble:</h2>
    <form action="/saveImmeuble" method="post">
        <label for="nom">Nom:</label><br>
        <input type="text" id="nom" name="nom"><br>
        <label for="adresse">Adresse:</label><br>
        <input type="text" id="adresse" name="adresse"><br>
        <label for="syndicatNom">Syndicat Nom:</label><br>
        <input type="text" id="syndicatNom" name="syndicatNom"><br>
        <input type="submit" value="Save">
    </form>
</body>
</html>