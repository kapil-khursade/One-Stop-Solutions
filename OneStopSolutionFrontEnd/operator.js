// opening tables
function openTable(id){
    document.querySelector("#"+id+">table").classList.remove("hide");
    window.location.href="#"+id;
}

// opeanig form
function openOpeForm(id){
    document.querySelector("#"+id+">form").classList.remove("hide");
    window.location.href="#"+id;
}

// Closing form
function closeForm(id){
    document.querySelector("#"+id+">form").classList.add("hide");
}

// Closing Table
function closeTable(id){
    document.querySelector("#"+id+">table").classList.add("hide");
}

// Logout Operator
function logOutOper(){
    let sure = confirm("Are You Sure Want To Log Out?");

    if(sure){
        alert("Loging You Out");
        localStorage.removeItem("ope");
        window.location.href="index.html";
    }
}

// fetching Operator profile
function getOperatorProfile(){

    let Operator = JSON.parse(localStorage.getItem('ope'));

    document.getElementById("profile").innerHTML=null;
    
    document.getElementById("profile").innerHTML=
    `<tr>
        <td>Operator Id</td>
        <td>${Operator.operatorId}</td>
    </tr>
    <tr>
        <td>First Name:</td>
        <td>${Operator.operatorFirstName}</td>
    </tr>
    <tr>
        <td>Last Name:</td>
        <td>${Operator.operatorLastName}</td>
    </tr>
    <tr>
        <td>Email:</td>
        <td>${Operator.operatorEmail}</td>
    </tr>
    <tr>
        <td>Mobile:</td>
        <td>${Operator.operatorMobile}</td>
    </tr>
    <tr>
        <td>Operator Type:</td>
        <td>${Operator.operatorType}</td>
    </tr>`
}
getOperatorProfile();

// Getting issue by customer id
const getIssueCustId = async(event)=>{
    event.preventDefault();

    let forms = document.querySelector("#issueByCustId>form");
    let tbodys = document.querySelector("#issueByCustId>table>tbody");

    let p = await fetch(`http://localhost:8880/operator/issues/id/${forms.customerId.value}`);
    let response = await p.json();

    if(response.length!=undefined && response.length>0){
        openTable('issueByCustId');
        tbodys.innerHTML='';
        for(i=0; i<response.length; i++){
            tbodys.innerHTML+=
            `<tr>
                <td>${response[i].issueId}</td>
                <td>${response[i].issueDescription}</td>
                <td>${response[i].issueType}</td>
                <td>${response[i].issueStatus?"Open":"Close"}</td>
            </tr>`
        }
    }else{
        tbodys.innerHTML='';
        alert("No Issue Exist With This Customer ID");
    }

    forms.customerId.value='';
}

// GetIssues By Type
const getIssuesByType =  async(event)=>{
    event.preventDefault();

    let forms = document.querySelector("#issueByType>form");
    let tbodys = document.querySelector("#issueByType>table>tbody");

    let p = await fetch(`http://localhost:8880/operator/issues/${forms.type.value}`);
    let response = await p.json();

    if(response.length!=undefined && response.length>0){
        openTable('issueByType');
        tbodys.innerHTML='';
        for(i=0; i<response.length; i++){
            tbodys.innerHTML+=
            `<tr>
                <td>${response[i].issueId}</td>
                <td>${response[i].issueDescription}</td>
                <td>${response[i].issueType}</td>
                <td>${response[i].issueStatus?"Open":"Close"}</td>
            </tr>`
        }
    }else{
        tbodys.innerHTML='';
        alert("No Issue Exist With Type");
    }

    forms.customerId.value='';

}

// Close issue by Id
const closeIssueById = async(event)=>{
    event.preventDefault();

    let forms = document.querySelector("#closeByIssueId>form");
    let options = {
        method: "PATCH",
        headers: {
                "Content-type": "application/json"
        },
    }
    let p = await fetch(`http://localhost:8880/operator/issue/${forms.issueId.value}`, options);
    let response = await p.json();
    forms.issueId.value='';
    alert(response.message);

}

// Get Cust By id
const getCustById = async(event)=>{
    event.preventDefault();

    let forms = document.querySelector("#getCustById>form");
    let tbodys = document.querySelector("#getCustById>table>tbody");

    let p = await fetch(`http://localhost:8880/operator/customer/id/${forms.customerId.value}`);
    let response = await p.json();
    forms.customerId.value='';
    if(response.message==undefined){
        openTable('getCustById');
        tbodys.innerHTML = 
        `<tr>
            <td>${response.customerId}</td>
            <td>${response.firstName}</td>
            <td>${response.lastName}</td>
            <td>${response.mobile}</td>
            <td>${response.email}</td>
        </tr>`;
    }else{
        alert(response.message);
    }
}

// Get Customer By First Name
const getCustByFirstName = async(event)=>{
    event.preventDefault();

    let forms = document.querySelector("#getCustByFirstname>form");
    let tbodys = document.querySelector("#getCustByFirstname>table>tbody");

    let p = await fetch(`http://localhost:8880/operator/customer/fn/${forms.firstName.value}`);
    let response = await p.json();
    forms.firstName.value='';
    if(response.message==undefined){
        openTable('getCustByFirstname');
        tbodys.innerHTML=null;
        for(i=0; i<response.length; i++){
            tbodys.innerHTML += 
            `<tr>
                <td>${response[i].customerId}</td>
                <td>${response[i].firstName}</td>
                <td>${response[i].lastName}</td>
                <td>${response[i].mobile}</td>
                <td>${response[i].email}</td>
            </tr>`;  
        }
    }else{
        tbodys.innerHTML=null;
        alert(response.message);
    }
}

// Get Customer By Email
const getCustByEmail = async(event)=>{
    event.preventDefault();

    let forms = document.querySelector("#getCustByEmail>form");
    let tbodys = document.querySelector("#getCustByEmail>table>tbody");

    let p = await fetch(`http://localhost:8880/operator/customer/e/${forms.email.value}`);
    let response = await p.json();
    forms.email.value='';
    if(response.message==undefined){
        openTable('getCustByEmail');
        tbodys.innerHTML=null;
            tbodys.innerHTML = 
            `<tr>
                <td>${response.customerId}</td>
                <td>${response.firstName}</td>
                <td>${response.lastName}</td>
                <td>${response.mobile}</td>
                <td>${response.email}</td>
            </tr>`;  
    }else{
        tbodys.innerHTML=null;
        alert(response.message);
    }
}

// Lock Customer By Id
const lockCustomerById = async(event)=>{
    event.preventDefault();
    let forms = document.querySelector("#lockCustomer>form");

    let options = {
        method: "PATCH",
        headers: {
                "Content-type": "application/json"
        }
    }
    let p = await fetch(`http://localhost:8880/operator/customer/${forms.customerId.value}`, options);
    let response = await p.json();
    forms.customerId.value='';
    alert(response.message);
}

// Create solution by for issue id
const createSolution = async(event)=>{
    event.preventDefault();
    let forms = document.querySelector("#createSolution>form");

    let options = {
        method: "POST",
        headers: {
                "Content-type": "application/json"
        },
        body: JSON.stringify({
            'solutionDescription':forms.description.value
        }),
    }

    let Operator = JSON.parse(localStorage.getItem('ope'));

    let p = await fetch(`http://localhost:8880/operator/solution/${forms.issueId.value}/${Operator.operatorId}`, options);
    let response = await p.json();
    forms.description.value='';
    forms.issueId.value='';
    alert(response.message);
}

// Get Solution By Issue Id
const getSolutionById = async(event)=>{
    event.preventDefault();

    let forms = document.querySelector("#getSolutionByIssueId>form");
    let tbodys = document.querySelector("#getSolutionByIssueId>table>tbody");

    let p = await fetch(`http://localhost:8880/operator/solutions/${forms.issueId.value}`);
    let response = await p.json();

    if(response.message==undefined){
        openTable('getSolutionByIssueId')
        tbodys.innerHTML=null;
        for(i=0; i<response.length; i++){
            tbodys.innerHTML+=
            `<tr>
                <td>${response[i].solutionId}</td>
                <td>${response[i].solutionDescription}</td>
                <td>${response[i].solutionDate}</td>
            </tr>`
        }
    }else{
        tbodys.innerHTML=null;
        alert(response.message);
        forms.issueId.value='';
    }
    forms.issueId.value='';
}

// Delete solution by ID
const deleteSolutionById = async(event)=>{
    event.preventDefault();

    let forms = document.querySelector("#deleteSoulById>form");

    let options = {
        method: "DELETE",
        headers: {
                "Content-type": "application/json"
        },
    }

    let p = await fetch(`http://localhost:8880/operator/solution/${forms.solutionId.value}`, options);
    let response = await p.json();
    forms.solutionId.value='';
    alert(response.message);
}