<#import "parts/common.ftlh" as c>

<@c.page>


    <p class="h2">Список заказов</p>
    <br>
    <table  class="table">
        <thead>
        <tr>
            <th>id заказа</th>
            <th>id пользователя</th>
            <th>логин пользователя</th>
            <th>дата заказа</th>
            <th>дата готовности заказа</th>
            <th>сумма заказа</th>
            <th>адрес пользователя</th>
            <th></th>
        </tr>
        </thead>

        <tbody>
        <#list  orders as order>
            <tr>
                <td>${order.id}</td>
                <td>${order.user.id}</td>
                <td>${order.user.username}</td>
                <td>${order.orderDate}</td>
                <td>${order.orderReadyDate}</td>
                <td>${order.orderSum}</td>
                <td>${order.userAdress}</td>
            </tr>
        </#list>
        </tbody>

    </table>
</@c.page>