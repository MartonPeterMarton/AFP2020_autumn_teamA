import React from 'react';
import './App.scss';
import AzonositoRecordingForm from "./component/AzonositoRecordingForm";
import AzonositoList from "./component/AzonositoList";
import SlideRecordingForm from "./component/SlideRecordingForm";
import SlideList from "./component/SlideList";

function App() {
  return (
    <div className={["App","container"]}>
        <header>
            <h1>AFP2020<span>_autumn_teamA</span></h1>
        </header>
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
        <footer>
            <h4>
                &copy; Copyright team A <br/>
                Team: Marton Péter Márton, Dévai Levente, Bárány Gergő, Mészáros Martin
            </h4>
        </footer>
    </div>
  );
}

export default App;
