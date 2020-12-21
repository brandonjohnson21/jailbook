import React, { useState } from 'react'
import LeaveComment from './LeaveComment'

function Comments(props){
    
    
    if (!props.comments) { return (<LeaveComment />)}
    else {
        let comments = props.comments.map(each => (
            <div key={each.commentPostId}>
                <div>
                        <div>{each.criminalId.alias}</div>
                        <div>{each.criminalId.numYearsServed}</div>
                        <div>{each.criminalId.prisonReleaseDate}</div>
                        <div>{each.criminalId.rating}</div>
                    </div>
                <div>
                    {each.commentText}
                </div>
            </div>
            ))
    
    return(
        <>
            <div>{comments} </div>
            <LeaveComment postId={props.postId} getPosts={props.getPosts}/>
        </>
    )
    }
}

export default Comments