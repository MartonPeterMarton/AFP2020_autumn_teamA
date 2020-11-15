import axios from 'axios';
import dispatcher from '../dispatcher/Dispatcher';
import * as actionConstants from '../dispatcher/AzonositoActionConstants'

export const recordAzonosito = ({azonosito}) =>{
    axios.post('/azonosito/record',
        {
            azonosito : azonosito
        })
        .then(() => {
            fetchAzonosito();
            dispatcher.dispatch({action : actionConstants.clearError});
        })
        .catch((err) => {
            dispatcher.dispatch({
                action : actionConstants.showError,
                payload: `${err.response.status}-${err.response.statusText}: ${err.response.data.message}`
            });
            fetchAzonosito();
        });
}

export const fetchAzonosito = () =>{

    axios.get('/azonosito/').then((resp)=>{
        dispatcher.dispatch({
            action : actionConstants.refresh,
            payload: resp.data
        });
    })
}
