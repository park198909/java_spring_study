<%@ tag body-content="scriptless" pageEncoding="UTF-8" %>
<%@ tag trimDirectiveWhiteSpaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ attribute name="pageTitle"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <title>${pageTitle}</title>
    </head>
    <body>
        <main><jsp:doBody /></main>
        <iframe name="ifrm" style="visibility:hidden"></iframe>
    </body>
</html>
