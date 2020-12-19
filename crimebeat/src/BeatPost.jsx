import React from 'react'
import {api} from './config';

import Comments from './Comments'

class BeatPost extends React.Component{
    constructor(props){
        super(props);
    
        this.state = {
            posts: [],
        }
    }
    async componentDidMount(){
        
        let response = await fetch(`${api}/feed`)
            .then(response => response.json())
            .catch((error) => {throw(error)});
        
        this.setState({posts: response})
        
    }

    render(){
        let postEntries = this.state.posts.map(each =>
            (
             <div key={each.postId}>
            <div>{each.criminalId}</div>
            <div>{each.postText}</div>
            <div>Votes: {each.upvoteCount}</div><button>+</button>
            <div><Comments comments={each.commentPost} postId={each.postId}/></div>
              </div>
            ));
            if (postEntries === 0) {postEntries = "No Posts in the feed!"}
            return ( 
                <>
                
                {postEntries}
                </>
                );
    }
}

export default BeatPost;