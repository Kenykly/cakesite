<#import "parts/common.ftlh" as c>

<@c.page>
    <div class=" ms-2 ">
        <p class="h2">Создайте свой торт</p>
    </div>

    <div class="block">
        <form method="post" enctype="multipart/form-data">

            <label class="form-check-label ms-5 mt-2" for="flexRadioDefault1">
                <b> Количество ярусов</b>
            </label>
            <div class="form-check form-check-inline ms-5">
                <input class="form-check-input" type="radio" name="stageCount" id="1" value="1" checked>
                <label class="form-check-label" for="inlineRadio1">1</label>
            </div>
            <div class="form-check form-check-inline">
                <input class="form-check-input" type="radio" name="stageCount" id="2" value="2">
                <label class="form-check-label" for="inlineRadio2">2</label>
            </div>
            <div class="form-check form-check-inline">
                <input class="form-check-input" type="radio" name="stageCount" id="3" value="3">
                <label class="form-check-label" for="inlineRadio3">3</label>
            </div>

            <input type="hidden" name="_csrf" value="${_csrf.token}"/>
            <br>


            <label class="form-check-label ms-5  mt-3" for="flexRadioDefault1">
                <b> Форма</b>
            </label>
            <div class="form-check form-check-inline ms-5">
                <input class="form-check-input" type="radio" name="cakeform" id="circle" value="Круг" checked>
                <label class="form-check-label" for="inlineRadio1">Круг</label>
            </div>
            <div class="form-check form-check-inline">
                <input class="form-check-input" type="radio" name="cakeform" id="square" value="Квадрат">
                <label class="form-check-label" for="inlineRadio2">Квадрат</label>
            </div>
            <div class="form-check form-check-inline">
                <input class="form-check-input" type="radio" name="cakeform" id="heart" value="Сердце">
                <label class="form-check-label" for="inlineRadio3">Сердце</label>
            </div>
            <br>


            <label class="ms-5  mt-3">
                <b> Начинка</b>
            </label>
            <div class="width_container ms-5  mt-3">
                <select class="form-select form-select-sm " name="fillingname">
                    <#-- <option selected>Выберите начинку</option>-->
                    <#list  fillingnames as fillingname>
                        <option value="${fillingname.tastename}">${fillingname.tastename}</option>
                    </#list>
                </select>
            </div>


            <label class="ms-5  mt-3">
                <b> Бисквит</b>
            </label>
            <div class="width_container ms-5  mt-3">
                <select class="form-select form-select-sm " name="biscuitname">
                    <#--<option disabled selected>Выберите бисквит</option>-->
                    <#list  biscuitnames as biscuitname>
                        <option value="${biscuitname.tastename}">${biscuitname.tastename}</option>
                    </#list>
                </select>
            </div>

            <p class="ms-5 mt-3">
                <b> Крем</b>
            </p>
            <div class="width_container ms-5  mt-3">
                <select class="form-select form-select-sm " name="creamname">
                    <#--<option selected>Выберите крем</option>-->
                    <#list  creamnames as creamname>
                        <option value="${creamname.tastename}">${creamname.tastename}</option>
                    </#list>
                </select>
            </div>


            <div class="width_container3 ms-5  mt-3">
                <label for="validationCustom01" class="form-label"><b>Количество человек</b></label>
                <input type="number" class="form-control" id="validationCustom01" value="6" name="personCount" required>
            </div>

            <div class="width_container ms-5  mt-3">
                <div class="mb-3">
                    <label for="formFile" class="form-label"><b>Декор</b></label>
                    <input type="file" name="file" id="customFile">
                </div>
            </div>

            <div class="form-group width_container2 ms-5  mt-2">
                <label for="exampleFormControlTextarea1">Опишите декор</label>
                <textarea class="form-control" id="exampleFormControlTextarea1" name="decorDescription"
                          rows="3"></textarea>
            </div>


            <div class="width_container2 ms-5 mt-3">
                <label for="validationCustom03" class="form-label"><b>Комментарий</b></label>
                <input type="text" class="form-control" id="validationCustom03" name="cakeComment">
            </div>

            <#--<p class="ms-5 mt-3">
                <b> Итоговая стоимость:</b>
            </p>-->

            <#-- <div class="d-grid gap-2 col-3 mx-auto mt-1">
                 <button type="submit" class="btn btn-secondary">Рассчитать</button>
             </div>-->
            <br>
            <br>

            <div class="d-grid gap-2 col-3 mx-auto mt-1">
                <button type="submit" class="btn btn-secondary" id="liveAlertBtn">Добавить</button>
            </div>


        </form>
    </div>

</@c.page>