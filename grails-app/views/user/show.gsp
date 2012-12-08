<g:applyLayout name="main">
    <g:form method="post" action="update" id="${user.id}" enctype="multipart/form-data">
        <p>Name:</p>
        <p><g:textField name="nickname" value="${user.nickname}"/></p>

        <p>Name:</p>

        <p><g:textField name="name" value="${user.name}"/></p>

        <p>Name:</p>

        <p><g:textField name="email" value="${user.email}"/></p>


        <input type="submit" value="Save">
    </g:form>

    <g:form action="updateAvatar" method="post" enctype="multipart/form-data" id="${user.id}">
        <p>Avatar:</p>
        <img src="${user.avatar}" alt="">
        <input type="file" name="avatar" />
        <input type="submit" value="Save">
    </g:form>
</g:applyLayout>