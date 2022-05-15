<#import "parts/common.ftlh" as c>
<#import "parts/login.ftlh" as l>

<@c.page>

    ${message?ifExists}
    <p class="h2">Авторизация</p>
    <@l.login "/login" false/>

</@c.page>