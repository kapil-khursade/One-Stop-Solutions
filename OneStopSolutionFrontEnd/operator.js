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