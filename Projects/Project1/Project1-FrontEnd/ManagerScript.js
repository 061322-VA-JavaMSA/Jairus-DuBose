if(!principal || principal.user_role_id !== 'manager'){
    window.location.href="./index.html";
}else{
    getUsers();
}

async function getUsers(){
    let response = await fetch(`${apiURL}/users`,{
        credentials: 'include'
    });

    if(response.status == 200){
        let data = await response.json();
        populateTable(data);
    } else {
        console.log('Unable to retrive users')
    }
}

function populateTable(data){
    let tableBody = document.getElementById('usrs-tbody');

    data.forEach(user => {
        let tableBody = document.getElementById('user-tbody');

        data.forEach(user => {
            let tr = document.createElement('tr');
            let tdId = document.createElement('td');
            let tdUsername = document.createElement('td');
            let tdRole = document.createElement('td');

            tdId.innerHTML = users.id;
            tdUsername.innerHTML = users.username;
            tdRole.innerHTML = users.user_role_id;

            tr.append(tdId);
            tr.append(tdUsername);
            tr.append(tdRole);

            tableBody.append(tr); 

        });
    })
}