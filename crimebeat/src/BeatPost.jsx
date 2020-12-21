import React from 'react'
import {api} from './config';
import LeaveComment from './LeaveComment'

import { withStyles } from '@material-ui/core/styles';

import Grid from '@material-ui/core/Grid';
import Paper from '@material-ui/core/Paper';
import Typography from '@material-ui/core/Typography';


import Comments from './Comments'

const styles = theme => ({
    root: {
      flexGrow: 1,
    },
    paper: {
      padding: theme.spacing(4),
      textAlign: 'left',
      color: "#e57373",
      backgroundColor: "#373737",
      height: '100%',
  
    },
    votes: {
        color: "#e57373",
        backgroundColor: "#373737",
    },
    dateHeader: {
        textAlign: "left", 
        color: "#8e0000",
        backgroundColor: "#616161",
    }   
  });

class BeatPost extends React.Component{
    constructor(props){
        super(props);
    
        this.state = {
            posts: [],
            
        }
        
    }

      
    async componentDidMount(){
        
      this.getPosts();
        
    }
    async getPosts(){
        
        let response = await fetch(`${api}/feed`)
            .then(response => response.json())
            .catch((error) => {throw(error)});
        
        this.setState({posts: response})
    }

    async handleUpvote(postId){
        const updateCount = this.state.posts;
        await fetch(`${api}/upvote/${postId}`,{
            method:'POST'
        })
            .then(updateCount[postId-1].upvoteCount++)
            .then(this.setState({posts: updateCount}));
        
    }

    async handleDownvote(postId){
        const updateCount = this.state.posts;
        await fetch(`${api}/downvote/${postId}`,{
            method:'POST'
        })
        .then(updateCount[postId-1].upvoteCount--)
        .then(this.setState({posts: updateCount}));
    }

    render(){
        const { classes } = this.props;
        let postEntries = this.state.posts.map(each => 
            (
                <div className={classes.root} key={each.postId}>
                <Grid container spacing={1}>
                    
                    <Grid item xs={12} sm={3}>
                    <Paper className={classes.paper}>
                        <Typography align="left">{each.criminalId.alias}</Typography>
                        <Typography align="left"><b>Years Served: </b> {each.criminalId.numYearsServed}</Typography>
                        <Typography align="left"><b>Release Date: </b>{each.criminalId.prisonReleaseDate}</Typography>
                        <Typography align="left"><b>Rating: </b>{each.criminalId.rating}</Typography>
                        <Paper className={classes.dateHeader}>
                         <Typography align="left">
                            <b>Post Date: </b>  {each.postTimestamp}
                        </Typography>
                        </Paper>
                    </Paper>
                    </Grid>
                    <Grid item xs={12} sm={9}>
                        <Paper className={classes.paper}> {each.postText}<br/><br/>
                        <LeaveComment postId={each.postId} getPosts={this.getPosts} />
                        </Paper>
                        
                    </Grid>
                        <Grid item xs={12} sm={1}>
                            <Typography align="left" display="inline" className={classes.votes}>
                                <b>Votes: </b>
                            </Typography>
                            <button onClick={() => this.handleDownvote(each.postId)}>-</button>
                            <Typography align="left" display="inline" className={classes.votes}> 
                                {each.upvoteCount}
                            </Typography>
                            <button onClick={() => this.handleUpvote(each.postId)}>+</button>
                        </Grid>
                    
                    <Grid item xs={12} sm={11}>
                        <Comments comments={each.commentPost} postId={each.postId}/>
                        
                    </Grid>
                    
                    
                </Grid>
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

export default withStyles(styles)(BeatPost);
