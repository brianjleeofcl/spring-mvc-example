<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="en">
<head>
    <title>Users</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="../css/normalize.css" rel="stylesheet">
    <link href="../css/skeleton.css" rel="stylesheet">
    <link href="../css/style.css" rel="stylesheet">
</head>
<body class="container">
<div class="row">
    <div class="six columns">
        <h5>${user.firstName} ${user.lastName}</h5>

        <p>Phone: ${user.formattedPhoneNumber}</p>

        <a href="../users">Back</a>
    </div>
</div>
</body>
</html>