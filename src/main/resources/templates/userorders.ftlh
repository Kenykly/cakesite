<#import "parts/common.ftlh" as c>

<@c.page>
    <p class="h2">Список ваших заказов</p>
    <br>
    <table class="table">
        <thead>
        <tr>
            <th>номер заказа</th>
            <th>дата создания заказа</th>
            <th>дата получения заказа</th>
            <th>адрес получения заказа</th>
            <th>сумма заказа</th>
            <th>комментарий</th>
            <th>номер телефона</th>
            <th>статус заказа</th>
            <th></th>
        </tr>
        </thead>

        <tbody>
        <#list  orders as order>
            <tr>
                <td>${order.id}</td>
                <#--<td>${order.orderDate}</td>-->
                <td>${order.orderDate}</td>
                <td>${order.orderReadyDate}</td>
                <td>${order.userAdress?ifExists}</td>
                <td>${order.orderSum}</td>
                <td>${order.orderComment?ifExists}</td>
                <td>${order.phone}</td>
                <td>${order.orderStatus}</td>
                <#--<td><button class="btn btn-outline-secondary mr-1 me-1" type="submit"/>
                    <i class="bi bi-info-circle"></i>
                    &lt;#&ndash;</button> <input type="hidden" name="_csrf" value="${_csrf.token}"/>&ndash;&gt;</td>-->
            </tr>

        </#list>
        </tbody>

    </table>
</@c.page>