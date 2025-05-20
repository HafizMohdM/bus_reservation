<%@page import="com.esq.bus.reservation.slayers.service.BusLocalServiceUtil"%>
<%@page import="com.esq.bus.reservation.slayers.service.BusLocalService"%>
<%@page import="com.esq.bus.reservation.slayers.model.Bus"%>
<%@page import="java.util.List"%>
<%@ include file="./init.jsp" %>
 <%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
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