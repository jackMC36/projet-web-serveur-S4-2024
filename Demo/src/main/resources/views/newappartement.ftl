<#ftl encoding="utf-8">
<html>
<head>
    <link rel="stylesheet" type="text/css" href="style.css">
    <script>
        function validateForm() {
            var etage = document.getElementById("etage").value;
            var numero = document.getElementById("numero").value;
            var superficie = document.getElementById("superficie").value;
            var estLoue = document.getElementById("estLoue").value;

            if(etage = ""){
                alert("Le numéro de l'étage ne peut pas être vide");
                return false;
            }

            if(numero = ""){
                alert("Le numéro de l'appartement ne peut pas être vide");
                return false;
            }

            if(superficie = ""){
                alert("La superficie de l'appartement ne peut pas être vide");
                return false;
            }
        }
    </script>
</head>
<body xmlns="http://www.w3.org/1999/html">
    <h1>Valet Immobillier Co.</h1>
    <h2>Créer un nouvel appartement dans ${immeubleNom}</h2>
    <form action="/saveAppartement" onsubmit="return validateForm()" method="post">
        <input type="hidden" name="immeubleNom" value="${immeubleNom}"/>

        <p>
            <label for="etage">Numéro de l'étage :</label><br>
            <input type="number" id="etage" name="etage"><br>
        </p>

        <p>
            <label for="numero">Numéro de l'appartement :</label><br>
            <input type="number" id="numero" name="numero"><br>
        </p>

        <p>
            <label for="superficie">Superficie de l'appartement :</label><br>
            <input type="number" id="superficie" name="superficie" step="0.1"><br>
        </p>

        <input type="hidden" name="adresse" value="${adresseImmeuble}"/>
        <p>Adresse : ${adresseImmeuble}</p>

        <input type="hidden" name="estLoue" value="${0}"/>

        <input type="submit" value="Save">
    </form>
</body>
</html>