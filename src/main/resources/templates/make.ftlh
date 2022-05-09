<#import "parts/common.ftlh" as c>

<@c.page>
    <div class=" ms-5 ">
    <p class="h2">Создай свой торт</p>
    </div>


        <div class="block">
            <form method="post" enctype="multipart/form-data" >

                <label class="form-check-label ms-5 mt-3" for="flexRadioDefault1">
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

                <input type="hidden" name="_csrf" value="${_csrf.token}" />
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
                    <select class="form-select form-select-sm " name = "fillingname">
                        <option selected>Выберите начинку</option>
                        <option value="Карамель">Карамель</option>
                        <option value="Вишня">Вишня</option>
                        <option value="Шоколад+арахис">Шоколад+арахис</option>
                        <option value="Шоколад">Шоколад</option>
                    </select>
                </div>


                <label class="ms-5  mt-3">
                    <b> Бисквит</b>
                </label>
                <div class="width_container ms-5  mt-3">
                    <select class="form-select form-select-sm" name = "biscuitname">
                        <option selected>Выберите бисквит</option>
                        <option value="Ванильный">Ванильный</option>
                        <option value="Шоколадный">Шоколадный</option>
                        <option value="Пряная вишня">Пряная вишня</option>
                        <option value="Шифоновый">Шифоновый</option>
                    </select>
                </div>


                <p class="ms-5 mt-3">
                    <b> Крем</b>
                </p>
                <div class="width_container ms-5  mt-3">

                    <select class="form-select form-select-sm " name = "creamname">
                        <option selected>Выберите крем</option>
                        <option value="Крем-чиз">Крем-чиз</option>
                        <option value="Пломбир">Пломбир</option>
                        <option value="Крем чиз шоколадный">Крем чиз шоколадный</option>
                        <option value="Кофейный">Кофейный</option>
                    </select>
                </div>


                <div class="width_container3 ms-5  mt-3">
                    <label for="validationCustom01" class="form-label"><b>Количество человек</b></label>
                    <input type="number" class="form-control" id="validationCustom01" value="6" name = "personCount" required>
                </div>

                <div class="width_container ms-5  mt-3">
                    <div class="mb-3">
                        <label for="formFile" class="form-label"><b>Декор</b></label>
                        <input type="file" name="file" id="customFile">
                    </div>
                </div>

                <div class="form-group width_container2 ms-5  mt-2">
                    <label for="exampleFormControlTextarea1">Опишите декор</label>
                    <textarea class="form-control" id="exampleFormControlTextarea1"  name = "decorDescription"  rows="3"></textarea>
                </div>


                <div class="width_container2 ms-5 mt-3">
                    <label for="validationCustom03" class="form-label"><b>Комментарий</b></label>
                    <input type="text" class="form-control" id="validationCustom03" name = "cakeComment">
                </div>

                <p class="ms-5 mt-3">
                    <b> Итоговая стоимость:</b>
                </p>


                <div class="d-grid gap-2 col-3 mx-auto mt-1">
                    <button type="submit" class="btn btn-secondary">Рассчитать</button>
                </div>

                <div class="d-grid gap-2 col-3 mx-auto mt-1">
                    <button type="submit" class="btn btn-secondary">Добавить</button>
                </div>

            </form>
        </div>

</@c.page>