import React from 'react';
import {createRoot} from 'react-dom/client';
import {Link} from "react-dom";
import api from './common/services/liferay/api';
import {Liferay} from './common/services/liferay/liferay';
import HelloBar from './routes/hello-bar/pages/HelloBar';
import HelloFoo from './routes/hello-foo/pages/HelloFoo';
import HelloWorld from './routes/hello-world/pages/HelloWorld';

import './common/styles/index.scss';
import AppComponent from "./AppComponent";

const App = ({route}) => {
	if (route === 'hello-bar') {
		return <HelloBar />;
	}

	if (route === 'hello-foo') {
		return <HelloFoo />;
	}

	if (Liferay.ThemeDisplay.isSignedIn()) {
		return (
			<div>
				<AppComponent/>
			</div>
		);
	}


};

class WebComponent extends HTMLElement {
	constructor() {
		super();
	}

	connectedCallback() {
		createRoot(this).render(
			<App
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

const ELEMENT_ID = 'react-intern-crud';

if (!customElements.get(ELEMENT_ID)) {
	customElements.define(ELEMENT_ID, WebComponent);
}
