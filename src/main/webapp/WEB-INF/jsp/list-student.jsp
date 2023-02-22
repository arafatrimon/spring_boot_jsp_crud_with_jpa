<%@include file="common/header.jspf" %>
<%@include file="common/navigation.jspf" %>

<%--<c:if test="${not empty msg}">${msg}</c:if>--%>

<div class="container">
    <fieldset>
        <legend>Student List</legend>
        <c:choose>
            <c:when test="${students !=null}">
                <table class="table" id="table">
                    <thead>
                    <tr>
                        <th>Id</th>
                        <th>Name</th>
                        <th>Class</th>
                        <th>Father Name</th>
                        <th>Mother Name</th>
                        <th>Date of Birth</th>
                        <th>Address</th>
                        <th>Degree</th>
                        <th>Action</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="val" items="${students}">
                        <tr>
                            <td>${val.id}</td>
                            <td>${val.studentName}</td>
                            <td>${val.cls}</td>
                            <td>${val.fatherName}</td>
                            <td>${val.motherName}</td>
                            <td>${val.dateOfBirth} </td>

                            <td>${val.address}</td>

                            <td>

                                <c:forEach var="deg" items="${val.degree}">
                                    ${deg}
                                </c:forEach>
                            </td>
                            <td>

                                    <%--                        <a href="/edit?id=${val.id}">Details</a>--%>

                                <a class="btn btn-primary" href="/edit?id=${val.id}">Edit</a>

                                <a class="btn btn-warning" onclick="return confirm('Do you really want to delete?')"
                                   href="/delete?id=${val.id}">Delete</a>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </c:when>
            <c:otherwise>No user found</c:otherwise>
        </c:choose>
    </fieldset>
</div>

<%@include file="common/footer.jspf" %>

