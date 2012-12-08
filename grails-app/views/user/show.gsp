<g:applyLayout name="main">
    <g:form method="get" action="update" id="${user.id}" enctype="multipart/form-data">
        <p>Name:</p>
        <p><g:textField name="nickname" value="${user.nickname}"/></p>

        <p>Name:</p>

        <p><g:textField name="name" value="${user.name}"/></p>

        <p>Name:</p>

        <p><g:textField name="email" value="${user.email}"/></p>

        <p>Avatar:</p>
        <input type="file" name="avatar" />

        %{--<p><g:textField name="password" value="${user.password}"/></p>--}%
        <input type="submit" value="Save">
        exit%{--<g:actionSubmit value="save" />--}%
    </g:form>
</g:applyLayout>