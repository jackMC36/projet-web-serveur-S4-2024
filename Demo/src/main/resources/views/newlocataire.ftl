<#ftl encoding="utf-8">
<html>
<head>
    <link rel="stylesheet" type="text/css" href="style.css">
    <script>
        function validateFrenchPhoneNumber(num) {
            var regex = /^(0)[1-9](\d{2}){4}$/;
            return regex.test(num);
        }

        function validateForm() {
            var numeroTel = document.getElementById("numeroTel").value;

            if (numeroTel == "") {
                alert("Le numero de téléphone ne peut pas être vide");
                return false;
            }

            if (!validateFrenchPhoneNumber(numeroTel)){
                alert("Le numero doit être de la forme 0XXXXXXXXX")
                return false;
            }
        }
    </script>
</head>
<body xmlns="http://www.w3.org/1999/html">
    <h1>Valet Immobillier Co.</h1>
    <h2>Ajouter un nouveau locataire dans le n°${numeroAppt} au ${adresseAppt}</h2>
    <form action="/saveLocataire" onsubmit="return validateForm()" method="post">
        <p>
            <label for="numeroTel">Numéro de téléphone du locataire :</label><br>
            <input type="number" id="numeroTel" name="numeroTel"><br>
        </p>

        <input type="hidden" name="numeroAppt" value="${numeroAppt}"/>

        <input type="hidden" name="adresseAppt" value="${adresseAppt}"/>

        <input type="submit" value="Save">
    </form>
</body>
</html>