// document.getElementById('getData').onclick = getData;
document.getElementById('getData').addEventListener("click", getData);

let baseApiURL = 'https://pokeapi.co/api/v2/pokemon';

async function getData() {
    console.log('Button was clicked!');
    let id = document.getElementById('dataInput').value;
    console.log(`id = ${id}`);

    let httpResponse = await fetch(`${baseApiURL}/${id}`);

    if(httpResponse.status >= 200 && httpResponse.status < 300){
    let data = await httpResponse.json();

    populateData(data);
    
    } else {
        console.log('Invalid request.');
    }
}

function populateData(response) {
    console.log(response);
    createTable(response);
}

var tableCreation = document.getElementById('getData');
var tableDiv = document.getElementById('tableDiv');

tableCreation.onclick = createTable; 

function createTable(response){
    tableCreation.removeEventListener('click',createTable);

    var table = document.createElement('table');
    var rows = 1;
    var cols = 3;
    for (var i = 0; i < rows; i++) {
        var tr;
        tr = document.createElement('tr');
        for (var j = 0; j < cols; j++) {
            var td;
            if (i === 0) td = document.createElement('th');
            else td = document.createElement('td');
            td.innerHTML = j;
            tr.appendChild(td);
        }
        
        table.appendChild(tr);
    }
    tableDiv.appendChild(table);

    tableCreation.innerHTML = 'Remove Table';
    tableCreation.onclick = removeTable;
}

function removeTable(){
    tableCreation.innerHTML = 'Remove Table';
    tableDiv.innerHTML = '';
    tableCreation.innerHTML = 'Create Table';
    tableCreation.onclick = createTable;
}