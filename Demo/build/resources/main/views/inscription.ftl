<#ftl encoding="utf-8">
<html>
<head>
    <title>Inscription</title>
    <link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
    <h2>Créer un compte</h2>
    <form action="/saveCompte" method="post">
        <p>
            <label for="numTel">Nouveau numéro de téléphone :</label><br>
            <input type="numTel" id="numTel" name="numTel" required><br>
        </p>

        <p>
            <label for="newPassword">Nouveau mot de passe :</label><br>
            <input type="password" id="mdp" name="mdp" required><br>
        </p>

        <input type="submit" value="Créer un compte">
    </form>
    <p> Vous avez déjà un compte ? Rendez-vous <a href="/connexion">ici</a>.
</body>
</html>