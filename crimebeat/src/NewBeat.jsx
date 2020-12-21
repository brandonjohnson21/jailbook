import React from 'react'
import {api,selectedUser} from './config'

class NewBeat extends React.Component{
    constructor(props){
        super(props);
        
        this.state = {
            postText: "",
        }
    }

    handleChange = (e) => {
        this.setState({postText: e.target.value})
    }

    async handleSubmit(e){
        e.preventDefault();
        const req = {
            
            method: 'POST',
            headers: {'Content-Type':'application/json'},
            mode: 'cors',
            body: JSON.stringify({
                criminalId: `${selectedUser}`,
                postText: `${this.state.postText}`
            })
        }
        console.log(req);
         await fetch(`${api}/new`,req);
                        

    }

    render(){
        return(
            <div>
            <form>  <br/>
                    <label>Say something:</label> <textarea rows="1" cols="80" onChange={this.handleChange}></textarea>
                    <button onClick={this.handleSubmit.bind(this)}>Post</button>
                    <br />
                </form>
            </div>
        )
        }
}



export default NewBeat