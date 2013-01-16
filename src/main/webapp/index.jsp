<%@ page import="com.prettybit.bundles.entity.Java" %>
<%@ page import="com.prettybit.bundles.entity.Maven" %>
<%@page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="java_versions" value="<%=Java.Version.values()%>"/>
<c:set var="maven_versions" value="<%=Maven.Version.values()%>"/>
<!DOCTYPE html>
<html>
<head>
    <title>Java Development Environment Bundles</title>
    <script type="text/javascript" src="js/jquery-1.8.3.js"></script>
    <script type="text/javascript" src="js/serializeObject.js"></script>
    <script type="text/javascript" src="js/download.js"></script>
    <script type="text/javascript">
        function getBundle() {
            $.download('bundle/get', 'bundle=' + encodeURI(JSON.stringify($('#bundle').serializeObject())));
        }
    </script>
<body>

<div id="bundle" style="width: 250px;">

    <fieldset>
        <legend>Java</legend>
        <label>
            Version:
            <select name="java[version]">
                <c:forEach items="${java_versions}" var="version">
                    <option value="${version}">${version.display}</option>
                </c:forEach>
            </select>
        </label>
    </fieldset>

    <fieldset>
        <legend>Maven</legend>
        <label>
            Version:
            <select name="maven[version]">
                <c:forEach items="${maven_versions}" var="version">
                    <option value="${version}">${version.display}</option>
                </c:forEach>
            </select>
        </label>
    </fieldset>

</div>

<input id="click" type="button" value="Get Bundle!" onclick="getBundle();"/>

</body>
</html>