<%-- 
    Document   : update-house.jsp
    Created on : Mar 16, 2024, 1:11:00 AM
    Author     : acer
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">


<title>bs5 edit profile account details - Bootdey.com</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet">
<style type="text/css">
    	body{margin-top:20px;
background-color:#f2f6fc;
color:#69707a;
}
.img-account-profile {
    height: 10rem;
}
.rounded-circle {
    border-radius: 50% !important;
}
.card {
    box-shadow: 0 0.15rem 1.75rem 0 rgb(33 40 50 / 15%);
}
.card .card-header {
    font-weight: 500;
}
.card-header:first-child {
    border-radius: 0.35rem 0.35rem 0 0;
}
.card-header {
    padding: 1rem 1.35rem;
    margin-bottom: 0;
    background-color: rgba(33, 40, 50, 0.03);
    border-bottom: 1px solid rgba(33, 40, 50, 0.125);
}
.form-control, .dataTable-input {
    display: block;
    width: 100%;
    padding: 0.875rem 1.125rem;
    font-size: 0.875rem;
    font-weight: 400;
    line-height: 1;
    color: #69707a;
    background-color: #fff;
    background-clip: padding-box;
    border: 1px solid #c5ccd6;
    -webkit-appearance: none;
    -moz-appearance: none;
    appearance: none;
    border-radius: 0.35rem;
    transition: border-color 0.15s ease-in-out, box-shadow 0.15s ease-in-out;
}

.nav-borders .nav-link.active {
    color: #0061f2;
    border-bottom-color: #0061f2;
}
.nav-borders .nav-link {
    color: #69707a;
    border-bottom-width: 0.125rem;
    border-bottom-style: solid;
    border-bottom-color: transparent;
    padding-top: 0.5rem;
    padding-bottom: 0.5rem;
    padding-left: 0;
    padding-right: 0;
    margin-left: 1rem;
    margin-right: 1rem;
}
    </style>
</head>
<body>
<div class="container-xl px-4 mt-4">

<nav class="nav nav-borders">
<a class="nav-link active ms-0" href="https://www.bootdey.com/snippets/view/bs5-edit-profile-account-details" target="__blank">Profile</a>
<a class="nav-link" href="https://www.bootdey.com/snippets/view/bs5-profile-billing-page" target="__blank">Billing</a>
<a class="nav-link" href="https://www.bootdey.com/snippets/view/bs5-profile-security-page" target="__blank">Security</a>
<a class="nav-link" href="https://www.bootdey.com/snippets/view/bs5-edit-notifications-page" target="__blank">Notifications</a>
</nav>
<hr class="mt-0 mb-4">
<div class="row">
<div class="col-xl-4">

<div class="card mb-4 mb-xl-0">
<div class="card-header">Name House </div>
<div class="card-body text-center">

<form id="myForm" action="houseController" method="post" enctype="multipart/form-data">
    <img class="img-account-profile rounded-circle mb-2" src="${p.getImg()}" alt>
<div class="small font-italic text-muted mb-4">JPG or PNG no larger than 5 MB</div>
    <input type="file" name="file" accept="image/png, image/jpeg" class="mb-2" required>
</div>
</div>
</div>
<div class="col-xl-8">

<div class="card mb-4">
<div class="card-header">House Details</div>
<div class="card-body">
<input class="form-control" id="id" name="id" type="hidden"  value="${p.getId()}">
<div class="mb-3">
<label class="small mb-1" for="inputAddress">Address </label>
<input class="form-control" id="inputAddress" name="address" type="text" placeholder="Enter your username" value="${p.getAddress()}">
</div>

<div class="row gx-3 mb-3">

<div class="col-md-6">
<label class="small mb-1" for="inputSize">Size</label>
<input class="form-control" id="size" name="size" type="text" placeholder="Enter your first name" value="${p.getSize()}">
</div>

<div class="col-md-6">
<label class="small mb-1" for="inputBed">Bed</label>
<input class="form-control" id="bed" name="bed" type="text" placeholder="Enter your last name" value="${p.getBed()}">
</div>
</div>

<div class="row gx-3 mb-3">

<div class="col-md-6">
<label class="small mb-1" for="inputBath">Bath</label>
<input class="form-control" id="bath" name="bath" type="text" placeholder="Enter your organization name" value="${p.getBath()}">
</div>

<div class="col-md-6">
<label class="small mb-1" for="inputGara">Gara</label>
<input class="form-control" id="gara" name="gara" type="text" placeholder="Enter your location" value="${p.getGara()}">
</div>
</div>

<div class="mb-3">
<label class="small mb-1" for="inputDescription">Description</label>
<input class="form-control" id="description" name="description" type="email" placeholder="Enter your email address" value="${p.getDescription()}">
</div>

<div class="mb-3">
<label class="small mb-1" for="input">Price</label>
<input class="form-control" id="price" type="text" name="price" placeholder="Enter your birthday" value="${p.getPrice()}" >
</div>
</div>

<button id="saveChangesBtn" class="btn btn-primary" type="button">Update</button>
</form>
</div>
</div>
</div>
</div>
</div>
<script>
document.getElementById("saveChangesBtn").addEventListener("click", function() {
    // Lấy giá trị từ các trường nhập
    var address = document.getElementById("inputAddress").value.trim();
    var size = document.getElementById("size").value.trim();
    var bed = document.getElementById("bed").value.trim();
    var bath = document.getElementById("bath").value.trim();
    var gara = document.getElementById("gara").value.trim();
    var description = document.getElementById("description").value.trim();
    var price = document.getElementById("price").value.trim();

    // Lấy giá trị mặc định từ trường value của các trường
    var defaultAddress = "${p.getAddress()}";
    var defaultSize = "${p.getSize()}";
    var defaultBed = "${p.getBed()}";
    var defaultBath = "${p.getBath()}";
    var defaultGara = "${p.getGara()}";
    var defaultDescription = "${p.getDescription()}";
    var defaultPrice = "${p.getPrice()}";

    // Kiểm tra xem các trường có rỗng không
    if (address === '') {
        document.getElementById("inputAddress").value = defaultAddress;
    }
    if (size === '') {
        document.getElementById("size").value = defaultSize;
    }
    if (bed === '') {
        document.getElementById("bed").value = defaultBed;
    }
    if (bath === '') {
        document.getElementById("bath").value = defaultBath;
    }
    if (gara === '') {
        document.getElementById("gara").value = defaultGara;
    }
    if (description === '') {
        document.getElementById("description").value = defaultDescription;
    }
    if (price === '') {
        document.getElementById("price").value = defaultPrice;
    }

    // Gửi form
    document.getElementById("myForm").submit();
});
</script>
<script src="https://code.jquery.com/jquery-1.10.2.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js"></script>
<script type="text/javascript">
	
</script>
</body>
</html>