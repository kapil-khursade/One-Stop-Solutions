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


// Logout customer 
function logOutCustomer(){
    let sure = confirm("Are You Sure Want To Log Out?");

    if(sure){
        alert("Loging You Out");
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

}

// View Customer Issue
function viewCustomerIssue(){

}

// Cerate Customer Issue
function createCustomerIssue(){

}

// Update Customer Password
function updateCustomerIssue(){

}