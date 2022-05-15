<#import "parts/common.ftlh" as c>

<@c.page>
    <div>Главная страница</div>
<div>Примеры наших тортов</div>
    <img src="file:///E:/diplom/studing/src/main/resources/templates/img/main2.jpg" class="img-thumbnail" alt="...">
    <div class="row">
        <div class="col-md-4">
            <div class="thumbnail">
                <a href="/static/main1.png">
                    <img src="/static/main1.png" alt="Lights" style="width:100%">
                    <div class="caption">
                        <p>Lorem ipsum...</p>
                    </div>
                </a>
            </div>
        </div>
        <div class="col-md-4">
            <div class="thumbnail">
                <a href="/static/pictures/main2.jpg">
                    <img src="/static/pictures/main2.jpg" alt="Nature" style="width:100%">
                    <div class="caption">
                        <p>Lorem ipsum...</p>
                    </div>
                </a>
            </div>
        </div>
        <div class="col-md-4">
            <div class="thumbnail">
                <a href="/static/pictures/main3.jpg">
                    <img src="/static/pictures/main3.jpg" alt="Fjords" style="width:100%">
                    <div class="caption">
                        <p>Lorem ipsum...</p>
                    </div>
                </a>
            </div>
        </div>
    </div>
</@c.page>