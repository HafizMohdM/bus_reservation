<%@page import="com.esq.bus.reservation.slayers.service.BusLocalServiceUtil"%>
<%@page import="com.esq.bus.reservation.slayers.service.BusLocalService"%>
<%@page import="com.esq.bus.reservation.slayers.model.Bus"%>
<%@page import="java.util.List"%>
<%@ include file="./init.jsp" %>
<%-- <%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<link href="https://fonts.googleapis.com/css2?family=Poppins&display=swap" rel="stylesheet">

<portlet:defineObjects />

<portlet:actionURL name="addEmployee" var="addEntryURL">
    <portlet:param name="mvcRenderCommandName" value="/view.jsp" />
</portlet:actionURL>

<style>


  .container {
    font-family: Poppins, sans-serif;
    max-width: 100px;
    margin: auto;
    background: #fff;
    padding: 30px;
    border-radius: 8px;
    box-shadow: 0 0 10px rgba(0,0,0,0.1);
  }

  h2 {
    margin-top: 0;
    font-size: 22px;
  }

  .form-row {
    display: flex;
    gap: 20px;
    flex-wrap: wrap;
  }

  .form-group {
    flex: 1;
    display: flex;
    flex-direction: column;
    margin-bottom: 15px;
  }

  .full-width {
    width: 100%;
  }

  label {
    margin-bottom: 5px;
    font-weight: 500;
  }

  input[type="text"],
  input[type="number"],
  input[type="file"],
  select,
  textarea {
    padding: 10px;
    border-radius: 5px;
    border: 1px solid #ccc;
    font-size: 14px;
  }

  textarea {
    resize: vertical;
    min-height: 80px;
  }

  #preview {
    display: flex;
    gap: 10px;
    margin-top: 10px;
    flex-wrap: wrap;
  }

  .thumb {
    width: 80px;
    height: 80px;
    object-fit: cover;
    border-radius: 6px;
    border: 1px solid #ccc;
  }

  .upload-note {
    font-size: 12px;
    color: #777;
    margin-top: 5px;
  }

  .btn {
    background: #007bff;
    color: white;
    padding: 12px 20px;
    border: none;
    border-radius: 6px;
    cursor: pointer;
    font-size: 16px;
    margin-top: 15px;
  }

  .btn:hover {
    background: #0056b3;
  }

  .header {
    display: flex;
    justify-content: space-between;
    align-items: center;
    margin-bottom: 20px;
  }

  .btn-secondary {
    background: #0a58ca;
  }

  .btn-secondary:hover {
    background: #084298;
  }
</style>

<div class="container">
  <div class="header">
    <div>
      <h2>Bus Management</h2>
      <p>Manage your fleet of buses</p>
    </div>
    <button class="btn btn-secondary">+ View Bus List</button>
  </div>

  <h3>Add New Bus</h3>
  <p>Enter details to add a new bus to your fleet</p>

  <form action="<%= addEntryURL.toString() %>" method="post" enctype="multipart/form-data">
    <div class="form-row">
      <div class="form-group">
        <label>Bus Number</label>
        <input type="text" name="busNumber" placeholder="Enter bus number" required />
      </div>

      <div class="form-group">
        <label>Bus Plate Number</label>
        <input type="text" name="busPlateNumber" placeholder="e.g., ABC-1234" required />
      </div>
    </div>

    <div class="form-row">
      <div class="form-group">
        <label>Bus Type</label>
        <input type="number" name="busType" placeholder="Enter bus type code" required />
      </div>

      <div class="form-group">
        <label>Capacity</label>
        <input type="number" name="capacity" placeholder="Number of seats" required />
      </div>
    </div>

    <div class="form-group full-width">
      <label>Bus Photos (Max 5)</label>
      <input type="file" name="image1" accept="image/*" />
      <input type="file" name="image2" accept="image/*" />
      <input type="file" name="image3" accept="image/*" />
      <input type="file" name="image4" accept="image/*" />
      <input type="file" name="image5" accept="image/*" />
      <p class="upload-note">Upload up to 5 photos of your bus. Supported formats: JPG, PNG</p>
      <div id="preview"></div>
    </div>

    <button type="submit" class="btn">Add Bus</button>
  </form>
</div>

<script>
  const preview = document.getElementById('preview');
  const fileInputs = document.querySelectorAll('input[type="file"]');

  fileInputs.forEach(input => {
    input.addEventListener('change', function () {
      preview.innerHTML = '';
      fileInputs.forEach(fileInput => {
        if (fileInput.files[0]) {
          const reader = new FileReader();
          reader.onload = function (e) {
            const img = document.createElement('img');
            img.src = e.target.result;
            img.className = 'thumb';
            preview.appendChild(img);
          };
          reader.readAsDataURL(fileInput.files[0]);
        }
      });
    });
  });
</script>



<%@ include file="./init.jsp" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>

<portlet:defineObjects />

<portlet:actionURL name="addEmployee" var="addEntryURL">
    <portlet:param name="mvcRenderCommandName" value="/view.jsp" />
</portlet:actionURL>


    
<form action="<%= addEntryURL.toString() %>" method="post" enctype="multipart/form-data">
    <div>
        <label>Bus Number:</label>
        <input type="text" name="busNumber" required />
    </div>
    <div>
        <label>Bus Plate Number:</label>
        <input type="text" name="busPlateNumber" required />
    </div>
    <div>
        <label>Bus Type:</label>
        <input type="number" name="busType" required />
    </div>
    <div>
        <label>Capacity:</label>
        <input type="number" name="capacity" required />
    </div>
    <div>
        <label>Image 1:</label>
        <input type="file" name="image1" accept="image/*" />
    </div>
    <div>
        <label>Image 2:</label>
        <input type="file" name="image2" accept="image/*" />
    </div>
    <div>
        <label>Image 3:</label>
        <input type="file" name="image3" accept="image/*" />
    </div>
    <div>
        <label>Image 4:</label>
        <input type="file" name="image4" accept="image/*" />
    </div>
    <div>
        <label>Image 5:</label>
        <input type="file" name="image5" accept="image/*" />
    </div>
    <div>
        <button type="submit">Add Bus</button>
    </div>
</form>
    



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
                        <aui:validator name="acceptFiles">'jpg,png'</aui:validator>
                    </aui:input>
                </div>
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
 --%>
 
 

<%-- <%@ page import="com.esq.bus.reservation.slayers.model.Bus" %>
<%@ page import="java.util.List" %>

<%
     /* List<Bus> busList = (List<Bus>) request.getAttribute("busList");  */
     List<Bus> busList = BusLocalServiceUtil.getBuses(-1, -1);
%>

<h2>Bus List</h2>

<% if (busList != null && !busList.isEmpty()) { %>
    <table border="1" cellpadding="5" cellspacing="0">
        <tr>
            <th>Bus Number</th>
            <th>Plate Number</th>
            <th>Type</th>
            <th>Capacity</th>
            <th>Image</th>
        </tr>
<%
        for (Bus bus : busList) {
%>
        <tr>
            <td><%= bus.getBusNumber() %></td>
            <td><%= bus.getBusPlateNumber()%></td>
            <td><%= bus.getBusType() %></td>
            <td><%= bus.getCapacity() %></td>
            <td>
<%
                String image1 = bus.getImage1();
                if (image1 != null && !image1.isEmpty()) {
%>
                <img src="<%= image1 %>" width="100" height="60"/>
<%
                } else {
%>
                No image
<%
                }
%>
            </td>
        </tr>
<%
        }
%>
    </table>
<% } else { %>
    <p>No buses found.</p>
<% } %>
 --%>


<%@ page import="com.esq.bus.reservation.slayers.model.Bus"%>
<%@ page import="java.util.List"%>
<%@ page
	import="com.esq.bus.reservation.slayers.service.BusLocalServiceUtil"%>

<%
	List<Bus> busList = BusLocalServiceUtil.getBuses(-1, -1);
%>
<portlet:renderURL var="addRouteURL">
    <portlet:param name="mvcRenderCommandName" value='/add.jsp' />
</portlet:renderURL>

<%-- <a href="${addRouteURL}" class="btn btn-primary">Add New Bus</a> --%>
<aui:a href="<%=addRouteURL.toString()%>" label="Add New Bus"
			cssClass="btn btn-light" />
<html>
<head>
<title>Bus List</title>
<style>
body {
	font-family: Arial, sans-serif;
	background-color: #f5f6fa;
	margin: 0;
	padding: 20px;
}

.main-container {
	max-width: 900px;
	margin: auto;
}

/* Header section */
.header-container {
	background-color: #fff;
	border-radius: 8px;
	padding: 16px;
	box-shadow: 0 2px 6px rgba(0, 0, 0, 0.08);
	margin-bottom: 20px;
}

.header-top {
	display: flex;
	justify-content: space-between;
	align-items: center;
	font-size: 16px;
	margin-bottom: 10px;
}

.bus-count {
	font-weight: bold;
}

.sort-options {
	display: flex;
	gap: 15px;
	font-size: 14px;
	color: #555;
}

.sort-options a {
	text-decoration: none;
	color: #555;
	font-weight: 500;
}

.sort-options a:hover {
	color: #e74c3c;
}

.highlight-banner {
	background-color: #ffe1d2;
	padding: 10px;
	border-radius: 4px;
	color: #333;
	font-size: 14px;
	text-align: center;
}

/* Bus card styling */
.bus-card {
	background-color: #fff;
	border-radius: 8px;
	padding: 16px;
	margin-bottom: 20px;
	box-shadow: 0 2px 6px rgba(0, 0, 0, 0.08);
}

.bus-info {
	display: flex;
	justify-content: space-between;
	align-items: flex-start;
}

.bus-name {
	font-weight: bold;
	font-size: 16px;
}

.bus-type {
	font-size: 14px;
	color: #555;
	margin-top: 4px;
}

.rating {
	background-color: #ff7f50;
	color: white;
	padding: 4px 8px;
	border-radius: 4px;
	font-weight: bold;
	font-size: 14px;
}

.schedule-price {
	display: flex;
	justify-content: space-between;
	margin-top: 16px;
	font-size: 16px;
}

.timing .duration {
	font-size: 14px;
	color: #555;
	margin-top: 4px;
}

.seats {
	color: #e74c3c;
}

.price {
	font-size: 18px;
	font-weight: bold;
}

.view-button {
	text-align: right;
	margin-top: 12px;
}

.view-button button {
	background-color: #e74c3c;
	color: white;
	border: none;
	padding: 10px 16px;
	border-radius: 20px;
	font-size: 14px;
	cursor: pointer;
}

.view-button button:hover {
	background-color: #c0392b;
}

.bus-image {
	margin-top: 10px;
}

.bus-image img {
	width: 100px;
	height: auto;
	border-radius: 6px;
}
</style>
</head>
<body>
	<div class="main-container">

		<!-- Header Section -->
		<div class="header-container">
			<div class="header-top">
				<span class="bus-count"><%=busList != null ? busList.size() : 0%>
					buses found</span>
				<div class="sort-options">
					<span>Sort by:</span> <a href="#">Ratings</a> <a href="#">Departure
						time</a> <a href="#">Price</a>
				</div>
			</div>
			<div class="highlight-banner">
				<span><strong>3.6+ lakh</strong> bus routes on redBus</span>
			</div>
		</div>

		<!-- Bus List Section -->
		<%
			if (busList != null && !busList.isEmpty()) {
				for (Bus bus : busList) {
					/* String busType = bus.getBusType(); */
					// corrected
		%>
		<div class="bus-card">
			<div class="bus-info">
				<div>
					<div class="bus-name"><%=bus.getBusNumber()%>
						-
						<%=bus.getBusPlateNumber()%></div>
					<div class="bus-type">
						<%=/* (busType != null && !busType.isEmpty()) ? busType : */ "Volvo A/C Sleeper (2+1)"%>
					</div>
				</div>
				<div class="rating">⭐ 3.8</div>
			</div>

			<div class="schedule-price">
				<div class="timing">
					<div>
						<strong>19:00</strong> — <strong>05:55</strong>
					</div>
					<div class="duration">
						10h 55m · <span class="seats">4 Seats</span>
					</div>
				</div>
				<div class="price">₹1,284</div>
			</div>

			<%-- <%
            String image1 = bus.getImage1();
            if (image1 != null && !image1.isEmpty()) {
        %>
        <div class="bus-image">
            <img src="<%= image1 %>" alt="Bus Image" />
        </div>
        <%
            }
        %> --%>

			<div class="view-button">
				<button>View seats</button>
			</div>
		</div>
		<%
			}
			} else {
		%>
		<p>No buses found.</p>
		<%
			}
		%>
	</div>
</body>
</html>



