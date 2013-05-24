<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<h1>Lista de Masters</h1>
   <table class="table table-hover">
   	<thead>
   		<tr>
   			<th>id</th>
   			<th>descricao</th>
   			<th>status</th>
   			<th>detalhes</th>
   		</tr>
   	</thead>
   	<tbody>
		<c:forEach items="${masters}" var="master">
	        <tr>
	            <td><a href="${pageContext.request.contextPath}/master/${master.id}">${master.id}</a></td>
	            <td>${master.descricao}</td>
	            <td>${master.status}</td>
	            <td><a href="${pageContext.request.contextPath}/master/${master.id}/detalhes">detalhes</a></td>
	        </tr>
		</c:forEach>
	</tbody>
</table>

<p/>
<a href="${pageContext.request.contextPath}/master/novo">novo</a>
<p/>
<a href="${pageContext.request.contextPath}/master/recarregar">recarregar</a>
	