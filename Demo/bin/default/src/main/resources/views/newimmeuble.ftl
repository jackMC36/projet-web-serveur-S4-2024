<#ftl encoding="utf-8">
<html>
<head>
    <link rel="stylesheet" type="text/css" href="src/main/resources/static/style.css">
    <script>
        function validateForm() {
            var syndicatNom = document.getElementById("syndicatNom").value;
            var syndicatAdresse = document.getElementById("adresse").value;
            var SyndicatNom = document.getElementById("nom").value;

            if(nom = ""){
                alert("Le nom de l'immeuble ne peut pas être vide");
                return false;
            }

            if(adresse == ""){
                alert("L'adresse de l'immeuble ne peut pas être vide");
                return false;
            }

            if (syndicatNom == "") {
                alert("Le nom du syndicat ne peut pas être vide");
                return false;
            }
        }
    </script>

</head>
<body xmlns="http://www.w3.org/1999/html">
    <h1>Valet Immobillier Co.</h1>
    <h2>créer un nouvel immeuble:</h2>
    <form action="/saveImmeuble" onsubmit="return validateForm()" method="post">
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