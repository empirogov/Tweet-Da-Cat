<!DOCTYPE html>
<!--[if lt IE 7]>      <html class="no-js lt-ie9 lt-ie8 lt-ie7"> <![endif]-->
<!--[if IE 7]>         <html class="no-js lt-ie9 lt-ie8"> <![endif]-->
<!--[if IE 8]>         <html class="no-js lt-ie9"> <![endif]-->
<!--[if gt IE 8]><!--> <html class="no-js"> <!--<![endif]-->
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <title><g:layoutTitle default="Grails"/></title>
    <link rel="shortcut icon" href="${resource(dir: 'images', file: 'favicon.ico')}" type="image/x-icon">
    <link rel="apple-touch-icon" href="${resource(dir: 'images', file: 'apple-touch-icon.png')}">
    <link rel="apple-touch-icon" sizes="114x114" href="${resource(dir: 'images', file: 'apple-touch-icon-retina.png')}">
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width">
    <link rel="stylesheet" href="${resource(dir: 'css', file: 'normalize.css')}">
    <link rel="stylesheet" href="${resource(dir: 'css', file: 'main.css')}">
    <script src="js/modernizr-2.6.2-respond-1.1.0.min.js"></script>
    <g:layoutHead/>
    <r:layoutResources />
</head>
<body>
<div class="body-wrapper">
    <!--[if lt IE 7]>
        <p class="chromeframe">You are using an <strong>outdated</strong> browser. Please <a href="http://browsehappy.com/">upgrade your browser</a> or <a href="http://www.google.com/chromeframe/?redirect=true">activate Google Chrome Frame</a> to improve your experience.</p>
    <![endif]-->
    <g:render template="/header" />
    <div class="main-container">
        <div class="main wrapper clearfix">
            <g:layoutBody/>
        </div> <!-- #main -->
    </div> <!-- #main-container -->
    <g:render template="/footer" />
</div>
<script src="js/jquery-1.8.3.min.js"></script>
<script src="js/jquery.tweet-da-cat.placeholders.js"></script>
<script src="js/plugins.js"></script>
<script src="js/main.js"></script>

<!-- [НЕВЕДОМАЯ ЙОПАННАЯ ...] -->
<div id="spinner" class="spinner" style="display:none;"><g:message code="spinner.alt" default="Loading&hellip;"/></div>
<g:javascript library="application"/>
<r:layoutResources />
<!-- [/НЕВЕДОМАЯ ЙОПАННАЯ ...] -->

</body>
</html>