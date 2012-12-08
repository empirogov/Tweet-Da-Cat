<g:applyLayout name="main">
    <ul>
    <g:each in="${posts}" var="post">
        <li>
            <b>${post.author.nickname}</b>
            ${post.content}
        </li>
    </g:each>
    </ul>
</g:applyLayout>