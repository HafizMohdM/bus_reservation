<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page
	import="EsquareEmployee_Slayer.service.EmployeesLocalServiceUtil"%>
<%@page import="EsquareEmployee_Slayer.model.Employees"%>
<%@ include file="../init.jsp"%>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>

<portlet:defineObjects />


<portlet:actionURL name="updateEmployee" var="updateEmployeeyURL">
	<portlet:param name="mvcRenderCommandName" value="/view.jsp" />
</portlet:actionURL>

<%
long employeeId = ParamUtil.getLong(request, "employeeId");
Employees employee = null;

if (employeeId > 0) {
	employee = EmployeesLocalServiceUtil.fetchEmployees(employeeId);
}
%>

     <div class="card" style="max-width: 500px; margin: auto; padding: 20px;">
        	<div class="card-header"
	     	    style="background-color: #007bff; color: white; box-shadow: 0 2px 5px rgba(0, 0, 0, 0.2); padding: 15px; text-align: center;">
	    	    <h2 class="card-title" style="margin: 0;">Update Employee</h2>
	        </div>
	   <div class="card-body">
		    <aui:form action="<%= updateEmployeeyURL.toString() %>" method="post"
			enctype="multipart/form-data"
			style="display: inline-block; width: 100%;">
			<!-- Hidden field to store the employee ID -->
			<aui:input name="employeeId" type="hidden" 
				value="<%= employee.getEmployeeId() %>" ></aui:input>

			<aui:input name="employeeName" label="Employee Name" 
				value="<%= employee.getEmployeeName() %>"/>

			<aui:input name="employeeMobileNumber" label="Mobile Number" type="tel" oninput="validateMobileNumber(this)" required="true"
				value="<%= employee.getEmployeeMobileNumber() %>" />

			<aui:input name="employeeDesignation" label="Designation"
				value="<%= employee.getEmployeeDesignation() %>" />

			<%--  <div class="form-group">
                    <img
                        src="/image/user_male_portrait?img_id=0&img_id_token=ml8ak%2BZFyxdJKXMun4My4PavmL4%3D&t=1704777810332"
                        id="img_url" alt="Please choose" style="width: 100px; height: 100px; margin-bottom: 10px;">
                    <aui:script>
                        function img_pathUrl(input) {
                            $('#img_url')[0].src = (window.URL ? URL : webkitURL).createObjectURL(input.files[0]);
                        }
                    </aui:script>
                    <aui:input name="employeePhoto" label="Profile Photo"
                        type="file" id="img_file" onChange="img_pathUrl(this);" >
                        <aui:validator name="required" />
                        <aui:validator name="acceptFiles">'jpg,png'</aui:validator>
                    </aui:input>
                </div> --%>
			<div class="form-group">
				<%
                  String empPhotoBase64 = employee.getEmployeephoto();
                  if (empPhotoBase64 != null && !empPhotoBase64.isEmpty()) {
                %>
				
				<img src="data:image/png;base64,<%= empPhotoBase64 %>" id="img_url"
					alt="Employee Photo"
					style="width: 100px; height: 100px;/*  border-radius: 50%; object-fit: cover;  */margin-bottom: 10px;" />
				<%
                    } else {
                %>
				
				<img
					src="/image/user_male_portrait?img_id=0&img_id_token=ml8ak%2BZFyxdJKXMun4My4PavmL4%3D&t=1704777810332"
					id="img_url" alt="Please choose"
					style="width: 100px; height: 100px; margin-bottom: 10px;" />
				<p>No Photo</p>
				<%
        }
    %>

				

				<!-- Input for uploading new profile photo -->
				<aui:input name="employeePhoto" label="Profile Photo" type="file"
					id="img_file" onChange="img_pathUrl(this);">
					<%-- <aui:validator name="required" /> --%>
					<%-- <aui:validator name="acceptFiles">'jpg,png'</aui:validator> --%>
				</aui:input>
			</div>	


			<aui:button type="submit" value="Update Employee"
				style="margin-top: 10px;" />
		</aui:form>
	</div>
</div>
<aui:script>
        function img_pathUrl(input) {
            if (input.files && input.files[0]) {
                // Update the image preview when a new file is selected
                $('#img_url')[0].src = (window.URL ? URL : webkitURL).createObjectURL(input.files[0]);
            }
        }
    </aui:script>
    
    <script>
function validateMobileNumber(input) {
    
    input.value = input.value.replace(/\D/g, '');

   
    if (input.value.length > 10) {
        input.value = input.value.slice(0, 10);
    }
}
</script>