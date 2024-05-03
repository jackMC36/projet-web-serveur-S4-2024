<#ftl encoding="utf-8">
<html>
<head>
    <link rel="stylesheet" type="text/css" href="src/main/resources/static/style.css">
    <script>
        function validateForm() {
            var syndicatNom = document.getElementById("syndicatNom").value;
            var syndicatAdresse = document.getElementById("adresse").value;
            var SyndicatNom = document.getElementById("nom").value;

<<<<<<< HEAD
            if(prenom = ""){
                alert("Le prenom de la personne ne peut pas être vide");
                return false;
            }

            if(nom == ""){
                alert("Le nom de la personne ne peut pas être vide");
                return false;
            }

            if (numTel == "") {
                alert("Le numero de la personne ne peut pas être vide");
=======
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
>>>>>>> e7a52ad18f5359968a8e302a66f24bd1e5696fac
                return false;
            }
        }
    </script>

</head>
<body xmlns="http://www.w3.org/1999/html">
    <h1>Valet Immobillier Co.</h1>
    <h2>créer un nouvelle Personne:</h2>
    <form action="/savePersonne" onsubmit="return validateForm()" method="post">
        <label for="prenom">Prénom:</label><br>
        <input type="text" id=">>Prenom" name="prenom"><br>
        <label for="nom">Nom:</label><br>
        <input type="text" id="nom" name="nom"><br>
        <label for="numTel">Numero de téléphone:</label><br>
        <input type="text" id="numtel" name="numtel"><br>
        <input type="submit" value="Save">
    </form>
</body>
</html>