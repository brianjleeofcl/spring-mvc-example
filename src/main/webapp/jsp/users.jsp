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
                <h5>Users</h5>
                <ul>
                    <c:forEach var="user" items="${users}">
                        <li><a href="./users/${user.id}">${user.firstName} ${user.lastName}</a> — ${user.formattedPhoneNumber}</li>
                    </c:forEach>
                </ul>
            </div>
        </div>
        <form method="post">
            <div class="row">
                <div class="three columns">
                    <label for="first-name">First Name</label>
                    <input class="u-full-width" type="text" name="firstName" id="first-name"/>
                </div>
                <div class="three columns">
                    <label for="last-name">Last Name</label>
                    <input class="u-full-width" type="text" name="lastName" id="last-name"/>
                </div>
                <div class="three columns">
                    <label for="phone">Phone (###-###-####)</label>
                    <input class="u-full-width" type="text" name="phone" id="phone"/>
                </div>
                <button type="submit" class="button-primary three columns">Submit</button>
            </div>
        </form>
    </body>
</html>