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

// Close Tables
function closeTable(id){
    document.querySelector("#"+id+">table").classList.add("hide");
}

// Close Form
function closeForm(id){
    document.querySelector("#"+id+">Form").classList.add("hide");
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

// Get All Department
const getAllDepartment = async()=>{
    let p = await fetch(`http://localhost:8880/admin/departments`);
    let response = await p.json();

    if(response.length>0){
        document.querySelector("#getAllDepart>table>tbody").innerHTML='';
      for(i=0; i<response.length; i++){
        document.querySelector("#getAllDepart>table>tbody").innerHTML+=
        `<tr>
            <td>${response[i].departmentId}</td>
            <td>${response[i].departmentName}</td>
        </tr>`;
      }
    }
}


// Creating Department
function createDept(event){
    event.preventDefault();

    const createDeptForm = document.querySelector("#createDepart>form");

    const createDept = async()=>{
        let options = {
            method: "POST",
            headers: {
                    "Content-type": "application/json"
            },
            body: JSON.stringify({
                "departmentName":createDeptForm.departmentName.value
            }),
        }

        let p = await fetch(`http://localhost:8880/admin/department`, options);
        let response = await p.json();
        alert(response.message);
        createDeptForm.departmentName.value='';
    }

    createDept();
}

// Deleting the Department
const deleteDepart = async(event)=>{
   event.preventDefault();

   const deleteDepartForm = document.querySelector("#deleteDepart>form");

   let options = {
        method: "DELETE",
        headers: {
                "Content-type": "application/json"
        }
   }

   let p = await fetch(`http://localhost:8880/admin/departments/${deleteDepartForm.departmentId.value}`, options);
   let response = await p.json();
   alert(response.message);
   deleteDepartForm.departmentId.value='';
}

// Updating the department
const updateDepart = async(event)=>{
    event.preventDefault();

    const updateDepartForm = document.querySelector("#updateDepart>form");
    let options = {
        method: "PATCH",
        headers: {
                "Content-type": "application/json"
        }
    }

   var url = `http://localhost:8880/admin/departments/${updateDepartForm.departmentId.value}/
   ${updateDepartForm.departmentName.value}`;
   let p = await fetch(url, options);
   let response = await p.json();
   alert(response.message);
   updateDepartForm.departmentName.value='';
   updateDepartForm.departmentId.value='';
}

// Get Department By Id
const getDeptById = async(event)=>{
    event.preventDefault();
    const getDeptByIdForm = document.querySelector("#getDepartById>form");
   
    let p = await fetch(`http://localhost:8880/admin/departments/${getDeptByIdForm.departmentId.value}`);
    let response = await p.json();
    if(response.message!=undefined){
        alert(response.message);
    }else{
        openTable("getDepartById");
        document.querySelector("#getDepartById>table>tbody").innerHTML=
        `
        <tr>
            <td>${response.departmentId}</td>
            <td>${response.departmentName}</td>
        </tr>
        `
    }
    getDeptByIdForm.departmentId.value='';
}

// Create Operator 
const createOperator = async(event)=>{
    event.preventDefault();
    const getDeptByIdForm = document.querySelector("#createOperator>form");

    let options = {
        method: "POST",
        headers: {
                "Content-type": "application/json"
        },
        body: JSON.stringify({
            'operatorFirstName':getDeptByIdForm.firstname.value,
            'operatorLastName':getDeptByIdForm.lastname.value,
            'operatorEmail':getDeptByIdForm.email.value,
            'operatorMobile':getDeptByIdForm.mobile.value,
            'operatorType':getDeptByIdForm.type.value,
            'departmentId':getDeptByIdForm.deptId.value,
            'username':getDeptByIdForm.username.value,
            'password':getDeptByIdForm.password.value,
        })
    }

    let p = await fetch(`http://localhost:8880/admin/operator`, options);
    let response = await p.json();
    alert(response.message);
    getDeptByIdForm.firstname.value='';
    getDeptByIdForm.lastname.value='';
    getDeptByIdForm.email.value='';
    getDeptByIdForm.mobile.value='';
    getDeptByIdForm.type.value='';
    getDeptByIdForm.deptId.value='';
    getDeptByIdForm.username.value='';
    getDeptByIdForm.password.value='';
}

// Get Operator by id
const getOperatorById = async(event)=>{
    event.preventDefault();

    let getOperatorByIdForm = document.querySelector("#getOperById>form");

    let p = await fetch(`http://localhost:8880/admin/operators/${getOperatorByIdForm.operatorId.value}`);
    let response = await p.json();

    if(response.message!=undefined){
        alert(response.message);
    }else{
        openTable('getOperById');
        document.querySelector("#getOperById>table>tbody").innerHTML=
        `<tr>
            <td>${response.operatorId}</td>
            <td>${response.operatorFirstName}</td>
            <td>${response.operatorLastName}</td>
            <td>${response.operatorMobile}</td>
            <td>${response.login.username}</td>
            <td>${response.login.password}</td>
            <td>${response.operatorType}</td>
        </tr>
        `
    }
    getOperatorByIdForm.operatorId.value='';
}

// Get all opertrators 
const getAllOperator = async()=>{
    let p = await fetch(`http://localhost:8880/admin/operators`);
    let response = await p.json();

    if(response.length>0){
        openTable('getAllOperById');
        document.querySelector("#getAllOperById>table>tbody").innerHTML='';
        for(i=0; i<response.length; i++){
            document.querySelector("#getAllOperById>table>tbody").innerHTML+=
            `<tr>
                <td>${response[i].operatorId}</td>
                <td>${response[i].operatorFirstName}</td>
                <td>${response[i].operatorLastName}</td>
                <td>${response[i].operatorMobile}</td>
                <td>${response[i].operatorType}</td>
            </tr>`
        }
    }else{
        alert(response.message);
    }
}

// Delete Operator By Id
const deleteOperatorById = async(event)=>{
    event.preventDefault();

    let deleteOperatorByIdForm = document.querySelector("#deleteOperById>form");

    let options = {
        method: "DELETE",
        headers: {
                "Content-type": "application/json"
        }
    }

    let p = await fetch(`http://localhost:8880/admin/operators/${deleteOperatorByIdForm.operatorId.value}`, options);
    let response = await p.json();
    alert(response.message);
}