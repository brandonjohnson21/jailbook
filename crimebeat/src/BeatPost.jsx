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
    async getPosts(){
        
        let response = await fetch(`${api}/feed`)
            .then(response => response.json())
            .catch((error) => {throw(error)});
        
        this.setState({posts: response})
    }

    render(){
        
        let postEntries = this.state.posts.map(each => 
            (
                <div key={each.postId}>
                    <div >
                        <div>{each.criminalId.alias}</div>
                        <div>{each.criminalId.numYearsServed}</div>
                        <div>{each.criminalId.prisonReleaseDate}</div>
                        <div>{each.criminalId.rating}</div>
                    </div>
                    <div>
                        <div>{each.postText}</div>
                    </div>
                    <div>
                        Votes:<button>-</button> {each.upvoteCount}<button>+</button>
                    </div>
                    <div>
                        <Comments comments={each.commentPost} postId={each.postId} getPosts={this.getPosts}/>
                    </div>
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