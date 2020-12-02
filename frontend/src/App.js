import logo from './logo.svg';
import './App.css';
import React, {Component} from 'react';
import { Route , BrowserRouter as Router, Switch, Link} from 'react-router-dom';
import LoginPage from './pages/LoginPage';
import SignupPage from './pages/SignupPage';
import WelcomePage from './pages/WelcomePage';
import Navbar from './layout/Navbar';
import '../node_modules/bootstrap/dist/css/bootstrap.min.css';
import axios from 'axios';

export default class App extends Component{
  state = {};

  componentDidMount = () => {
    const userId = localStorage.getItem('userId');
    axios.get(`/user/${userId}`)
        .then( res => {
            console.log(res.data)
            this.setState({
                user: res.data
            });
            }, err => {
                console.log(err)
            }
        )
};
  render() {
    return (
      <Router>
      <div className="App">
        <Navbar user={this.state.user}/>
  
        <div className="auth-wrapper">
          <div className="auth-inner">
            <Switch>
              <Route path="/login" component={LoginPage} />
              <Route path="/signup" component={SignupPage} />
              <Route path="/" component={ () => <WelcomePage user={this.state.user}/>} />
            </Switch>
          </div>
        </div>
      </div>
      </Router>
     
    );
  }
  
}


