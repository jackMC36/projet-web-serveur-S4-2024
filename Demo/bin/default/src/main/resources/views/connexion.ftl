<#ftl encoding="utf-8">
<html>
<head>
    <title>Connexion</title>
    <link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
    <h2>Connexion</h2>
    <form action="/login" method="post">
        <p>
            <label for="email">Adresse e-mail :</label><br>
            <input type="email" id="email" name="email" required><br>
        </p>

        <p>
            <label for="password">Mot de passe :</label><br>
            <input type="password" id="password" name="password" required><br>
        </p>

        <input type="submit" value="Se connecter">
    </form>
    <p> Pas encore de compte ? <a href="inscription.ftl">Inscrivez-vous</a>.
</body>
</html>
