<#macro login path isRegisterForm>

    <style type="text/css">
        .black-background {
            background-color: #dad2e9;
        }
    </style>

    <form action="${path}" method="post" xmlns="http://www.w3.org/1999/html">

        <#if isRegisterForm>
            <div class="mb-3">
                <label for="exampleFormControlInput1" class="form-label">Имя:</label>
                <br>
                <div class="col-sm-6">
                    <input type="text" class="form-control" name="name" placeholder="имя" required/>
                </div>
            </div>
        </#if>

        <#if isRegisterForm>
            <div class="mb-3">
                <label for="exampleFormControlInput1" class="form-label">Фамилия:</label>
                <br>
                <div class="col-sm-6">
                    <input type="text" class="form-control" name="surname" placeholder="фамилия"/>
                </div>
            </div>
        </#if>

        <#if isRegisterForm>
            <div class="mb-3">
                <label for="exampleFormControlInput1" class="form-label">Адрес элктронной почты:</label>
                <br>
                <div class="col-sm-6">
                    <input type="email" class="form-control" name="email" placeholder="name@example.com" required/>
                </div>
            </div>
        </#if>


        <div class="mb-3">
            <label for="exampleFormControlInput1" class="form-label">Логин:</label>
            <br>
            <div class="col-sm-6">
                <input type="text" class="form-control" name="username" placeholder="логин" required/>
            </div>
        </div>

        <div class="mb-3">
            <label for="inputPassword" class="col-sm-2 col-form-label"> Пароль:</label>
            <br>
            <div class="col-sm-6">
                <input type="password" class="form-control" name="password" placeholder="пароль" required/>
            </div>
        </div>
        <input type="hidden" name="_csrf" value="${_csrf.token}"/>

        <div>
            <button class="btn btn-secondary"
                    type="submit"/><#if isRegisterForm>Зарегистрироваться<#else>Войти</#if> </button>
        </div>
        <br>

        <#if !isRegisterForm> <a href="/registration">Регистрация</a></#if>

    </form>
</#macro>

<#macro logout>
    <form action="/logout" method="post">
        <input type="hidden" name="_csrf" value="${_csrf.token}"/>
        <button class="btn btn-outline-secondary btnbig mr-6" type="submit"/>
        <i class="bi bi-box-arrow-in-left"></i>
        <#--Выйти-->
        </button>
    </form>
</#macro>