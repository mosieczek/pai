import './App.css';
import { useGetStudents } from './hooks/useGetStudents';
import { useState } from 'react';
import { addStudent } from './hooks/addStudent';
import { Modal } from 'react-bootstrap';
import { editStudent } from './hooks/editStudent';
import { deleteStudent } from './hooks/deleteStudent';


function App() {
  const [modalState, setModalState] = useState(false)
  const [name, setName] = useState('')
  const [surname, setSurname] = useState('')
  const [avarage, setAvarage] = useState(0)
  const [nameEdit, setEditName] = useState('')
  const [surnameEdit, setEditSurname] = useState('')
  const [avarageEdit, setEditAvarage] = useState(0)
  const [editingItemId, setEditingItemId] = useState(null)

  const students = useGetStudents()


  function handleEditClick(prop){
    setModalState(true)
    setEditingItemId(prop)
    console.log(prop)
  }
  function handleDeleteClick(prop){
    console.log(prop)
    deleteStudent(prop)
    window.location.reload();
  }

  function saveStudent(event){
    event.preventDefault();
    if(name !== '' && surname !== ''){
      const tempStudent = {
        name: name,
        surname: surname,
        avarage: avarage
      }
      if(tempStudent !== null && tempStudent !== []){
        addStudent(tempStudent)
      }
      setName('')
      setSurname('')
      setAvarage(0)
      window.location.reload();
    }
  }

  function editStudentHandler(event){
    event.preventDefault();
    console.log(editingItemId)

    if(nameEdit !== '' && surnameEdit !== ''){
      const tempStudent = {
        id: editingItemId,
        name: nameEdit,
        surname: surnameEdit,
        avarage: avarageEdit
      }
      if(tempStudent !== null && tempStudent !== []){
        editStudent(tempStudent)
      }
      setName('')
      setSurname('')
      setAvarage(0)
      window.location.reload();
    }
  }

  if(students !== null){
    return (
      <div className="App">

          <h1>Lista studentów</h1>
          <table className='studentsTable'>
            <thead>
              <tr>
                <th>ID</th>
                <th>Imię</th>
                <th>Nazwisko</th>
                <th>Średnia</th>
                <th>Funkcje</th>
              </tr>
            </thead>
            <tbody>
              {students.map((item) => 
                <tr key={item.id}>
                  <td>{item.id}</td>
                  <td>{item.name}</td>
                  <td>{item.surname}</td>
                  <td>{item.avarage}</td>
                  <td><button onClick={() => {handleEditClick(item.id)}}>Edytuj</button></td>
                  <td><button onClick={() => {handleDeleteClick(item.id)}}>Usuń</button></td>
                </tr>
              )}
            </tbody>
          </table>

          <h1>Dodaj nowego studenta</h1>
          <form onSubmit={saveStudent}>
            <div className="form-group">
              <label for="name">Imię:</label>
              <input type="text" className="form-control" id="name" value={name} onChange={(e) => {setName(e.target.value)}}/>
            </div>
            <div className="form-group">
              <label for="surname">Nazwisko:</label>
              <input type="text" className="form-control" id="surname" value={surname} onChange={(e) => {setSurname(e.target.value)}}/>
            </div>            
            <div className="form-group">
              <label for="avarage">Średnia:</label>
              <input type="number" step="any" className="form-control" id="avarage" value={avarage} onChange={(e) => {setAvarage(e.target.value)}}/>
            </div>
            <button type="submit">Zapisz!</button>
          </form>
          <Modal
          className='modal'
          show={modalState}
          onHide={() => setModalState(false)}
          style={
            {
              marginLeft: 50,
                content: {
                    position: 'fixed',
                    height: 'auto',

                    textAlign: 'center'
                }
            }
          }
          >
            
            <h2>Edycja danych studenta o ID: {editingItemId}</h2>
            <form onSubmit={editStudentHandler}>
            <div className="form-group">
              <label for="name">Imię:</label>
              <input type="text" className="form-control" id="name" value={nameEdit} onChange={(e) => {setEditName(e.target.value)}}/>
            </div>
            <div className="form-group">
              <label for="surname">Nazwisko:</label>
              <input type="text" className="form-control" id="surname" value={surnameEdit} onChange={(e) => {setEditSurname(e.target.value)}}/>
            </div>            
            <div className="form-group">
              <label for="avarage">Średnia:</label>
              <input type="number" step="any" className="form-control" id="avarage" value={avarageEdit} onChange={(e) => {setEditAvarage(e.target.value)}}/>
            </div>
            <button type="submit">Zapisz!</button>
          </form>
          <button onClick={() => setModalState(false)}>Anuluj</button>
          </Modal>
        </div>
    );
  }else{
    return (
      <div className="App">
        <header className="App-header">
          <h1>Błąd łączenia z bazą</h1>
        </header>
      </div>
    );
  }
 
}

export default App;
