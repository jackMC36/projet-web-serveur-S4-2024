<#ftl encoding="utf-8">
<html>
<head>
    <link rel="stylesheet" type="text/css" href="src/main/resources/static/style.css">
    <script>
        function validateFrenchPhoneNumber(num) {
            var regex = /^(0|\+33)[1-9](\d{2}){4}$/;
            return regex.test(num);
        }
        function validateForm() {
            var prenom = document.getElementById("prenom").value;
            var nom = document.getElementById("nom").value;
            var numTel = document.getElementById("numTel").value;

            if(prenom == ""){
                alert("Le prenom de la personne ne peut pas être vide");
                return false;
            }

            if(nom == ""){
                alert("Le nom de la personne ne peut pas être vide");
                return false;
            }

            if (numTel == "") {
                alert("Le numero de la personne ne peut pas être vide");
                return false;
            }

            if (!validateFrenchPhoneNumber(numTel)){
                alert("Le numero doit être de la forme 0XXXXXXXXX ou +33XXXXXXXXX")
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
        <input type="text" id="prenom" name="prenom"><br>

        <label for="nom">Nom:</label><br>
        <input type="text" id="nom" name="nom"><br>

        <label for="numTel">Numero de téléphone:</label><br>
        <input type="text" id="numTel" name="numTel"><br>
        
        <input type="submit" value="Save">
    </form>
</body>
</html>