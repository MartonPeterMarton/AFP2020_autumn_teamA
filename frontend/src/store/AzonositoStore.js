import {EventEmitter} from 'events'
import dispatcher from "../dispatcher/Dispatcher";
import {refresh} from '../dispatcher/AzonositoActionConstants';

class AzonositoStore extends EventEmitter{

    _azonosito = [];

    emitChange(){
        this.emit('Change');
    }

    addChangeListener(callback){
        this.addListener('Change',callback);
    }

    removeChangeListener(callback){
        this.removeListener('Change',callback);
    }
}

const store = new AzonositoStore();
export default store;

dispatcher.register(({action,payload})=>{
    if(action !== refresh ) return;
    store._azonosito = payload;
    store.emitChange();
})
