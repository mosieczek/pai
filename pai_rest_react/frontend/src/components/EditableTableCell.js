import { useState, useRef, useEffect } from 'react';
import TableCell from '@mui/material/TableCell';
import { styled } from '@mui/material/styles';


// const StyledTableCell = styled(TableCell)`
//   :hover {
//     background-color: #fffde7;
//   }

// `;

const StyledTableCell = styled(TableCell, {
  shouldForwardProp: (prop) => prop !== 'isProcessing'
})(({ isProcessing }) => {
  if (isProcessing) {
    return {
      backgroundColor: 'gray',
      input : {
        color: 'white',
        border: '2px transparent',
        backgroundColor : '#282c34'
      }
    }
  }
})



/**
 * Very simple inline edit, great for numbers!
 */
const EditableTableCell = ({ children, setValue, ...props }) => {
  const [isActive, setIsActive] = useState(false);
  const [isProcessing, setIsProcessing] = useState(false);
  const [editingValue, setEditingValue] = useState(children);
  const [inputRef, setInputFocus] = useFocus();


  const enableEditing = e => {
    if (!isActive) {
      setIsActive(true);
    }
  }

  useEffect(() => {
    if (isActive) {
      setInputFocus();
    }
  }, [isActive]);


  const onChange = (event) => setEditingValue(event.target.value);

  const onKeyDown = (event) => {
    if (event.key === "Enter" || event.key === "Escape") {
      event.target.blur();
    }
  }

  const onBlur = (event) => {
    if (event.target.value.trim() === "") {
      setEditingValue(children);
    } else if (event.target.value !== children) {
      if (setValue) {
        setIsProcessing(true);
        // setValue must be ASYNC !!!
        setValue(event.target.value)
          .then(() => {
            setIsProcessing(false);
            setIsActive(false);
          })
          .catch(() => {
            setIsProcessing(false);
          })
      }
    }

  }

  return (
    <StyledTableCell {...props} isProcessing={isProcessing} onClick={enableEditing}>
      {isActive ? (
        <input
          ref={inputRef}
          type="text"
          aria-label="Field name"
          value={editingValue}
          onChange={onChange}
          onKeyDown={onKeyDown}
          onBlur={onBlur}
          style={{width: '10em', textAlign: 'right', color:'white', background:'#282c34'}}
        />
        
      ) : (
        children
      )}
    </StyledTableCell>
  );
};

const useFocus = () => {
  const htmlElRef = useRef(null)
  const setFocus = () => { htmlElRef.current && htmlElRef.current.focus() }

  return [htmlElRef, setFocus]
}


export default EditableTableCell;