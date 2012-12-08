<ul>
    <g:each in="${posts}" var="post">
        <li>
            <g:render template="/post/post" model="[post: post]" />
        </li>
    </g:each>
</ul>
