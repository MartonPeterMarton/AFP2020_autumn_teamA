import React from 'react';
import {default as store} from '../store/SlideStore'
import SlideListItem from "./SlideListItem";

class SlideList extends React.Component{

    constructor(props) {
        super(props);
        this.state = {slide : []};
        this._updateState = this._updateState.bind(this);
    }


    componentDidMount() {
        store.addChangeListener(this._updateState);
    }


    componentWillUnmount() {
        store.removeChangeListener(this._updateState);
    }

    _updateState(){
        this.setState({slide : store._slide});
    }

    render() {
        return(
            <div>
                {this.state.slide.map(({slide}, index)=>{
                    return(
                        <SlideListItem key={index} slide={slide}/>
                    );
                })}
            </div>
        );
    }
}

export default SlideList;
