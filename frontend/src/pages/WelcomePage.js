import React, { Component } from 'react'
import axios from 'axios';

export default class WelcomePage extends Component {

// state = {};

// componentDidMount(){
//     const userId = localStorage.getItem('userId');
//     axios.get(`/user/${userId}`)
//         .then( res => {
//             console.log(res.data)
//             this.setState({
//                 user: res.data
//             });
//             }, err => {
//                 console.log(err)
//             }
//         )
// }

    render() {
        if(this.props.user){
            return(
                <h2> Hi {this.props.user.name} </h2>
            )
        } else {
            return (
                <div>
                    <h2>Please log in</h2>
                </div>
            )
        }
       
    }
}


