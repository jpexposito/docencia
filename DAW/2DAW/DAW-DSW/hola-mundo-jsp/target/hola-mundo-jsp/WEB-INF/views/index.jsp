<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<body>
<h1>${msg}</h1>
<h2>Hoy es <fmt:formatDate value="${today}" pattern="yyy-MM-dd" /></h2>
</body>
</html>
