// opening the forms
function mainBox(x){
    let bgForm = document.getElementById("bgForm");
    while (bgForm.firstChild) {
        bgForm.removeChild(bgForm.firstChild);
    }
    bgForm.innerHTML=`<span onclick="closeBox()"><i class="fa fa-times-circle" aria-hidden="true"></i></span>`;
    bgForm.classList.add("show");
    const clone = x.cloneNode(true);
    x.classList.add("hide");
    clone.removeAttribute('onclick')
    bgForm.append(clone);
}

function closeBox(){
    document.getElementById("bgForm").classList.remove("show");
    document.querySelector("main>div>div").classList.remove("hide");
    document.querySelector("main>div>div:nth-child(2)").classList.remove("hide");
    document.querySelector("main>div>div:nth-child(3)").classList.remove("hide");
}

// customer login
let curOpenFormId = null;
function openForm(x){
 document.getElementById(x).classList.toggle("show");
 window.location.href='#'+x;
 curOpenFormId=x;
}

// closing form
function closeForm(){
    if(curOpenFormId!=null)document.getElementById(curOpenFormId).classList.remove("show");
}


// customer login
function customerLoginForm(event){
   event.preventDefault();
   let customerLoginForm = document.getElementById("customerLogin");

   const custLogin = async () =>{

    let options = {
        method: "POST",
        headers: {
                "Content-type": "application/json"
        },
        body: JSON.stringify({
            "username": customerLoginForm.username.value,
            "password": customerLoginForm.password.value
        }),
    }

    let p = await fetch("http://localhost:8880/customer/login", options)
    let response = await p.json();

    if(response.customerId!=null){
        alert("Login Successful")
        localStorage.setItem("cust", JSON.stringify(response));
        window.location.href="customer.html";
    }else{
        alert(response.message);
    }
   }
   custLogin();
}

// Operator Login
function operatorLoginForm(event){
    event.preventDefault();
    let operatorLoginForm = document.getElementById("operatorLogin");

    const operatorLogin = async () =>{

        let options = {
            method: "POST",
            headers: {
                    "Content-type": "application/json"
            },
            body: JSON.stringify({
                "username": operatorLoginForm.username.value,
                "password": operatorLoginForm.password.value
            }),
        }
    
        let p = await fetch("http://localhost:8880/operator/operatorLogin", options)
        let response = await p.json();
    
        if(response.operatorId!=null){
            alert("Login Successful")
            localStorage.setItem("ope", JSON.stringify(response));
            window.location.href="operator.html";
        }else{
            alert(response.message);
        }
       }
       operatorLogin();
 }

//  Admin Login
function adminLoginForm(event){
    event.preventDefault();
    let adminLoginForm = document.getElementById("adminLogin");
    
    const adminLogin = async () =>{

        let options = {
            method: "POST",
            headers: {
                    "Content-type": "application/json"
            },
            body: JSON.stringify({
                "username": adminLoginForm.username.value,
                "password": adminLoginForm.password.value
            }),
        }
    
        let p = await fetch("http://localhost:8880/admin/login", options)
        let response = await p.json();
    
        if(response.adminId!=undefined){
            alert("Login Successful")
            localStorage.setItem("admin", JSON.stringify(response));
            window.location.href="admin.html";
        }else{
            alert(response.message);
        }
       }
       adminLogin();
 }

// Customer Regi form
function customerRegiForm(event){
    event.preventDefault();
    let customerRegiForm = document.getElementById("customerRegi");

    const registerCustomer = async () => {
        let options = {
                method: "POST",
                headers: {
                        "Content-type": "application/json"
                },
                body: JSON.stringify({
                    "firstName":customerRegiForm.firstname.value,
                    "lastName":customerRegiForm.lastname.value,
                    "email":customerRegiForm.email.value,
                    "mobile":customerRegiForm.mobile.value,
                    "city":customerRegiForm.city.value,
                    "username":customerRegiForm.username.value,
                    "password":customerRegiForm.password.value,
                }),
        }

        let urlf = "http://localhost:8880/customer/register";
        let p = await fetch(urlf, options)
        let response = await p.json()
        alert(response.message);
        window.location.reload();
    }
    registerCustomer();

}

// Admin Regi form
function adminRegiForm(event){
    event.preventDefault();
    let adminRegiForm = document.getElementById("adminRegi");

    const registerAdmin = async () => {
        let options = {
                method: "POST",
                headers: {
                        "Content-type": "application/json"
                },
                body: JSON.stringify({
                    "firstName":adminRegiForm.firstname.value,
                    "lastName":adminRegiForm.lastname.value,
                    "email":adminRegiForm.email.value,
                    "departmentId":adminRegiForm.deptID.value,
                    "username":adminRegiForm.username.value,
                    "password":adminRegiForm.password.value,
                }),
        }

        let urlf = "http://localhost:8880/admin/register";
        let p = await fetch(urlf, options)
        let response = await p.json()
        alert(response.message);
        window.location.reload();
    }
    registerAdmin();

}