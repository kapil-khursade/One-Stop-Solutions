// opening tables
function openTable(id){
    document.querySelector("#"+id+">table").classList.remove("hide");
    window.location.href="#"+id;
}

// opeanig form
function openCustForm(id){
    document.querySelector("#"+id+">form").classList.remove("hide");
    window.location.href="#"+id;
}

// close table
function closeTable(id){
    document.querySelector("#"+id+">table").classList.add("hide");
}

// close Form
function closeForm(id){
    document.querySelector("#"+id+">Form").classList.add("hide");
}


// Logout customer 
function logOutCustomer(){
    let sure = confirm("Are You Sure Want To Log Out?");

    if(sure){
        alert("Loging You Out");
        localStorage.removeItem("cust");
        window.location.href="index.html";
    }
}

// Delete customer Account
function deleteCustomer(){
    let sure = confirm("Are You Sure Want To Delete Account?");

    if(sure){
        alert("Deleting Your Account!");
        window.location.href="index.html"
    }
}

// fetching customer profile
function getCustomerProfile(){

    let customer = JSON.parse(localStorage.getItem('cust'));

    document.getElementById("profile").innerHTML=null;
    
    document.getElementById("profile").innerHTML=
    `<tr>
        <td>Customer Id</td>
        <td>${customer.customerId}</td>
    </tr>
    <tr>
        <td>First Name:</td>
        <td>${customer.firstName}</td>
    </tr>
    <tr>
        <td>Last Name:</td>
        <td>${customer.lastName}</td>
    </tr>
    <tr>
        <td>Phone:</td>
        <td>${customer.mobile}</td>
    </tr>
    <tr>
        <td>Email:</td>
        <td>${customer.email}</td>
    </tr>
    <tr>
        <td>City:</td>
        <td>${customer.city}</td>
    </tr>`
}
getCustomerProfile();

// View Customer Issue
function viewCustomerIssue(event){
    event.preventDefault();
    let customer = JSON.parse(localStorage.getItem('cust'));

    const viewCustomerIssue = async() =>{
        let p = await fetch(`http://localhost:8880/customer/issue/all/${customer.customerId}`);
        let response = await p.json();
        if(response.length>0){
                document.getElementById("issueTbody").innerHTML=null;

            for(i=0; i<response.length; i++){
                document.getElementById("issueTbody").innerHTML+=
                `<tr>
                    <td>${response[i].issueId}</td>
                    <td>${response[i].issueType}</td>
                    <td>${response[i].issueDescription}</td>
                    <td>${response[i].issueStatus?"Open":"Close"}</td>
                </tr>`;
            }
        }
    }

    viewCustomerIssue();
}

// Cerate Customer Issue
function createCustomerIssue(event){
    event.preventDefault();

    let isseCreateForm = document.querySelector("#createIssue>form");

    const createIssue = async() =>{
        let options = {
            method: "POST",
            headers: {
                    "Content-type": "application/json"
            },
            body: JSON.stringify({
                "issueType":isseCreateForm.type.value,
                "issueDescription":isseCreateForm.decription.value
            }),
        }

        let customer = JSON.parse(localStorage.getItem('cust'));
        let p = await fetch(`http://localhost:8880/customer/issue/${customer.customerId}`, options)
        let response = await p.json();
        alert(response.message);

        isseCreateForm.type.value='',
        isseCreateForm.decription.value=''
    }

    createIssue();
}

// Update Customer Password
function updateCustomerPassword(event){
    event.preventDefault();

    let customer = JSON.parse(localStorage.getItem('cust'));
    let updateCustomerPasswordForm = document.querySelector("#updatePassword>form");

    const updatePassord = async() =>{
        let options = {
            method: "PUT",
            headers: {
                    "Content-type": "application/json"
            },
            body: JSON.stringify({
                "oldPassword":updateCustomerPasswordForm.oldPassword.value,
                "newPassword":updateCustomerPasswordForm.newPassword.value
            }),
        }

        let customer = JSON.parse(localStorage.getItem('cust'));
        let p = await fetch(`http://localhost:8880/customer/changepassword/${customer.customerId}`, options);
        let response = await p.json();
        alert(response.message);

        updateCustomerPasswordForm.oldPassword.value='',
        updateCustomerPasswordForm.newPassword.value=''
    }

    updatePassord();
}

// Get Issue by Id;
function getIssueById(event){
    event.preventDefault();

    let getIssueByIdForm = document.querySelector("#issueById>form");

    const getIssueById = async() =>{
       
        let p = await fetch(`http://localhost:8880/customer/issue/one/${getIssueByIdForm.issueId.value}`);
        let response = await p.json();

        getIssueByIdForm.issueId.value='';

        if(response.message!=undefined){
            alert(response.message);
        }else{
            openTable("issueById");
            document.querySelector("#issueById>table>tbody").innerHTML=
                `<tr>
                    <td>${response.issueId}</td>
                    <td>${response.issueType}</td>
                    <td>${response.issueDescription}</td>
                    <td>${response.issueStatus?"Open":"Close"}</td>
                </tr>`;
        }
    }

    getIssueById();
}

// delete Issue by Id
function deleteCustomerIssue(event){
    event.preventDefault();

    const deleteCustomerIssueForm = document.querySelector("#deleteIssue>form");

    const deleteCustomerIssue = async() =>{
        let options = {
            method: "DELETE",
            headers: {
                    "Content-type": "application/json"
            }
        }

        let p = await fetch(`http://localhost:8880/customer/issue/${deleteCustomerIssueForm.issueId.value}`, options);
        let response = await p.json();
        alert(response.message);
        deleteCustomerIssueForm.issueId.value='';
    }

    deleteCustomerIssue();
}

// Reopening the issue
function reopenCustomerIssue(event){
    event.preventDefault();

    const reopenCustomerIssueForm = document.querySelector("#reOpenIssue>form");

    const reopenCustomerIssue = async() =>{
        let options = {
            method: "PUT",
            headers: {
                    "Content-type": "application/json"
            }
        }

        let p = await fetch(`http://localhost:8880/customer/issue/${reopenCustomerIssueForm.issueId.value}`, options);
        let response = await p.json();
        alert(response.message);
        reopenCustomerIssueForm.issueId.value='';
    }

    reopenCustomerIssue();
}

