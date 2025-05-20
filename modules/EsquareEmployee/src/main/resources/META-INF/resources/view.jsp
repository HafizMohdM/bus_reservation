<%@page import="com.liferay.portal.kernel.service.RoleLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.model.User"%>
<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@page import="com.liferay.portal.kernel.theme.ThemeDisplay"%>
<%@page
	import="com.liferay.document.library.kernel.service.DLAppLocalServiceUtil"%>
<%@page import="com.liferay.document.library.kernel.util.DLUtil"%>
<%@page import="com.liferay.object.rest.dto.v1_0.FileEntry"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="javax.portlet.ActionRequest"%>
<%@page import="EsquareEmployee_Slayer.model.Employees"%>
<%@page import="java.util.List"%>
<%@page import="javax.portlet.PortletURL"%>
<%@ include file="./init.jsp"%>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>

<portlet:defineObjects />

<!-- DataTables CSS -->
<link rel="stylesheet" type="text/css"
	href="https://cdn.datatables.net/1.10.24/css/jquery.dataTables.css">

<!-- DataTables JS -->
<script type="text/javascript" charset="utf8"
	src="https://cdn.datatables.net/1.10.24/js/jquery.dataTables.js"></script>

<portlet:renderURL var="EntryRenderURL">
	<portlet:param name="jspPage" value='/employee/form.jsp' />
</portlet:renderURL>

<%
	ThemeDisplay themeDisplay2 = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
	List<Employees> employeeEntries = (List<Employees>) request.getAttribute("employeesList");

	PortletURL viewExampleEntryDataURL = renderResponse.createRenderURL();
	PortletURL editExampleEntryURL = renderResponse.createRenderURL();
	PortletURL deleteExampleEntryURL = renderResponse.createActionURL();
%>

<%@page import="com.liferay.portal.kernel.theme.ThemeDisplay"%>
<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@page
	import="com.liferay.portal.kernel.security.permission.PermissionChecker"%>

<portlet:defineObjects />

<% 
    User user2 = themeDisplay.getUser();

    boolean superAdmin = themeDisplay.getPermissionChecker().isOmniadmin();
    boolean isProAdmin = RoleLocalServiceUtil.hasUserRole(user.getUserId(), themeDisplay.getCompanyId(), "PROADMIN", true);
    boolean Admin = RoleLocalServiceUtil.hasUserRole(user.getUserId(), themeDisplay.getCompanyId(), "ADMIN", true);
    
%>

<div class="card"
	style="max-width: 1000px; margin: auto; padding: 20px;">
	<div class="card-header"
		style="background-color: #007bff; color: white; text-align: center; padding: 15px;">
		<h1 class="card-title" style="margin: 0;">Employee List</h1>
	</div>

	<c:if
		test="${permissionChecker.hasPermission(scopeGroupId, portletDisplay.rootPortletId, portletDisplay.resourcePK, ADD_EMPLOYEE)}">


		<aui:a href="<%=EntryRenderURL.toString()%>" label="Add Employee"
			cssClass="btn btn-light" />
	</c:if>

	<div class="card-body">
		<aui:form method="post">
			<table id="moduleTable" class="table table-bordered table-hover">
				<thead>
					<tr>
						<th>Name</th>
						<th>Mobile Number</th>
						<th>Designation</th>
						<th>Photo</th>
						<c:if
							test="${permissionChecker.hasPermission(scopeGroupId, portletDisplay.rootPortletId, portletDisplay.resourcePK, VIEW_EMPLOYEE)}">


							<th>Action</th>
						</c:if>
					</tr>
				</thead>
				<tbody>
				        <c:forEach var="item" items="${items}">
            <li>${item}</li>
        </c:forEach>
				
				
					<%
						for (Employees employee : employeeEntries) {
								viewExampleEntryDataURL.setParameter("employeeId", String.valueOf(employee.getEmployeeId()));
								viewExampleEntryDataURL.setParameter("jspPage", "/employee/ShowData.jsp");
								editExampleEntryURL.setParameter("employeeId", String.valueOf(employee.getEmployeeId()));
								editExampleEntryURL.setParameter("jspPage", "/employee/update.jsp");
								deleteExampleEntryURL.setParameter("employeeId", String.valueOf(employee.getEmployeeId()));
								deleteExampleEntryURL.setParameter(ActionRequest.ACTION_NAME, "deleteEntry");
					%>
					<tr>
						<td><%=employee.getEmployeeName()%></td>
						<td><%=employee.getEmployeeMobileNumber()%></td>
						<td><%=employee.getEmployeeDesignation()%></td>
						<td>
							<%
								String empPhotoBase64 = employee.getEmployeephoto();
										if (empPhotoBase64 != null && !empPhotoBase64.isEmpty()) {
							%> <img
							src="data:image/png;base64,<%=empPhotoBase64%>"
							alt="Employee Photo"
							style="width: 50px; height: 50px; border-radius: 50%; object-fit: cover;" />
							<%
								} else {
							%> No Photo <%
								}
							%>
						</td>
						<c:if
							test="${permissionChecker.hasPermission(scopeGroupId, portletDisplay.rootPortletId, portletDisplay.resourcePK, VIEW_EMPLOYEE)}">

							<td><liferay-ui:icon-menu direction="left-side"
									markupView="lexicon" showWhenSingleIcon="<%=true%>">
									<liferay-ui:icon image="view" message="View"
										url="<%=viewExampleEntryDataURL.toString()%>" />
									<c:if
										test="${permissionChecker.hasPermission(scopeGroupId, portletDisplay.rootPortletId, portletDisplay.resourcePK, UPDATE_EMPLOYEE)}">

										<liferay-ui:icon image="edit" message="Edit"
											url="<%=editExampleEntryURL.toString()%>" />
									</c:if>
									<c:if
										test="${permissionChecker.hasPermission(scopeGroupId, portletDisplay.rootPortletId, portletDisplay.resourcePK, DELETE_EMPLOYEE)}">
										<liferay-ui:icon image="delete" message="Delete"
											url="<%=deleteExampleEntryURL.toString()%>" />
									</c:if>
								</liferay-ui:icon-menu></td>
						</c:if>
					</tr>
					<% 
						}
					%>
				</tbody>
			</table>
		</aui:form>
	</div>
</div>

<script>
	$(document).ready(function() {
		$('#moduleTable').DataTable();

	});
</script>


<style>
.employee-photo img {
	border-radius: 50%;
	width: 50px;
	height: 50px;
	object-fit: cover;
}

.card {
	border: 1px solid #dee2e6;
	border-radius: 0.25rem;
	box-shadow: 0 0.125rem 0.25rem rgba(0, 0, 0, 0.075);
}

.table th, .table td {
	vertical-align: middle;
}

.table th {
	background-color: #f8f9fa;
	color: #343a40;
}

.btn-light {
	margin-left: 800px;
	margin-top: 12px;
}
</style>

 
 
 
<%--  
 <%@page import="javax.portlet.ActionRequest"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="EsquareEmployee_Slayer.model.Employees"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<liferay-ui:search-container
    total="${employeeEntries.size()}"
    delta="10"
    emptyResultsMessage="no-employees-found"
    iteratorURL="${renderResponse.createRenderURL()}"
    var="searchContainer">

    <liferay-ui:search-container-results
        results="${employeeEntries}"
        total="${employeeEntries.size()}" />

    <liferay-ui:search-container-row
        className="EsquareEmployee_Slayer.model.Employees"
        keyProperty="employeeId"
        modelVar="employee">

        <liferay-ui:search-container-column-text
            name="Name"
            value="${employee.employeeName}" />

        <liferay-ui:search-container-column-text
            name="Mobile Number"
            value="${employee.employeeMobileNumber}" />

        <liferay-ui:search-container-column-text
            name="Designation"
            value="${employee.employeeDesignation}" />

        <liferay-ui:search-container-column-text name="Photo">
            <c:choose>
                <c:when test="${not empty employee.employeephoto}">
                    <img src="data:image/png;base64,${employee.employeephoto}"
                         alt="Employee Photo"
                         style="width: 50px; height: 50px; border-radius: 50%; object-fit: cover;" />
                </c:when>
                <c:otherwise>No Photo</c:otherwise>
            </c:choose>
        </liferay-ui:search-container-column-text>

        <liferay-ui:search-container-column-jsp
            name="Actions"
            path="/employee/actions.jsp"
            align="center"
            />

    </liferay-ui:search-container-row>

    <liferay-ui:search-iterator />
</liferay-ui:search-container>
 
 
 
 
 --%>