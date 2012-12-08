<g:applyLayout name="main">
    <g:form method="get" action="update" id="${user.id}">
        <p>Name:</p>
        <p><g:textField name="nickname" value="${user.nickname}"/></p>

        <p>Name:</p>

        <p><g:textField name="name" value="${user.name}"/></p>

        <p>Name:</p>

        <p><g:textField name="email" value="${user.email}"/></p>

        %{--<p>Name:</p>--}%

        %{--<p><g:textField name="password" value="${user.password}"/></p>--}%
        <input type="submit" value="Save">
        %{--<g:actionSubmit value="save" />--}%
    </g:form>
</g:applyLayout>