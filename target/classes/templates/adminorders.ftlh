<#import "parts/common.ftlh" as c>

<@c.page>


    <p class="h2">Список заказов</p>
    <br>
    <table  class="table">
        <thead>
        <tr>
            <th>id заказа</th>
            <th>логин пользователя</th>
            <th>имя пользователя</th>
            <th>фамилия пользователя</th>
            <th>заказ создан</th>
            <th>будет получен</th>
            <th>сумма заказа</th>
            <th>способ получения</th>
            <th>комментарий</th>
            <th>номер телефона</th>
            <th>статус<br>заказа</th>

            <th></th>
        </tr>
        </thead>

        <tbody>
        <#list  orders as order>
            <tr>
                <td>${order.id}</td>
                <td>${order.user.username}</td>
                <td>${order.user.name?ifExists}</td>
                <td>${order.user.surname?ifExists}</td>
                <td>${order.orderDate}</td>
                <td>${order.orderReadyDate}</td>
                <td>${order.orderSum}</td>
                <#if !order.pickup>
                <td>доставка по адресу: ${order.userAdress?ifExists}</td>
                <#else>
                <td>самовывоз</td>
                </#if>

                <td>${order.orderComment?ifExists}</td>
                <td>${order.phone}</td>
                <td>${order.orderStatus}</td>

                <td><button class="btn btn-outline-secondary mr-1 me-1" type="submit"/>
                    <i class="bi bi-gear-fill"></i>
                    </button> <#--<input type="hidden" name="_csrf" value="${_csrf.token}"/>--></td>
            </tr>
        </#list>
        </tbody>

    </table>
</@c.page>