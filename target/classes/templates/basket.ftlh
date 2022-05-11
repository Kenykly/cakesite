<#import "parts/common.ftlh" as c>

<@c.page>
    <figure class="text-center"><p class="h2">Корзина</p></figure>

    <#list  cakes as cake>

        <div class="container-fluid d-flex h-100 justify-content-center align-items-center p-0">
        <div class="<#--container -->cakeblock">
            <blockquote class="blockquote">
            Количество ярусов: ${cake.stageCount}
            <br>
            Торт рассчитан на ${cake.personCount} человек
            <br>
            Бисквит: ${cake.biscuit.tastename}
            <br>
            Крем: ${cake.cream.tastename}
            <br>
            Начинка: ${cake.filling.tastename}
            <br>
            <#if cake.decorDescription !="">Описание декора: ${cake.decorDescription}<br></#if>
            <#if cake.decorfilename !="">Фото торта: ${cake.decorfilename}<br></#if>
            Комментарий: ${cake.cakeComment}
            <br>
                <div class="col-md-6 text-right">
                <strong>Стоимость: ${cake.cakePrice}</strong>
                </div>
            </blockquote>
        </div>
        </div>

    </#list>



    <div class="d-grid gap-2 col-3 mx-auto mt-1">
        <button type="submit" class="btn btn-secondary" id="liveAlertBtn">Оформить заказ</button>
    </div>

</@c.page>