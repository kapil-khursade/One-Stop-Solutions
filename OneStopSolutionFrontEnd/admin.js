// opening tables
function openTable(id){
    document.querySelector("#"+id+">table").classList.remove("hide");
    window.location.href="#"+id;
}

// opeanig form
function openAdmiForm(id){
    document.querySelector("#"+id+">form").classList.remove("hide");
    window.location.href="#"+id;
}

// Logout Admin
function logOutAdmin(){
    let sure = confirm("Are You Sure Want To Log Out?");

    if(sure){
        alert("Loging You Out");
        localStorage.removeItem("admin");
        window.location.href="index.html";
    }
}

// fetching Admin profile
function getAdminProfile(){

    let Admin = JSON.parse(localStorage.getItem('admin'));

    document.getElementById("profile").innerHTML=null;
    
    document.getElementById("profile").innerHTML=
    `<tr>
        <td>Admin Id</td>
        <td>${Admin.adminId}</td>
    </tr>
    <tr>
        <td>First Name:</td>
        <td>${Admin.firstName}</td>
    </tr>
    <tr>
        <td>Last Name:</td>
        <td>${Admin.lastName}</td>
    </tr>
    <tr>
        <td>Email:</td>
        <td>${Admin.email}</td>
    </tr>
    <tr>
        <td>Department:</td>
        <td>${Admin.department.departmentName}</td>
    </tr>`
}
getAdminProfile();