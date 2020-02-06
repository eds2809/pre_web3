<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>


<script>
    function send(method, url, data = '') {
        let xhr = new XMLHttpRequest();
        xhr.open(method, url);
        xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded;charset=UTF-8");
        xhr.onload = function () {
            location.reload();
        };
        xhr.send(data);
    }
</script>
<table border="1" cellspacing="0" cellpadding="2">
    <tr>
        <td>Name</td>
        <td>password</td>
        <td>age</td>
    </tr>
    <form method="post" action="/web3/" style="margin: 0;">
        <tr>
            <td>
                <input type="text" name="name">
            </td>

            <td>
                <input type="text" name="pass">
            </td>

            <td>
                <input type="number" name="age">
            </td>

            <td>
                <button type="submit">add</button>
            </td>
        </tr>
    </form>
</table>

<c:if test="${fn:length(users) > 0}">
    <table border="1" cellspacing="0" cellpadding="2">
        <br>
        <br>
        <tr>
            <td>ID</td>
            <td>Name</td>
            <td>password</td>
            <td>age</td>
        </tr>
        <c:forEach items="${users}" var="user">
            <form method="get" action="/web3/user/" style="margin: 0;">
                <tr>
                    <td>
                        <input type="text" name="id" value="${user.id}" hidden>
                            ${user.id}
                    </td>
                    <td>
                        <input type="text" name="name" value="${user.name}">
                    </td>

                    <td>
                        <input type="text" name="pass" value="${user.pass}">
                    </td>

                    <td>
                        <input type="number" name="age" value="${user.age}">
                    </td>

                    <td>
                        <button type="submit">update</button>
                    </td>
                    <td>
                            <%-- <form method="post" action="/web3/user/" style="margin: 0;">
                                 <input type="text" name="id" value="${user.id}" hidden>
                                 <button type="submit">delete</button>
                             </form>--%>
                        <button type="button" onclick="send('post','/web3/user/','id=${user.id}' )">delete</button>
                    </td>

                </tr>
            </form>
        </c:forEach>
    </table>
</c:if>

