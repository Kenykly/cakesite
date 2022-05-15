<#include "security.ftlh">
<#import "login.ftlh" as l>

<#--https://www.youtube.com/watch?v=QXQOwyQLdTk&t=527s  подвал сайта-->
<nav class="navbar navbar-expand-md navbar-light bg-orange">
    <div class="container-fluid">

        <a href="/" class="navbar-brand"> <img src="../../static/pictures/logo.png" alt="logo"/></a>

        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
                aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">

                <li class="navbar-brand">
                    <a class="nav-link active" aria-current="page" href="/">Главная страница</a>
                </li>

                <#if !isAdmin>
                    <li class="navbar-brand">
                        <a class="nav-link active" aria-current="page" href="/make">Создать торт</a>
                    </li>
                </#if>

                <li class="navbar-brand">
                    <a class="nav-link active" aria-current="page" href="/howtoorder">Как заказать</a>
                </li>

                <li class="navbar-brand">
                    <a class="nav-link active" aria-current="page" href="/aboutus">О нас</a>
                </li>

                <li class="navbar-brand">
                    <a class="nav-link active" aria-current="page" href="https://forms.yandex.ru/cloud/6281264fa7858a61e1c98fe6/">Свяжитесь с нами</a>
                </li>

                <#if isAdmin>
                    <li class="navbar-brand">
                        <a class="nav-link active" aria-current="page" href="/adminuserslist">Пользователи</a>
                    </li>
                </#if>

                <#if isAdmin>
                    <li class="navbar-brand">
                        <a class="nav-link active" aria-current="page" href="/adminorders">Заказы</a>
                    </li>
                </#if>


            </ul>


            <ul class="navbar-nav me-6">
                <button class="btn btn-outline-secondary btnbig mr-3 me-2">
                    <a href="/basket"></a> <i class="bi bi-telegram"></i>
                </button>

                <#if !isAdmin>
                <form action="/login" method="get">
                    <input type="hidden" name="_csrf" value="${_csrf.token}"/>
                    <button class="btn btn-outline-secondary btnbig mr-3 me-2" type="submit"/>
                    <i class="bi bi-person"></i>
                    </button>
                </form>
                </#if>

                <#if !isAdmin>
                <form action="/basket" method="get">
                    <input type="hidden" name="_csrf" value="${_csrf.token}"/>
                    <button class="btn btn-outline-secondary btnbig mr-3 me-2" type="submit"/>
                    <i class="bi bi-cart"></i>
                    </button>
                </form>
                </#if>


            </ul>

            <#if name !="unknown"><@l.logout/></#if>
        </div>

    </div>
</nav>
