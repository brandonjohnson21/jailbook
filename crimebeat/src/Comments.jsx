//import React, { useState } from 'react'


import { makeStyles } from "@material-ui/core/styles";
import Paper from "@material-ui/core/Paper";
import Grid from "@material-ui/core/Grid";
import Typography from '@material-ui/core/Typography';

const useStyles = makeStyles((theme) => ({
    root: {
      flexGrow: 1,
    },
    paper: {
      padding: theme.spacing(2),
      textAlign: "left",
      color: "#e57373",
      backgroundColor: "#373737",
      height: "100%",
      marginTop: "70px",
      
    },
    dateHeader: {
        textAlign: "left", 
        color: "#8e0000",
        backgroundColor: "#616161",
    }
    
  }));

function Comments(props){

    const classes = useStyles();
    
    if (!props.comments) { return (<></>)}
    else {
        let comments = props.comments.map(each => (
            <div className={classes.root} key={each.commentPostId}>
            
            <Grid container spacing={1}>
                    
                    <Grid item xs={12} sm={3}>
                    <Paper className={classes.paper}>
                        <Typography align="left">{each.criminalId.alias}</Typography>
                        <Typography align="left"><b>Years Served: </b> {each.criminalId.numYearsServed}</Typography>
                        <Typography align="left"><b>Release Date: </b>{each.criminalId.prisonReleaseDate}</Typography>
                        <Typography align="left"><b>Rating: </b>{each.criminalId.rating}</Typography>
                        <Paper className={classes.dateHeader}>
                         <Typography align="left">
                            <b>Post Date: </b>  {each.commentTimestamp}
                        </Typography>
                    </Paper>
                    </Paper>
                    </Grid>
                    <Grid item xs={12} sm={9} >
                       
                        <Paper className={classes.paper}> {each.commentText}</Paper>
                        
                    </Grid>
                </Grid>
            </div>
            ))
    
    return(
        <>
            {comments}
            
        </>
    )
    }
}

export default Comments