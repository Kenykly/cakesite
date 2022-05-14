<#import "parts/common.ftlh" as c>

<@c.page>
    <div class=" ms-2 ">
        <p class="h2">Корзина</p>
    </div>

    <#--<#if cakes.isEmpty()=true>-->

        <div class="accordion" id="accordionExample">
            <#list  cakes as cake>
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
                                    <#if cake.decorfilename !=""><strong>Фото торта: </strong>${cake.decorfilename}
                                        <br></#if>
                                    <#if cake.cakeComment !=""><strong>Комментарий: </strong>${cake.cakeComment}</#if>

                                </blockquote>
                            </div>
                        </div>

                    </div>

                    <div class="col-me-8 ms-8 text-right">
                        <p class="text-right">
                            <strong>Стоимость: ${cake.cakePrice} руб.</strong>
                        </p>
                        <a class=" ms-8 " href="${cake.id}">удалить</a>
                    </div>


                    </blockquote>
                </div>
            </#list>
        </div>



        <form method="post" enctype="multipart/form-data">


            <input type="hidden" name="_csrf" value="${_csrf.token}"/>
            <br>


            <div class="ms-3 mt-3 me-6">

                <label class="form-label" for="flexRadioDefault1">
                    <strong>Способ получения заказа</strong>
                </label>
                <div class="form-check form-check-inline">
                    <input class="form-check-input ms-5" type="radio" name="deliveryway" id="delivery" value="delivery"
                           checked>
                    <label class="form-label " for="inlineRadio1">Доставка на дом</label>
                </div>
                <div class="form-check form-check-inline">
                    <input class="form-check-input" type="radio" name="deliveryway" id="pickup" value="pickup">
                    <label class="form-check-label" for="inlineRadio2">Самовывоз</label>
                </div>


                <div class="mt-3">
                    <label for="exampleFormControlTextarea1"><strong>Адрес доставки (при заказе на дом)</strong></label>
                    <div class="width_container4">
                        <input type="text" class="form-control" id="validationCustom03" name="userAdress"
                               rows="3"></textarea>
                    </div>
                </div>

                <div class="mt-3">
                    <label for="exampleFormControlTextarea1"><strong>Выберите день получения заказа</strong></label>
                    <input type="date" id="start" name="orderReadyDate"
                           value="2022-05-22"
                           min="2018-01-01" max="2022-12-31">
                </div>

                <div class="width_container mt-3">
                    <label for="exampleFormControlTextarea1"><strong>Выберите время получения заказа</strong></label>
                    <select class="form-select form-select-sm " name="orderReadyTime">
                        <option value="8:00-10:00">8:00-10:00</option>
                        <option value="10:00-12:00">10:00-12:00</option>
                        <option value="12:00-14:00">12:00-14:00</option>
                        <option value="14:00-16:00">14:00-16:00</option>
                        <option value="16:00-18:00">16:00-18:00</option>
                        <option value="18:00-20:00">18:00-20:00</option>
                    </select>
                </div>


                <label class="form-label mt-2"><b>Номер телефона</b></label>
                <div class="form-group width_container2">
                    <input type="tel" id="phone" name="phone" placeholder="89370689781"
                           pattern="8[0-9]{3}[0-9]{3}[0-9]{4}"
                           required>
                </div>

                <div class="mt-2">
                    <label for="validationCustom03" class="form-label"><b>Комментарий к заказу</b></label>
                    <div class="width_container4">
                        <input type="text" class="form-control" id="validationCustom03" name="orderComment">
                    </div>
                </div>

                <div class="mt-2">
                    <label for="validationCustom03" class="form-label"><b>Сумма заказа (без учета
                            доставки): ${ordersum}</b></label>
                </div>
            </div>
            <br>
            <br>

            <div class="text-center">
                <button type="submit" class="btn btn-secondary btn-lg" <#--id="liveAlertBtn"-->>Оформить заказ</button>
            </div>
        </form>
    <#--<#else>
        <div class=" ms-2 ">
            <p class="h4">Корзина пуста!
                Создать тортик</p>
        </div>
    </#if>-->
    <br>
    <br>
    <br>

</@c.page>