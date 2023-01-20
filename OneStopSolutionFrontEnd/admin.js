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
        window.location.href="index.html";
    }
}