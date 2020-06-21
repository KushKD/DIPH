<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ page session="false"%>
<html>

<head>
<tiles:insertAttribute name="header" />
</head>
<body>

	<tiles:insertAttribute name="content" />

</body>

<footer>
<tiles:insertAttribute name="footer" />
</footer>
</html>