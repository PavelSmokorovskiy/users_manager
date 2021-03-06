<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="header.jsp"></jsp:include>

<h3>User Registration</h3>
<br>
<form action='/users/add' method='post'>

    <table class='table table-hover table-responsive table-bordered'>

        <tr>
            <td><b>Name</b></td>
            <td><input type='text' name='name' class='form-control' required/></td>
        </tr>

        <tr>
            <td><b>Last name</b></td>
            <td><input type='text' name='last_name' class='form-control' required/></td>
        </tr>

        <tr>
            <td><b>Address</b></td>
            <td><input type='text' name='address' class='form-control' size="20" required/></td>

        </tr>

        <tr>
            <td></td>
            <td>
                <button type="submit" class="btn btn-primary">Add User</button>
            </td>
        </tr>

    </table>
    <b><c:out value="${danger}"></c:out></b>
</form>

<h3>List Of Users</h3>
<br>
<table class="table table-hover">

    <thead>
    <tr>
        <th><b>User Name</b></th>
        <th><b>User Last name</b></th>
        <th><b>User Address</b></th>
        <th><b>Transactions</b></th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${list}" var="lou">
        <tr>
            <td><c:out value="${lou.name}"></c:out></td>
            <td><c:out value="${lou.last_name}"></c:out></td>
            <td><c:out value="${lou.address}"></c:out></td>

            <td>
                <a href="/users/${lou.id}/edit">
                    <button type="submit" class="btn btn-primary">Edit User</button>
                </a>
            </td>
            <td>
                <a href="/users/${lou.id}/delete">
                    <button type="submit" class="btn btn-primary">Delete User</button>
                </a>
            </td>
        </tr>

    </c:forEach>
    </tbody>
</table>
</div>
