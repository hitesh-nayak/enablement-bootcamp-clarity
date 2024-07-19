import React from 'react';
import {createRoot} from 'react-dom/client';
import { BrowserRouter as Router, Route, Switch } from 'react-router-dom';
import {Link} from "react-dom";
import api from './common/services/liferay/api';
import {Liferay} from './common/services/liferay/liferay';
import HelloBar from './routes/hello-bar/pages/HelloBar';
import HelloFoo from './routes/hello-foo/pages/HelloFoo';
import HelloWorld from './routes/hello-world/pages/HelloWorld';
import './common/styles/index.scss';
import App from "./App";
import Navbar from "./tutorial/11-react-router/final/Navbar";
import Home from "./tutorial/11-react-router/final/Home";
import About from "./tutorial/11-react-router/final/About";
import People from "./tutorial/11-react-router/final/People";
import Person from "./tutorial/11-react-router/final/Person";
import Error from "./tutorial/11-react-router/final/Error";

const RenderObj = ({route}) => {
    if (route === 'hello-bar') {
        return <HelloBar />;
    }

    if (route === 'hello-foo') {
        return <HelloFoo />;
    }

    if (Liferay.ThemeDisplay.isSignedIn()) {
        return (

            <App/>

        );
    }


};

class WebComponent extends HTMLElement {
    connectedCallback() {
        createRoot(this).render(
            <RenderObj
                route={this.getAttribute('route')}
            />,
            this
        );

        if (Liferay.ThemeDisplay.isSignedIn()) {
            api('o/headless-admin-user/v1.0/my-user-account')
                .then((response) => response.json())
                .then((response) => {
                    if (response.givenName) {
                        const nameElements = document.getElementsByClassName(
                            'hello-world-name'
                        );

                        if (nameElements.length) {
                            nameElements[0].innerHTML = response.givenName;
                        }
                    }
                });
        }
    }
}

const ELEMENT_ID = 'react-jan11';

if (!customElements.get(ELEMENT_ID)) {
    customElements.define(ELEMENT_ID, WebComponent);
}
