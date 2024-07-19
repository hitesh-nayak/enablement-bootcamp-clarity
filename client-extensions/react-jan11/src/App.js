import React from 'react'
import Navbar from "./tutorial/11-react-router/final/Navbar";
import {BrowserRouter as Router, Route, Switch} from "react-router-dom";
import Home from "./tutorial/11-react-router/final/Home";
import About from "./tutorial/11-react-router/final/About";
import People from "./tutorial/11-react-router/final/People";
import Person from "./tutorial/11-react-router/final/Person";
import Error from "./tutorial/11-react-router/final/Error";
function App() {
  return (
    <div className='container'>
        <Router>
            <Navbar />
            <Switch>
                <Route exact path='/'>
                    <Home />
                </Route>
                <Route path='/about'>
                    <About />
                </Route>
                <Route path='/people'>
                    <People />
                </Route>
                <Route path='/person/:id' children={<Person />}></Route>
                <Route path='*'>
                    <Error />
                </Route>
            </Switch>
        </Router>
    </div>
  )
}

export default App
