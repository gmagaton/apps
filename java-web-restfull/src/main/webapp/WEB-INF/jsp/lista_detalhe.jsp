<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<h1>Lista de Detalhes</h1>
   <table class="table table-hover">
   	<thead>
   		<tr>
   			<th>id</th>
   			<th>descricao</th>
   			<th>master</th>
   		</tr>
   	</thead>
   	<tbody>
		<c:forEach items="${detalhes}" var="detalhe">
	        <tr>
	            <td><a href="${pageContext.request.contextPath}/detalhe/${detalhe.id}">${detalhe.id}</a></td>
	            <td>${detalhe.descricao}</td>
	            <td>${detalhe.master.descricao}</td>
	        </tr>
		</c:forEach>
	</tbody>
</table>

<p/>
<a href="${pageContext.request.contextPath}/master/recarregar">recarregar</a>
	