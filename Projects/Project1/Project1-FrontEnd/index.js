let welcomeH1 = document.getElementById('welcome');

if(principal){
    welcomeH1.innerHTML = `Welcome back ${principal.username}!`
}else{
    welcomeH1.innerHTML = `Welcome to ACME Financial Reimburstment`
}