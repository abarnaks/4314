import React, { Component } from "react";

export default class LoginPage extends Component {
    render() {
        return (
            <form>
                <h3>Sign In</h3>

                <div className="form-group">
                    <label>Email address</label>
                    <input type="email" className="form-control" placeholder="Enter email" />
                </div>

                <div className="form-group">
                    <label>Password</label>
                    <input type="password" className="form-control" placeholder="Enter password" />
                </div>
                <p className="forgot-password text-right">
                    Need an account, sign up<a href="/signup"> here!</a>
                </p>
            </form>
        );
    }
}
