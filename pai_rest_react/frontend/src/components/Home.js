import React, {useState, useEffect} from 'react';
import lockedFridge from '../img/lockedFridge.jpg'


export const Home = () => {
  return (
    <div className='App-body' 
    style={{
        backgroundImage: `url(${lockedFridge})`,
        backgroundRepeat: 'no-repeat',
        backgroundAttacjment: 'fixed',
        backgroundSize: 'cover'
     }}>
          <p style={{textShadow:'3px 3px #000000'}}>
              Aplikacja stworzona w ramach laboratorium Programowanie Aplikacji Internetowych
          </p>
          <p style={{textShadow:'3px 3px #000000'}}>
              Zaloguj się, aby sprawdzić stan swojej lodówki
          </p> 

      </div>
  );
};
