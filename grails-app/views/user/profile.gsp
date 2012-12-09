<g:applyLayout name="main">
    <div class="profile-wrapper">
   <div class="profile-form-wrapper" style="float: left;">
    <g:form method="post" action="update" id="${user.id}" enctype="multipart/form-data">

        <div class="field-box">
            <div class="field-help">Логин:</div>
            <g:textField name="nickname" value="${user.nickname}"/>
            <div class="clear"></div>
        </div>

        <div class="field-box">
            <div class="field-help">Полное имя:</div>
            <g:textField name="name" value="${user.name}"/>
            <div class="clear"></div>
        </div>

        <div class="field-box">
            <div class="field-help">E-mail:</div>
            <g:textField name="email" value="${user.email}"/>
            <div class="clear"></div>
        </div>

        <input type="submit" value="Сохранить">

    </g:form>
   </div>

    <div class="profile-form-wrapper" style="float: right; border-left: 1px solid grey;">
    <g:form action="updateAvatar" method="post" enctype="multipart/form-data" id="${user.id}">

        <img src="${user.avatar}" alt="">
        <div class="field-box">
            <div class="field-help">Аватарк:</div>
            <input type="file" name="avatar" />
            <div class="clear"></div>
        </div>

        <input type="submit" value="Сохранить">
    </g:form>
    </div>

    <div class="clear"></div>
    </div>
</g:applyLayout>