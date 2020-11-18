import React from 'react';
import './App.scss';
import AzonositoRecordingForm from "./component/AzonositoRecordingForm";
import AzonositoList from "./component/AzonositoList";
import SlideRecordingForm from "./component/SlideRecordingForm";
import SlideList from "./component/SlideList";
import Header from "./component/header/header"
import "./component/main/main.css"
import Footer from "./component/footer/footer"

function App() {
  return (
    <div className={["App","container"]}>
        <Header/>
        <main>
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
        </main>
        <Footer/>
    </div>
  );
}

export default App;
