<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<h1>Master</h1>
<div>${msg}</div>
<fieldset>
	<form:form commandName="master" method="PUT" action="${pageContext.request.contextPath}/master/${master.id}">
		<form:errors path="*" cssClass="alert alert-error" element="div" />
			
		<form:label path="id">Id</form:label>
		<form:input path="id" placeholder="id do master"/>
		<form:errors path="id" />
		
		<form:label path="descricao">descrição</form:label>
		<form:input path="descricao" placeholder="descrição do master"/>
		<form:errors path="descricao"/>
		
		<form:label path="status">status</form:label>
		<form:input path="status" placeholder="status do master"/>  
		<form:errors path="status" />  
		<p/>
		<input type="submit" value="Atualizar" class="btn"/>
	</form:form>
</fieldset>
