<#import "parts/common.ftlh" as c>
<#import "parts/login.ftlh" as l>

<@c.page>
    <div class="mb-1">
    <p class="h2">Регистрация</p></div>
    <#if message??>
    ${message}
    </#if>
    <@l.login "/registration" true/>
</@c.page>