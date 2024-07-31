import React from 'react';
import Navbar from './Navbar';
import DigitusCNDNForm from "./DigitusCNDNForm";


export default class extends React.Component {
    render() {
        return (
            <div className={"digitus-container"}>
                <DigitusCNDNForm></DigitusCNDNForm>
            </div>

        )
    }
}