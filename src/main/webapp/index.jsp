<%@page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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

<div id="bundle" style="width: 140px;">

    <fieldset>
        <legend>Java</legend>
        <label>
            Version:
            <select name="java[version]" style="width: 50px;">
                <option value="1.4">1.4</option>
                <option value="1.5">1.5</option>
                <option value="1.6">1.6</option>
            </select>
        </label>
    </fieldset>

</div>

<input id="click" type="button" value="Get Bundle!" onclick="getBundle();"/>

<form action="bundle/get" method="POST">
    <input name="bundle" type="text" value="@$@#$@#$@#$@#$"/>
    <input type="submit" value="SDFSDFSDF"/>
</form>

</body>
</html>