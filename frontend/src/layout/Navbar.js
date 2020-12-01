import React, { Component } from 'react'
import { Route , BrowserRouter as Router, Switch, Link} from 'react-router-dom';

export default class Navbar extends Component {




    render() {

        if(this.props.user) {
            return (
                <nav className="navbar navbar-expand-lg navbar-light fixed-top">
                    <div className="container">
                        <Link className="navbar-brand" to={"/"}>Campus Check In</Link>
                            <div className="collapse navbar-collapse" id="navbarTogglerDemo02">
                                <ul className="navbar-nav ml-auto">
                                    <li className="nav-item">
                                        <Link className="nav-link" to={"/"}>Hello {this.props.user.name}</Link>
                                    </li>
                                </ul>
                            </div>
                    </div>
                </nav>
            )


        } else {
            return (
                <nav className="navbar navbar-expand-lg navbar-light fixed-top">
                    <div className="container">
                        <Link className="navbar-brand" to={"/"}>Campus Check In</Link>
                            <div className="collapse navbar-collapse" id="navbarTogglerDemo02">
                                <ul className="navbar-nav ml-auto">
                                    <li className="nav-item">
                                        <Link className="nav-link" to={"/login"}>Login</Link>
                                    </li>
                                    <li className="nav-item">
                                        <Link className="nav-link" to={"/signup"}>Sign up</Link>
                                    </li>
                                </ul>
                            </div>
                    </div>
                </nav>
            )
        }
        return (
            <nav className="navbar navbar-expand-lg navbar-light fixed-top">
                <div className="container">
                    <Link className="navbar-brand" to={"/"}>Campus Check In</Link>
                        <div className="collapse navbar-collapse" id="navbarTogglerDemo02">
                            <ul className="navbar-nav ml-auto">
                                <li className="nav-item">
                                    <Link className="nav-link" to={"/login"}>Login</Link>
                                </li>
                                <li className="nav-item">
                                    <Link className="nav-link" to={"/signup"}>Sign up</Link>
                                </li>
                            </ul>
                        </div>
                </div>
            </nav>
        )
    }
}


