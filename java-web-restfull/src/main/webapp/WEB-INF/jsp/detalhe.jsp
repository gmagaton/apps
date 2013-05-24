<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<h1>Detalhe</h1>
<h2>${detalhe.master.descricao}</h2>
<fieldset>
	<form:form commandName="detalhe" method="DELETE" action="${pageContext.request.contextPath}/detalhe/${detalhe.id}">
		<form:label path="id">id</form:label>
		<form:input path="id" placeholder="id do detalhe"/>
		
		<form:label path="descricao">descrição</form:label>
		<form:input path="descricao" placeholder="descrição do detalhe"/>
		
		<form:label path="status">status</form:label>
		<form:input path="status" placeholder="status do detalhe"/>  
		<p/>
		<input type="submit" value="Remover" class="btn"/>
	</form:form>
</fieldset>
