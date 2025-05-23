<%@ include file="../init.jsp" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>

<portlet:defineObjects />

<portlet:actionURL name="addEmployee" var="addEntryURL">
    <portlet:param name="mvcRenderCommandName" value="/view.jsp" />
</portlet:actionURL>

<div class="container">
   <div class="card" style="max-width: 500px; margin: auto; padding: 20px;">
    <div class="card-header" style="background-color: #007bff; color: white; box-shadow: 0 2px 5px rgba(0, 0, 0, 0.2); padding: 15px; text-align: center;">
        <h2 class="card-title" style="margin: 0;">Add Employee</h2>
    </div>
        <div class="card-body">
           
            <aui:form action="<%= addEntryURL.toString() %>" method="post" enctype="multipart/form-data">
                <aui:input name="employeeName" label="Employee Name" ><aui:validator name="required" /></aui:input>
             
               <aui:input name="employeeMobileNumber" label="Mobile Number" type="tel" oninput="validateMobileNumber(this)" onblur="checkMobileNumber(this)" required="true" />
               
                <aui:input name="employeeDesignation" label="Designation" ><aui:validator name="required" /></aui:input>
             <%--    <div class="form-group">
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
        <!-- Removed acceptFiles validator to allow all image types -->
    </aui:input>
</div>
                
                <aui:button type="submit" value="Add Employee" />
            </aui:form>
        </div>
    </div>
</div>

<style>
    .container {
        display: flex;
        justify-content: center;
        align-items: center;
        height: 100vh; /* Centers vertically on the full viewport height */
    }
    .card {
        border: 1px solid #ddd;
        border-radius: 4px;
        box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
    }
</style>

<script>
function validateMobileNumber(input) {
    
    input.value = input.value.replace(/\D/g, '');

   
    if (input.value.length > 10 ) {
        input.value = input.value.slice(0, 10);
    }
}

function checkMobileNumber(input) {
    const errorMessage = document.getElementById("mobileNumberError");

    
    if (input.value.length < 10) {
        errorMessage.style.display = "block";
        errorMessage.innerText = "Mobile number must be exactly 10 digits long.";
    } else {
        errorMessage.style.display = "none"; // Hide error if valid
    }
}
</script>
