import React from 'react';
import { dataTest } from '../services/dataService';

export const Home = () => {
    return (
        <div className='App-body'>

            <button className="btn btn-lg btn-primary btn-block" onClick={dataTest}>testdanych</button>

        </div>
    );
};
