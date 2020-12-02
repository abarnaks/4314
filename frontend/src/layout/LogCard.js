import React, { Component } from 'react'
import { Card, CardText, CardBlock, CardTitle, CardSubtitle, CardBody} from 'reactstrap';


export class LogCard extends Component {
    
    render() {
        return (
            <div>
                <Card>
                    <CardBody>
                    <CardTitle tag="h5">Action called: {this.props.logs.action}</CardTitle>
                    <CardSubtitle tag="h6" className="mb-2 text-muted">Action time: {this.props.logs.currentTime}</CardSubtitle>
                    <CardText>Time taken: {this.props.logs.timeTaken} ms</CardText>
                    <CardText>Success: {this.props.logs.success}</CardText>
                    </CardBody>
                </Card>
            </div>
        )
    }
}

export default LogCard