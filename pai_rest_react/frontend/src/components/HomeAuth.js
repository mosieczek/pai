import React, {useState, useEffect} from 'react';
import { dataTest } from '../services/dataService';
import Modal from "react-bootstrap/Modal";
import CloseOutlinedIcon from '@material-ui/icons/CloseOutlined';
import kitchen from '../img/kitchen.jpg'



export const HomeAuth = () => {
    const [isAuth, setIsAuth] = useState(false)
    const token = localStorage.getItem("token");
    const [modalState, setModalState] = useState(false)
    const [userDetails, setUserDetails] = useState({username:'', name:'', surname:''})


    useEffect(() => {
      if(token === null){
        setIsAuth(false)
      }else{
        setIsAuth(true)
        
      }
    },[token])
    const handleDataTest = async () => {
        const data = await dataTest()
        setUserDetails(data.data)
        setModalState(true)
    }

    if(isAuth && token !== null){
        return (
            <div className='App-body' 
            style={{
                backgroundImage: `url(${kitchen})`,
                backgroundRepeat: 'no-repeat',
                backgroundAttacjment: 'fixed',
                backgroundSize: 'cover'
             }}>

                <button className="btn btn-lg btn-primary btn-block" onClick={handleDataTest}>Informacje o użytkowniku</button>
                
                <Modal 
                show={modalState}
                onHide={()=>setModalState(false)}
                style={
                    {
                        content: {
                            position: 'center',
                            height: 'auto',
                            textAlign: 'center',
                            
                        }
                    }
                }
                >
                    <div className="text-right" style={{textAlign:'right'}}>
                        <button className = "btn btn-light btn-outline-primary" onClick={() => setModalState(false)}><CloseOutlinedIcon/></button>
                    </div>
                    <div style={{textAlign:'center'}}>
                        <h5>Login: {userDetails.username}</h5>
                        <h5>Imię: {userDetails.name}</h5>
                        <h5>Nazwisko: {userDetails.surname}</h5>
                    </div>


                </Modal>
            </div>
        );
    }else{
        return(
            <div className='App-body'>
                Ładowanie
            </div>
        )
    }
       

};
