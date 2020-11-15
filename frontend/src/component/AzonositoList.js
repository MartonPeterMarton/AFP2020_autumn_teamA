import React from 'react';
import {default as store} from '../store/AzonositoStore'
import AzonositoListItem from "./AzonositoListItem";

class AzonositoList extends React.Component{

    constructor(props) {
        super(props);
        this.state = {azonosito : []};
        this._updateState = this._updateState.bind(this);
    }


    componentDidMount() {
        store.addChangeListener(this._updateState);
    }


    componentWillUnmount() {
        store.removeChangeListener(this._updateState);
    }

    _updateState(){
        this.setState({azonosito : store._azonosito});
    }

    render() {
        return(
            <div>
                {this.state.azonosito.map(({azonosito}, index)=>{
                    return(
                        <AzonositoListItem key={index} azonosito={azonosito}/>
                    );
                })}
            </div>
        );
    }
}

export default AzonositoList;
