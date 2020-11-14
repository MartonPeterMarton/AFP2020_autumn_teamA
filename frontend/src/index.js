import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';
import App from './App';
import * as serviceWorker from './serviceWorker';

ReactDOM.render(
  <React.StrictMode>
      <header>
          <h1>AFP2020<span>_autumn_teamA</span></h1>
      </header>
      <nav>
        <App />
      </nav>
        <footer>
            <h4>
                &copy; Copyright team A <br/>
                Team: Marton Péter Márton, Dévai Levente, Bárány Gergő, Mészáros Martin
            </h4>
        </footer>
  </React.StrictMode>,
  document.getElementById('root')
);

// If you want your app to work offline and load faster, you can change
// unregister() to register() below. Note this comes with some pitfalls.
// Learn more about service workers: https://bit.ly/CRA-PWA
serviceWorker.unregister();
