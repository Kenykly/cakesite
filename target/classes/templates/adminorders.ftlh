<#import "parts/common.ftlh" as c>

<@c.page>


    <p class="h2">Список заказов</p>
    <br>
    <table  class="table">
        <thead>
        <tr>
            <th>id заказа</th>
            <th>логин пользователя</th>
            <th>дата создания заказа</th>
            <th>дата получения заказа</th>
            <th>сумма заказа</th>
            <th>адрес пользователя</th>
            <th>комментарий</th>
            <th>номер телефона</th>
            <th>статус заказа</th>
            <th>адрес получения заказа</th>

            <th></th>
        </tr>
        </thead>

        <tbody>
        <#list  orders as order>
            <tr>
                <td>${order.id}</td>
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