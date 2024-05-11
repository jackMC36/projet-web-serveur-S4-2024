<#ftl encoding="utf-8">
<html>
<head>
<<<<<<< HEAD
    <link rel="stylesheet" type="text/css" href="src/main/resources/static/style.css">
=======
    <link rel="stylesheet" type="text/css" href="style.css">
>>>>>>> 9a5cd6125b9be32a182c15696f870ce8b679c2c1
    <script>
        function validateFrenchPhoneNumber(num) {
            var regex = /^(0|\+33)[1-9](\d{2}){4}$/;
            return regex.test(num);
        }

        function validateEmail(email) {
            var regex = /^[^\s@]+@[^\s@]+\.[^\s@]{2,}$/;
            return regex.test(email);
        }

        function validateForm() {
            var numTel = document.getElementById("numTel").value;
            var email = document.getElementById("adresse_mail").value;

            if (numTel == "") {
                alert("Le numero du syndicat ne peut pas être vide");
                return false;
            }

            if (!validateFrenchPhoneNumber(numTel)) {
                alert("Le numero du syndicat n'est pas valide");
                return false;
            }

            if (email == "") {
                alert("L'adresse mail du syndicat ne peut pas être vide");
                return false;
            }

            if (!validateEmail(email)) {
                alert("L'adresse mail du syndicat n'est pas valide");
                return false;
            }
        }
    </script>
</head>
<body>
    <h1>Valet Immobillier Co.</h1>
    <h2>créer un nouveau Syndicat:</h2>
    <form action="/saveSyndicat" onsubmit="return validateForm()" method="post">
<<<<<<< HEAD
        <label for="nom">Nom:</label><br>
        <input type="text" id="nom" name="nom"><br>

        <label for="adresse">Adresse:</label><br>
        <input type="text" id="adresse" name="adresse"><br>

        <label for="prenomRef">Prénom de la personne référente:</label><br>
        <input type="text" id="prenomRef" name="prenomRef"><br>

        <label for="nomRef">Nom de la personne référente:</label><br>
        <input type="text" id="nomRef" name="nomRef"><br>

        <label for="numTel">Numero de téléphone:</label><br>
        <input type="text" id="numTel" name="numTel"><br>

        <label for="adresse_mail">Adresse mail:</label><br>
        <input type="text" id="adresse_mail" name="adresse_mail"><br>
        
        <input type="submit" value="Save">
    </form>s
=======
        <p>
            <label for="nom">Nom:</label><br>
            <input type="text" id="nom" name="nom"><br>
        </p>

        <p>
            <label for="adresse">Adresse:</label><br>
            <input type="text" id="adresse" name="adresse"><br>
        </p>

        <p>
            <label for="prenomRef">Prénom de la personne référente:</label><br>
            <input type="text" id="prenomRef" name="prenomRef"><br>
        </p>

        <p>
            <label for="nomRef">Nom de la personne référente:</label><br>
            <input type="text" id="nomRef" name="nomRef"><br>
        </p>

        <p>
            <label for="numTel">Numero de téléphone:</label><br>
            <input type="text" id="numTel" name="numTel"><br>
        </p>

        <p>
            <label for="adresse_mail">Adresse mail:</label><br>
            <input type="text" id="adresse_mail" name="adresse_mail"><br>
        </p>
        
        <input type="submit" value="Save">
    </form>
>>>>>>> 9a5cd6125b9be32a182c15696f870ce8b679c2c1
</body>
</html>