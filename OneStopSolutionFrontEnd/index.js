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
   alert("login Success");
   window.location.href="customer.html"
}

// Operator Login
function operatorLoginForm(event){
    event.preventDefault();
    let operatorLoginForm = document.getElementById("operatorLogin");
    alert("Login Successfull");
    window.location.href="operator.html"
 }

//  Admin Login
function adminLoginForm(event){
    event.preventDefault();
    let adminLoginForm = document.getElementById("adminLogin");
    alert("Login Successfull");
    window.location.href="admin.html"
 }

// Customer Regi form
function customerRegiForm(event){
    event.preventDefault();
    let customerRegiForm = document.getElementById("customerRegi");

}

// Admin Regi form
function adminRegiForm(event){
    event.preventDefault();
    let adminRegiForm = document.getElementById("adminRegi");

}