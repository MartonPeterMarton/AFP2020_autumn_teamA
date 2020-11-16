import React from "react";
import * as actions from '../action/AzonositoActions';
import ErrorMessageWell from "./ErrorMessageWell";
class AzonositoRecordingForm extends React.Component{

    constructor(props) {
        super(props);
        this.state = {
            azonosito : 0
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
                <label htmlFor={"azonosito"} >Identifier</label>
                <input type={"number"} id={"azonosito"} name={"azonosito"} value={this.state.azonosito} onChange={this.formOnChange}/>
                <br/>
                <button onClick={()=> actions.recordAzonosito(this.state)}>Get Identifier</button>
            </div>
        );
    }
}

export default AzonositoRecordingForm
