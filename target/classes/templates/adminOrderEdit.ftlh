<#import "parts/common.ftlh" as c>

<@c.page>

    <form action="/adminorders"  method="post">
        <table class="table">
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
                <th>статус заказа</th>
                <#--<th></th>-->
            </tr>
            </thead>

            <tbody>
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
                <td>
                    <div class="width_container <#--ms-5  mt-3-->">
                        <input type="hidden" value="${order.id}" name="orderId">
                        <select class="form-select form-select-sm " name="orderStatus">
                            <option value="Ожидает_Подтверждения">Ожидает Подтверждения</option>
                            <option value="Подтвержден">Подтвержден</option>
                            <option value="Ждет_Оплаты">Ждет Оплаты</option>
                            <option value="Оплачен">Оплачен</option>
                            <option value="Готовится">Готовится</option>
                            <option value="В_доставке">В доставке</option>
                            <option value="Завершен">Завершен</option>
                        </select>
                    </div>
                </td>
            </tr>
            </tbody>
        </table>

        <input type="hidden" value="${_csrf.token}" name = "_csrf">

        <div class="text-center" >
            <button  type="submit" class="btn btn-secondary btn-lg">Изменить статус заказа</button>
        </div>

    </form>
    <#list  order.cakes as cake>

        <div class="cakeblock">
            <div class="accordion-item">
                <h2 class="accordion-header" id="heading${cake.id}">
                    <button class="accordion-button" type="button" data-bs-toggle="collapse"
                            data-bs-target="#collapse${cake.id}" aria-expanded="false"
                            aria-controls="collapse${cake.id}">
                        Торт ${cake_index+1} <br>
                    </button>
                </h2>

                <div id="collapse${cake.id}" class="accordion-collapse collapse show"
                     aria-labelledby="heading${cake.id}" data-bs-parent="#accordionExample">
                    <div class="accordion-body">
                        <blockquote class="blockquote">
                            <strong>Количество ярусов: </strong>${cake.stageCount}
                            <br>
                            <strong>Форма: </strong>${cake.cakeForm}
                            <br>
                            <strong>Торт рассчитан на </strong>${cake.personCount} <strong>человек</strong>
                            <br>
                            <strong>Бисквит: </strong>${cake.biscuit.tastename}
                            <br>
                            <strong>Крем: </strong>${cake.cream.tastename}
                            <br>
                            <strong>Начинка: </strong>${cake.filling.tastename}
                            <br>
                            <#if cake.decorDescription !=""><strong>Описание
                                декора: </strong>${cake.decorDescription}<br></#if>

                            <#if cake.cakeComment !=""><strong>Комментарий: </strong>${cake.cakeComment}</#if><br>
                            <#if cake.decorfilename !=""><strong>Фото торта: <#--</strong>${cake.decorfilename}
                                <br>--></#if>
                                <#if cake.decorfilename!="">
                                    <img width="200" src="/img/${cake.decorfilename}">
                                </#if>

                        </blockquote>
                    </div>
                </div>

            </div>
            <div class="col-me-8 ms-8 text-right">
                <p class="text-right">
                    <strong>Стоимость: ${cake.cakePrice} руб.</strong>
                </p>
            </div>
        </div>



    </#list>
</@c.page>