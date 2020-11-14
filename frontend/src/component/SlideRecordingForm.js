import React from "react";
import * as actions from '../action/SlideActions';
import ErrorMessageWell from "./ErrorMessageWell";
class SlideRecordingForm extends React.Component{

    constructor(props) {
        super(props);
        this.state = {
            slide : 0
        };
        this.formOnChange = this.formOnChange.bind(this);
    }

    formOnChange(event){
        const {name,value} = event.target;
        this.setState({[name] : value});
    }

    render() {
        return(
            <div>
                <ErrorMessageWell/>
                <label htmlFor={"slide"} >Slide</label>
                <input type={"number"} id={"slide"} name={"slide"} value={this.state.slide} onChange={this.formOnChange}/>
                <br/>
                <button onClick={()=> actions.recordSlide(this.state)}>New Slide</button>
                <button onClick={()=> actions.fetchSlide(this.state)}>List Slide</button>
            </div>
        );
    }
}

export default SlideRecordingForm
