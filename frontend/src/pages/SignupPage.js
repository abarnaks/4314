import React, { Component } from "react";
import axios from'axios';

export default class SignUpPage extends Component {

    handleSignup = e => {
        e.preventDefault();
        const data = {
            name: this.name,
            studentID: this.studentID,
            email: this.email,
            password: this.password
        }

        axios.post('/user/new', data )
            .then(res => {
                console.log(res.data)
                localStorage.setItem('userId', res.data);
                window.location.reload();  
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
            );
        } else {
            return (
                <form onSubmit={this.handleSignup}>
                    <h3>Sign Up</h3>
    
                    <div className="form-group">
                        <label>User Name</label>
                        <input type="text" className="form-control" placeholder="User Name" 
                            onChange={e => this.name = e.target.value }/>
                    </div>
    
                    <div className="form-group">
                        <label>Student Id</label>
                        <input type="text" className="form-control" placeholder="Student Id" 
                             onChange={e => this.studentID = e.target.value }/>
                    </div>
    
                    <div className="form-group">
                        <label>Email address</label>
                        <input type="email" className="form-control" placeholder="Enter email" 
                             onChange={e => this.email = e.target.value }/>
                    </div>
    
                    <div className="form-group">
                        <label>Password</label>
                        <input type="password" className="form-control" placeholder="Enter password" 
                            onChange={e => this.password = e.target.value }/>
                    </div>
    
                    <button type="submit" className="btn btn-primary btn-block">Sign Up</button>
                    <p className="forgot-password text-right">
                        Already registered <a href="/login">sign in?</a>
                    </p>
                </form>
            );
        }
        
    }
}
