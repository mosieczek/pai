import React, {useState, useEffect} from 'react';
import { getCurrentUser } from '../services/authService';
import { getProducts } from '../services/dataService';
import Table from '@mui/material/Table'
import TableBody from '@mui/material/TableBody';
import TableCell from '@mui/material/TableCell';
import TableHead from '@mui/material/TableHead';
import TableRow from '@mui/material/TableRow';
import EditableTableCell from './EditableTableCell';
import Modal from "react-bootstrap/Modal";
import CloseOutlinedIcon from '@material-ui/icons/CloseOutlined';
import { addProduct, dataTest, deleteProduct, updateProduct } from '../services/dataService';
import emptyFridge from '../img/emptyFridge.jpg'
import insideFridge from '../img/insideFridge.jpg'

export const Fridge = () => {
    const [products, setProducts] = useState([])
    const [currentUser, setCurrentUser] = useState('')
    const token = localStorage.getItem("token");
    const [modalState, setModalState] = useState(false)
    const [modalEditState, setModalEditState] = useState(false)
    const [product, setProduct] = useState('')
    const [quantity, setQuantity] = useState('')
    const [productEdit, setProductEdit] = useState('')
    const [quantityEdit, setQuantityEdit] = useState('')
    const [idEdit, setIdEdit] = useState(null)


    useEffect(() => {
        if(token !== null){
        setCurrentUser(getCurrentUser().sub)
        }
    },[])
    useEffect(() => {
        const fetchData = async () => {
            const data = await getProducts()
            setProducts(data.data)
        }
        fetchData()
        .catch(console.error)
        
    },[])
    const handleAddProduct = async () => {
        const user = await dataTest()
        const newProduct = {
            user: user.data,
            product: product,
            quantity: quantity
        }
        try{
            const add = await addProduct(newProduct)
            setModalState(false)
            window.location.reload()

        }catch(error){
            console.log(error)
        }

    }

    const handleEditProduct = async () => {
        const user = await dataTest()
        const editProduct = {
            user: user.data,
            product: productEdit,
            quantity: quantityEdit
        }
        try{
            const edit = await updateProduct(idEdit, editProduct)
            setModalEditState(false)
            setProductEdit('')
            setQuantityEdit('')
            setIdEdit(null)
            window.location.reload()

        }catch(error){
            console.log(error)
        }
    }
    const handleDeleteProduct = async (data) => {
        try{
            const deleteProd = await deleteProduct(data)
            window.location.reload()
        }
        catch(error){
            console.log(error)
        }
    }

    if(products.length !== 0 && token !== null && currentUser !== '' ) {
        return (
        <div className='App-body' 
            style={{
                backgroundImage: `url(${insideFridge})`,
                backgroundRepeat: 'no-repeat',
                backgroundAttacjment: 'fixed',
                backgroundSize: 'cover'
             }}>
            <h1 style={{textShadow:'3px 3px #000000'}}>Zawartość lodówki użytkownika {currentUser}</h1>
            <div className='my-2'>
                <button className="btn btn-lg btn-primary btn-block my-2" onClick={() => setModalState(true)}>Dodaj produkt</button>
            </div>
            <Table style={{width:'90%', fontSize:'larger', border:'1', backgroundColor: 'rgba(52, 52, 52, 0.8)'}} border="1">
                <TableHead>
                    <TableRow style={{color:'white'}}>
                        <TableCell style={{color: 'white', fontWeight: 'bold', fontSize:'1.1em'}}>Produkt</TableCell>
                        <TableCell style={{color: 'white', fontWeight: 'bold', fontSize:'1.1em'}}>Ilość</TableCell>
                        <TableCell style={{color: 'white', width: '10em', fontWeight: 'bold', fontSize:'1.1em', textAlign:'center'}}>Akcja</TableCell>
                    </TableRow>
                </TableHead>
                <TableBody>
                    {products.map((product) => 
                        <TableRow key={product.id}>
                            <TableCell style={{color: 'white', fontSize:'1em'}}>{product.product}</TableCell>
                            <TableCell style={{color: 'white', fontSize:'1em'}}>{product.quantity}</TableCell>
                            <TableCell style={{textAlign:'center'}}>
                                <button className="btn btn-lg btn-primary btn-block" onClick={() => {
                                    setProductEdit(product.product)
                                    setQuantityEdit(product.quantity)
                                    setIdEdit(product.id)
                                    setModalEditState(true)
                                }}>Edytuj</button>
                                <button className="btn btn-lg btn-primary btn-block" onClick={() => handleDeleteProduct(product.id)}>Usuń</button>
                            </TableCell>
                        </TableRow>
                        
                    )}
                </TableBody>
            </Table>
            
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
                <form>
                    <div className="input-group mb-4">
                        <input variant="standard"
                        className="form-control"
                        type="text"
                        value={product}
                        onChange = {(e) => setProduct(e.target.value)}
                        placeholder = "Produkt"
                        required
                        />
                    </div>
                    <div className="input-group mb-4">
                        <input placeholder="Ilość" variant="standard"
                        className="form-control"
                        type="number"
                        value={quantity}
                        onChange = {(e) => setQuantity(e.target.value)}
                        required
                        />
                    </div>
                    <button className="btn btn-lg btn-primary btn-block my-2" onClick={() => {handleAddProduct()}}>Dodaj produkt</button>
                </form>
               

            </Modal>
            <Modal 
            show={modalEditState}
            onHide={()=>setModalEditState(false)}
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
                    <button className = "btn btn-light btn-outline-primary" onClick={() => setModalEditState(false)}><CloseOutlinedIcon/></button>
                </div>
                <form>
                    <div className="input-group mb-4">
                        <input variant="standard"
                        className="form-control"
                        type="text"
                        value={productEdit}
                        onChange = {(e) => setProductEdit(e.target.value)}
                        placeholder = "Produkt"
                        required
                        />
                    </div>
                    <div className="input-group mb-4">
                        <input placeholder="Ilość" variant="standard"
                        className="form-control"
                        type="number"
                        value={quantityEdit}
                        onChange = {(e) => setQuantityEdit(e.target.value)}
                        required
                        />
                    </div>
                    <button className="btn btn-lg btn-primary btn-block my-2" onClick={() => {handleEditProduct()}}>Edytuj produkt</button>
                </form>
            

            </Modal>
        </div>
    )}
    else if(token !== null && currentUser !== '' && products.length === 0){
        return(
            <div className='App-body' 
            style={{
                backgroundImage: `url(${emptyFridge})`,
                backgroundRepeat: 'no-repeat',
                backgroundAttacjment: 'fixed',
                backgroundSize: 'cover'
             }}>
                <h1 style={{textShadow:'3px 3px #000000'}}>Lodówka użytkownika {currentUser} jest pusta!</h1>
                <div className='my-2'>
                    <button className="btn btn-lg btn-primary btn-block my-2" onClick={() => setModalState(true)}>Dodaj produkt</button>
                </div>
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
                    <form>
                        <div className="input-group mb-4">
                            <input variant="standard"
                            className="form-control"
                            type="text"
                            value={product}
                            onChange = {(e) => setProduct(e.target.value)}
                            placeholder = "Produkt"
                            required
                            />
                        </div>
                        <div className="input-group mb-4">
                            <input placeholder="Ilość" variant="standard"
                            className="form-control"
                            type="number"
                            value={quantity}
                            onChange = {(e) => setQuantity(e.target.value)}
                            required
                            />
                        </div>
                        <button className="btn btn-lg btn-primary btn-block my-2" onClick={() => {handleAddProduct()}}>Dodaj produkt</button>
                    </form>
                

                </Modal>


            </div>
        )
    }
    else{
        return(
            <div className='App-body'>
                <h1>Ładowanie</h1>

            </div>
        )
    }
   
   
};
