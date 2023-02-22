<%@include file="common/header.jspf" %>
<%@include file="common/navigation.jspf" %>

<c:if test="@{not empty msg}">
    ${message}
</c:if>


<div class="container">

        <form:form cssClass="form" action="${formAction}" method="POST" modelAttribute="student">

            <legend>${pageTitle}</legend>

            <form:hidden path="id"/>

            <fieldset class="form-group">
                <form:label path="studentName"> Name</form:label><br/>
                <form:input cssClass="form-control" path="studentName" type="text"/>
                <form:errors path="studentName" cssClass="text-warning" />
            </fieldset>


<%--            <div class="form-group">--%>
<%--                <input class="form-control" path="studentName" type="text"/>--%>
<%--            </div>--%>


            <fieldset class="form-group">
                <form:label path="cls">Class</form:label><br/>
                <form:select path="cls" class="form-control">
                    <form:option value="One">One</form:option>
                    <form:option value="Two">Two</form:option>
                    <form:option value="Three">Three</form:option>
                </form:select>
                <form:errors path="cls" cssClass="text-warning" />
            </fieldset>


            <fieldset class="form-group">
                <form:label path="fatherName">Father Name</form:label><br/>
                <form:input cssClass="form-control" path="fatherName" type="text"/>
                <form:errors path="fatherName" cssClass="text-warning" />
            </fieldset>


            <fieldset class="form-group">
                <form:label path="motherName">Mother name</form:label><br/>
                <form:input cssClass="form-control" path="motherName" type="text"/>
                <form:errors path="motherName" cssClass="text-warning" />
            </fieldset>


<%--            <fieldset class="form-group">--%>
<%--                <form:label path="dateOfBirth">Date of Birth</form:label><br/>--%>
<%--                <form:input class="form-control" path="dateOfBirth" type="date"/>--%>
<%--                <form:errors path="dateOfBirth" cssClass="text-warning" />--%>
<%--            </fieldset>--%>


            <fieldset class="form-group">
                <label for="dateOfBirth">Date of birth</label>
                <fmt:formatDate var="fmtStartDate" value="${student.dateOfBirth}"
                                pattern="yyyy/MM/dd"/>
                <form:input path="dateOfBirth" id="dateOfBirth" value="${fmtStartDate}" class="form-control" type="text" />
            </fieldset>


            <fieldset class="form-group">
                <form:label path="address">Address</form:label><br/>
                <form:input cssClass="form-control" path="address" type="text"/>
                <form:errors path="address" cssClass="text-warning" />
            </fieldset>

<%--            <form:checkboxes path="degree" items="${object.elementList}"/>--%>

            Degrees:
            SSC<form:checkbox path="degree" value="SSC"/>
            HSC<form:checkbox path="degree" value="HSC"/>
            BSC<form:checkbox path="degree" value="BSC"/>



            <input value="${pageTitle}" type="submit" class="btn btn-success">
        </form:form>


</div>
<br><br>

<%@include file="common/footer.jspf" %>

