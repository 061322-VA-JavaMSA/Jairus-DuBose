let apiURL = 'http://localhost:8080/Project1';

let principalString = sessionStorage.getItem('principal');

let principal = null;

let nav_right = document.getElementById("nav-right");
let nav_left = document.getElementById("nav-left");

if (principalString){
    principal = JSON.parse(principalString);

    if (principal.role === 'manager'){
        createNavElement('Manager',nav_left,'./ManagerView.html', null);
    }

    createNavElement('Logout',nav_right,null,logout);
}else {
    createNavElement('Login', nav_right, './LoginView.html',null);
}

async function logout(){

    let response = await fetch(`${apiURL}/auth`,{
        method: 'DELETE',
        credentials: 'include'
    });

    if (response.status == 200){
        sessionStorage.clear();
        principal = null;
        window.location.href="./index.html";
    } else {
        console.log('Unable to logout')
    }
}

function createNavElement(innerHTML, parentElement,link,callback){
    let li = document.createElement('li');

    li.setAttribute('class','nav-item');

    let a = document.createElement('a');

    a.setAttribute('class', 'nav-link');

    if (link){
        a.setAttribute('href',link);
    } else{
        a.setAttribute('href', '#');
    }

    if (callback){
        a.addEventListener('click', callback);
    }

    a,innerHTML = innerHTML;

    li.appendChild(a);
    
    parentElement.appendChild(li);
}