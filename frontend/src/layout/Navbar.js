import React, { Component } from 'react'

import { Route , BrowserRouter as Router, Switch, Link} from 'react-router-dom';

export default class Navbar extends Component {

    state={
        showCollapsedMenu: false
    }

    toggleMenu = () => {
        this.setState({
          showCollapsedMenu: !this.state.showCollapsedMenu
        })
    }

   

    render() {
 
        const show = (this.state.showCollapsedMenu) ? "show" : "" ;

        if(this.props.user) {
            return (
            
                <nav className="navbar navbar-expand-lg navbar-light bg-light">
                    <a className="navbar-brand" href="#">Campus Checkin</a>

                    <button 
                        className="navbar-toggler" 
                        type="button" 
                        onClick={this.toggleMenu}
                        data-toggle="collapse" 
                        data-target="#navbarNav" 
                       >
                        <span className="navbar-toggler-icon"></span>
                    </button>

                    <div className={"collapse navbar-collapse " + show} id="navbarNav">
                        <ul className="navbar-nav mr-auto mt-2 mt-lg-0">
                            <li className="nav-item active"><a className="nav-link" href="/welcome">Home
                             <span className="sr-only">(current)</span>
                            </a></li>
                            <li className="nav-item"><a className="nav-link" href="/booking">Book now</a></li>
                            <li className="nav-item"><a className="nav-link" href="/">View booking</a></li>
                            <li className="nav-item">
                                <a className="nav-link" href="/login">Logout</a>
                            </li>
                        </ul>
                        <span className="navbar-text">Welcome to Campus Checkin, {this.props.user.name}!</span>

                    </div>
                </nav>
            )


        } else {
            return (
                <nav className="navbar navbar-expand-lg navbar-light bg-light">
                    <a className="navbar-brand" href="#">Campus Checkin</a>

                    <button className="navbar-toggler" type="button"  onClick={this.toggleMenu} data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                        <span className="navbar-toggler-icon"></span>
                    </button>

                    <div className={"collapse navbar-collapse " + show} id="navbarNav">
                        <ul className="navbar-nav mr-auto mt-2 mt-lg-0">
                            <li className="nav-item">
                                <Link className="nav-link" to={"/login"}>Login</Link>
                            </li>
                            <li className="nav-item">
                                <Link className="nav-link" to={"/signup"}>Sign up</Link>
                            </li>
                           
                        </ul>
                        

                    </div>
                </nav>

               
            )
        }
        return (
            <nav className="navbar navbar-expand-lg navbar-light bg-light">
                    <a className="navbar-brand" href="#">Campus Checkin</a>

                   

                    <div className="collapse navbar-collapse" id="navbarTogglerDemo02">
                        <ul className="navbar-nav mr-auto mt-2 mt-lg-0">
                            <li className="nav-item">
                                <Link className="nav-link" to={"/login"}>Login</Link>
                            </li>
                            <li className="nav-item">
                                <Link className="nav-link" to={"/signup"}>Sign up</Link>
                            </li>
                        
                        </ul>
                        

                    </div>

                    <button className="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                        <span className="navbar-toggler-icon"></span>
                    </button>
                </nav>


        )
    }
}