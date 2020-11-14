import axios from 'axios';
import dispatcher from '../dispatcher/Dispatcher';
import * as actionConstants from '../dispatcher/SlideActionConstants'

export const recordSlide = ({slide}) =>{
    axios.post('/slide/record',
        {
            slide : slide
        })
        .then(() => {
            fetchSlide();
            dispatcher.dispatch({action : actionConstants.clearError});
        })
        .catch((err) => {
            dispatcher.dispatch({
                action : actionConstants.showError,
                payload: `${err.response.status}-${err.response.statusText}: ${err.response.data.message}`
            });
            fetchSlide();
        });
}

export const fetchSlide = () =>{

    axios.get('/slide/').then((resp)=>{
        dispatcher.dispatch({
            action : actionConstants.refresh,
            payload: resp.data
        });
    })
}
