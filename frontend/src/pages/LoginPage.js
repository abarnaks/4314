import React, { Component } from "react";
import axios from 'axios';

export default class LoginPage extends Component {

    state = {};
    handleSubmit = e => {
        e.preventDefault();

        const data = {
            name: this.userName,
            password: this.password
        }
        const config = {
            headers: {
              header1: "Access-Control-Allow-Origin"
            }
        }

        axios.post('/user/login', data,config )
            .then(res => {
                console.log(res.data);
                if(!res.data.localeCompare("false")){
                    //do nothing
                } else {
                    localStorage.setItem('userId', res.data);
                    window.location.reload();
                }
            })
            .catch(err => {
                console.log(err)
            })


    }

    render() {
        if(localStorage.getItem('userId')) {
            return(
                <form>
               

                    <div className="form-group">
                    <h3>Success! Return home<a href="/"> here!</a> </h3>
                    
                    </div>
                </form>
            )
        } else {
            return (
                <form onSubmit={this.handleSubmit}>
                    <h3>Sign In</h3>
    
                    <div className="form-group">
                        <label>Email address</label>
                        <input type="text" className="form-control" placeholder="Enter User Name"
                            onChange={e => this.userName = e.target.value }/>
                    </div>
    
                    <div className="form-group">
                        <label>Password</label>
                        <input type="password" className="form-control" placeholder="Enter password" 
                            onChange={e => this.password = e.target.value}/>
                    </div>
                    <button type="submit" className="btn btn-primary btn-block">Sign In</button>
                    <p className="forgot-password text-right">
                        Need an account, sign up<a href="/signup"> here!</a>
                    </p>
                </form>
            );
        }
       
    }
}
