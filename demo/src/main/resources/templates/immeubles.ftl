<!DOCTYPE html>
<html>
<body>
    <h1>Immeubles</h1>
    <ul>
        <#list immeubles as immeuble>
            <li>Nom: ${immeuble.nom}, Adresse: ${immeuble.adresse}, Numero: ${immeuble.numero}</li>
        </#list>
    </ul>
</body>
</html>