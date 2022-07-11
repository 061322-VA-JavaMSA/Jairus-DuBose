if(!principal || principal.role !== 'ADMIN'){
    window.location.href="./index.html";
}else{
    getUsers();
}

async function getUsers(){
    let response = await fetch(`${apiURL}/users`,{
        credentials: 'include'
    });

    
}