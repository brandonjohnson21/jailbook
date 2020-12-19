import React, { useState } from 'react'
import LeaveComment from './LeaveComment'

function Comments(props){
    

    if (!props.comments) { return (<LeaveComment />)}
    else {
        let comments = props.comments.map(each => (<div key={each.commentPostId}>comment: {each.commentText}</div>))
    
    return(
        <>
            <div>{comments} </div>
            <LeaveComment postId={props.postId}/>
        </>
    )
    }
}

export default Comments