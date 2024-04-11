<#ftl encoding="utf-8">

<body xmlns="http://www.w3.org/1999/html">

<ul>
    <#list immeubles as immeuble>
        <li>${immeuble.nom} - ${immeuble.numero} ${immeuble.adresse} - ${immeuble.syndicat}</li>
    </#list>
</ul>

</body>

</html>
