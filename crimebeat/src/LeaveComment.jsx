import React from 'react'
import {api,selectedUser} from './config'

class LeaveComment extends React.Component{
    constructor(props){
        super(props);
        
        this.state = {
            commentText: ""
        }
    }

    handleChange = (e) => {
        this.setState({commentText: e.target.value})
    }

    async handleSubmit(e){
        e.preventDefault();
        const req = {
            
            method: 'POST',
            headers: {'Content-Type':'application/json'},
            mode: 'cors',
            body: JSON.stringify({
                criminalId: `${selectedUser}`,
                commentText: `${this.state.commentText}`
            })
        }
        console.log(req);
        console.log("POSTID: "+this.props.postId)
        await fetch(`${api}/comment/${this.props.postId}`,req);

    }
    render(){
        return(
            <div>
            <form>
                <label>Comment:</label> <textarea rows="1" cols="80" onChange={this.handleChange}></textarea>
                <button onClick={this.handleSubmit.bind(this)}>Comment</button>
            </form>
        </div>
        )
        }
}



export default LeaveComment