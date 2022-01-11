

document.addEventListener('DOMContentLoaded', () => {
getAllStudents();
});
function getAllStudents(){
    fetch("http://localhost:8080/students/all")
    .then((response) => {
        if (response.status !== 200) {
            return Promise.reject('Coś poszło nie tak!'); 
        }
        return response.json();
    })
    .then( (data) => {  pokazTabele(data); } )
    .catch( (error) => { console.log(error); } );
}
function pokazTabele(response){ 
    console.log("test");
    var main = document.getElementById('main');
    var content="<table border='1'> <thead> <tr> <th> ID</th> <th> Imię</th>"+
    "<th>Nazwisko</th><th>Średnia</th></tr></thead><tbody>";
    for (var st in response) {
        var id = response[st].id;
        var name = response[st].name;
        var surname = response[st].surname;
        var average = response[st].avarage;
        content += "<tr><td>" + id + "</td><td>" + name + "</td><td>" + surname +
        "</td><td>" + average + "</td><td><button class='editBtn' onclick='edytuj(this)' value=" + id+ ">Edytuj</button></td>\n\
        <td><button class='editBtn' onclick='usun(this)' value=" + id+ ">Usuń</button></td></tr>";
    }
    content += "</tbody></table>";
    main.innerHTML = content;
}

function dodaj(){
    event.preventDefault();
    var st={}; //tworzymy obiekt z polami o wartościach pobranych z pól formularza
//    st.id=document.getElementById('id').value;
    st.name=document.getElementById('name').value;
    st.surname=document.getElementById('surname').value;
    st.avarage=document.getElementById('avarage').value;
    fetch("http://localhost:8080/students/add", {
        method: "post",
        body: JSON.stringify(st),
        headers: {"Content-type": "application/json; charset=UTF-8"}
    })
    .then(response => response.json())

    alert("dodano");
    window.location.reload();
} 

function edytuj(e){

    const id = e.value;
    fetch("http://localhost:8080/students/all")
    .then((response) => {
        if (response.status !== 200) {
            return Promise.reject('Coś poszło nie tak!'); 
        }
        return response.json();
    })
    .then( (data) => { pokazTabele(data); } )
    .catch( (error) => { console.log(error); } );
    

    
    var xhttp = new XMLHttpRequest();
    xhttp.open("GET", "http://" + window.location.host +
            "/students/all", true);
    xhttp.onreadystatechange = function (e) {
            var inputs = document.querySelectorAll('.editBtn');
            inputs.forEach((input)=>{
              input.disabled = true;
            });
        if (xhttp.readyState === 4) {
            if (xhttp.responseText !== "[]") {
                if (xhttp.status === 200) {

                    var response = JSON.parse(xhttp.responseText);
                    for (var st in response) {

                        var idTest = response[st].id;

                        if (id == idTest) { //wybranie właściwych danych po id

                            var name = response[st].name;
                            var surname = response[st].surname;
                            var avarage = response[st].avarage;
                        


                            location.href = window.location.host + "/"; //odświeżenie strony w celu wprowadzenia poniższych wartości
                            var form = document.getElementById("add");

                            document.getElementById("name").value = name;
                            document.getElementById("surname").value = surname;
                            document.getElementById("avarage").value = avarage;
                         

                            var el = document.getElementById("myButton");
                            el.firstChild.data = "Zapisz zmiany";

                            var el2 = document.getElementById("textStud");
                            el2.firstChild.data = "Edytuj studenta!";

                            document.getElementById("myButton").onclick = "";
                            document.getElementById("myButton").addEventListener("click", function () {


                                var obj = {};
                                var elements = form.querySelectorAll("input, input, input");
                                //obj[ 'id' ] = id;

                                for (var i = 0; i < elements.length; ++i) {
                                    var element = elements[i];
                                    var name = element.name;
                                    var value = element.value;

                                    if (name) {
                                        obj[ name ] = value;
                                    }
                                }
                        
                                var content = JSON.stringify(obj);

                                var xhr = new XMLHttpRequest();

                                
                                var url = "http://" + window.location.host + "/update/" + id;

                                xhr.open("PUT", url, true);
                                xhr.setRequestHeader("Content-Type", "application/json");
                                xhr.onload = function () {
                                    var users = JSON.parse(xhr.responseText);
                                    if (xhr.readyState == 4 && xhr.status == "200") {
                                        console.table(users);

                                    } else {
                                        console.error(users);
                                        alert("Błąd");
                                    }
                                }
                                xhr.send(content);
                                alert("Edytowano studenta o id: " + id);
                            });
                        }
                    }
                }
            }
        }
    };
    xhttp.send();
}

function usun(e){
    const id = e.value;
        fetch(`http://localhost:8080/delete/${id}`, {
        method: "delete",
        headers: {"Content-type": "application/json; charset=UTF-8"}
    })
    window.location.reload();
}