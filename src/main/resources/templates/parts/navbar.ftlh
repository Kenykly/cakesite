<#include "security.ftlh">
<#import "login.ftlh" as l>


<nav class="navbar navbar-expand-lg navbar-light bg-orange">
        <a class="navbar-brand" href="/">Cake</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent" >
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="/">Главная страница</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="/main">Сообщения</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="/make">Создать торт</a>
                </li>
                <#if isAdmin>
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="/user">Список пользователей</a>
                </li>
                </#if>
                <#if isAdmin>
                    <li class="nav-item">
                        <a class="nav-link active" aria-current="page" href="/orders">Список заказов</a>
                    </li>
                </#if>
                <#if name ="unknown">
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="/login">Авторизоваться</a>
                </li>
                </#if>
            </ul>
            <div class="navbar-text me-3">${name}</div>
            <#if name !="unknown"><@l.logout/></#if>
        </div>
</nav>
