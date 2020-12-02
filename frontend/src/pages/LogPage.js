import React, { Component } from 'react'
//import { Container, Row, Col } from 'reactstrap';
import {LogCard} from '../layout/LogCard';

//import Paper from '@material-ui/core/Paper';
//import Grid from '@material-ui/core/Grid';
//import List from '@material-ui/core/List';
import axios from 'axios';


export class LogPage extends Component {
    state = {};
    componentWillMount = () => {
        axios.get(`/log/all`)
        .then( res => {
            console.log(res.data)
            this.setState({
                logs: res.data
            });
            console.log(this.state.logs);
            }, err => {
                console.log(err)
            }
        )
    }

    
    render() {
        
        if(this.state.logs) {
            let logCards = this.state.logs.map(logs => {
                return (
                    <LogCard logs={logs}/>
                )
            })
            return(
                <div>
                    {logCards}
                </div>
            )
        } else {
            return(
                <div>
                    <h2>Loading...</h2>
                </div>
            )
        }
        
    }
}

export default LogPage