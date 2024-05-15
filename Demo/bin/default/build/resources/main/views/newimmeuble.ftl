<#ftl encoding="utf-8">
<html>
<head>
    <link rel="stylesheet" type="text/css" href="style.css">
    <script>
        function validateForm() {
            var nom = document.getElementById("nom").value;
            var adresse = document.getElementById("adresse").value;
            var SyndicatNom = document.getElementById("syndicatNom").value;

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
    <h2>Créer un nouvel immeuble :</h2>
    <form action="/saveImmeuble" onsubmit="return validateForm()" method="post">
        <p>
            <label for="nom">Nom du bâtiment :</label><br>
            <input type="text" id="nom" name="nom"><br>
        </p>

        <p>
            <label for="adresse">Adresse :</label><br>
            <input type="text" id="adresse" name="adresse"><br>
        </p>

        <p>
            <label for="syndicatNom">Nom du syndicat :</label><br>
            <input type="text" id="syndicatNom" name="syndicatNom"><br>
        </p>

        <input type="submit" value="Save">
    </form>
</body>
</html>