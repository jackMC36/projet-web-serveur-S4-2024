<#ftl encoding="utf-8">
<html>
<head>
    <link rel="stylesheet" type="text/css" href="src/main/resources/static/style.css">
</head>
<body xmlns="http://www.w3.org/1999/html">
    <h1>Liste des appartements de ${immeubleNom}</h1>
    <ul>
        <#list appartements as appartement>
            <li>
                ${appartement.etage} - ${appartement.numero} - ${appartement.superficie} - <#if appartement.estLoue==0> A louer <#else> Occupé </#if> - ${appartement.adresse}
                <form action="/deleteAppartement" method="post">
                    <input type="hidden" name="ApptId" value="${appartement.getNumero()},${appartement.getAdresse()}">
                    <input type="submit" value="Delete">
                </form>
            </li>
        </#list>
    </ul>
</body>
</html>