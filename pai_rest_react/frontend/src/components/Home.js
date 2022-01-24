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
          <p>
              Aplikacja stworzona w ramach laboratorium Programowanie Aplikacji Internetowych
          </p>
          <p>
              Zaloguj się aby uzyskać dostęp do zawartości
          </p> 

      </div>
  );
};
