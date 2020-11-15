import React from 'react';
import './App.scss';
import AzonositoRecordingForm from "./component/AzonositoRecordingForm";
import AzonositoList from "./component/AzonositoList";
import SlideRecordingForm from "./component/SlideRecordingForm";
import SlideList from "./component/SlideList";

function App() {
  return (
    <div className={["App","container"]}>
        <div className={"row"}>
            <div className={"col-md-3"}></div>
            <div className={"col-md-6"}>
                <AzonositoRecordingForm/>
                <AzonositoList/>
                <br/>
                <SlideRecordingForm/>
                <SlideList/>
            </div>
            <div className={"col-md-3"}></div>
        </div>
    </div>
  );
}

export default App;
