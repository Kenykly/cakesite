<#import "parts/common.ftlh" as c>

<@c.page>
    <p class="h2">Список пользователей</p>
    <br>
    <table  class="table">
        <thead>
        <tr>
        <th>Логин</th>
        <th>Имя</th>
        <th>Фамилия</th>
        <th>Роль</th>
        <th></th>
        </tr>
        </thead>

        <tbody>
        <#list  users as user>
            <tr>
                <td>${user.username}</td>
                <td>${user.name?ifExists}</td>
                <td>${user.surname?ifExists}</td>
                <td><#list user.roles as role>${role}<#sep>, </#list></td>
                <td><a href="/adminuserslist/${user.id}">редактировать роль</a> </td>
            </tr>
        </#list>
        </tbody>

    </table>
</@c.page>