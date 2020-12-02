import logo from './logo.svg';
import './App.css';
import React, {Component} from 'react';
import { Route , BrowserRouter as Router, Switch, Link} from 'react-router-dom';
import LoginPage from './pages/LoginPage';
import SignupPage from './pages/SignupPage';
import WelcomePage from './pages/WelcomePage';
import BookingPage from './pages/BookingPage';
import LogPage from './pages/LogPage';
import Navbar from './layout/Navbar';
import '../node_modules/bootstrap/dist/css/bootstrap.min.css';
import axios from 'axios';

export default class App extends Component{
  state = { expand: false };

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

toggleExpan() {
  this.setState({
    expand: !this.state.expand
  })
}

  render() {
    
    return (
      <main className="page bg-white" id="petratings">
      <Router>
     
        <Navbar user={this.state.user}/>
  
        <div className="container">
            <div className="row">
              <div className="col-md-12 bg-white">
                <div className="container">
                  <Switch>
                    <Route path="/logs" component={LogPage} />
                    <Route path="/login" component={LoginPage} expand = {this.state.expand} toggleExpand = {this.toggleExpand} />
                    <Route path="/signup" component={SignupPage} />
                    <Route path="/booking" component={BookingPage} />
                    <Route path="/" component={ () => <WelcomePage user={this.state.user}/>} />
                  </Switch>
                </div>
              </div>
          </div>
        </div>
     
      </Router>
      </main>
    );
  }
  
}