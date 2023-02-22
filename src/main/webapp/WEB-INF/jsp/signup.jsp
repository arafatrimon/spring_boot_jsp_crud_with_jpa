<%@include file="common/header.jspf" %>
<div class="container">
    <form:form action="${formAction}" method="post" modelAttribute="user">
        <%--    modelAttribute="reg_form"--%>
        <legend>Sign User</legend>
        <fieldset class="form-group">
                <%--        <form:errors path="username" class="error" />--%>
            <form:input type="text" path="username" id="username" tabindex="1" class="form-control"
                        placeholder="Username"/>
        </fieldset>

        <c:if test="${loginPage}">
            <fieldset class="form-group">
                <form:input type="email" path="email" id="email" tabindex="1" class="form-control"
                            placeholder="Email Address"/>
            </fieldset>
        </c:if>


        <fieldset class="form-group">
            <form:input type="password" path="password" id="password" tabindex="2" class="form-control"
                        placeholder="Password"/>

        </fieldset>
        <fieldset class="form-group">
            <form:input type="password" path="confirmPassword" id="confirm-password" tabindex="2" class="form-control"
                        placeholder="Confirm Password"/>

        </fieldset>
        <fieldset class="form-group">
            <div class="row">
                <div class="col-sm-6 col-sm-offset-3">
                    <input type="submit" name="register-submit" id="register-submit" tabindex="4"
                           class="form-control btn btn-success" value="Register Now"/>
                </div>
            </div>

        </fieldset>
    </form:form>
    <a class="btn btn-primary" href="/loginUserPage">Sign User</a>
</div>
<%@include file="common/footer.jspf" %>