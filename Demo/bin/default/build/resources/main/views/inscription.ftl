<#ftl encoding="utf-8">
<html>
<head>
    <title>Inscription</title>
    <link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
    <h2>Créer un compte</h2>
    <form action="/signup" method="post">
        <p>
            <label for="newEmail">Nouvelle adresse e-mail :</label><br>
            <input type="email" id="newEmail" name="newEmail" required><br>
        </p>

        <p>
            <label for="newPassword">Nouveau mot de passe :</label><br>
            <input type="password" id="newPassword" name="newPassword" required><br>
        </p>

        <input type="submit" value="Créer un compte">
    </form>
    <p> Vous avez déjà un compte ? Rendez-vous <a href="/connexion">ici</a>.
</body>
</html>