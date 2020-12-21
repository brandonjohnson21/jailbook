import React from 'react'
const { render } = require("react-dom");
class CreateHeist extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            heistId: 0,
            heistDescription: "", //handler added
            location: "", //added
            mastermind: 0, // added
            score: "", //added 
            startTimestamp: "",//added
            startdate: "",//added
            starttime: "",//added
            target: "", //added
            title: "", //added
            closeTimestamp: null
        }
    }


    handleChangeDescription = (e) => { //in use
        this.setState({ heistDescription: e.target.value });
    }

    handleChangeLocation = (e) => { //in use
        this.setState({ location: e.target.value });
    }

    handleChangeMastermind = (e) => { //in use
        this.setState({ mastermind: e.target.value });
    }
    handleChangeScore = (e) => {//in use
        this.setState({ score: e.target.value });
    }
    handleChangeStartDate = (e) => { //in use
        let temp = ""
        this.setState({ startdate: e.target.value });
        this.setState({ startTimestamp: temp.concat(this.state.startdate,"T",this.state.starttime)});;
    }
    handleChangeStartTime = (e) => {//in use
        let temp = ""
        this.setState({ starttime: e.target.value });
        this.setState({ startTimestamp: temp.concat(this.state.startdate,"T",this.state.starttime,"0")});;
    }
    handleChangeScore = (e) => {//in use
        this.setState({ score: e.target.value });
    }
    handleChangeTarget = (e) => {//in use
        this.setState({ target: e.target.value });
    }

    handleChangeTitle = (e) => { //in use
        this.setState({ title: e.target.value });
    }


    handleSubmit = (e) => {
        e.preventDefault();
        let body = {
            heistId: parseInt(this.state.heistId),
            heistDescription: this.state.heistDescription,
            location: this.state.location,
            mastermind: parseInt(this.state.mastermind),
            score: this.state.score,
            startTimestamp: this.state.startTimestamp,
            closeTimestamp: this.state.closeTimestamp,
            target: this.state.target,
            title: this.state.title
        }
        this.props.addHeist(body);
    }

    render() {
        return (
            <div>
                <h2> Create A Heist</h2>
                <form onSubmit={this.handleSubmit}>
                <div class="form-group">
                        <label for="Title">Title</label>
                        <input type="text" class="form-control" id="title" aria-describedby="Title" placeholder="Title" onChange={this.handleChangeTitle}></input>

                        <label for="mastermind">MasterMind</label>
                        <input type="text" class="form-control" id="mastermind" aria-describedby="mastermind" placeholder="Master Mind ID" onChange={this.handleChangeMastermind}></input>

                    </div>


                    <div class="form-group">

                        <label for="Target">Target</label>
                        <input type="text" class="form-control" id="target" aria-describedby="Target" placeholder="Target" onChange={this.handleChangeTarget}></input>

                        <label for="location">Location</label>
                        <input type="text" class="form-control" id="location" aria-describedby="Location" placeholder="Location" onChange={this.handleChangeLocation}></input>

                        <label for="Score">Score</label>
                        <input type="text" class="form-control" id="score" aria-describedby="Score" placeholder="Score" onChange={this.handleChangeScore}></input>


                    </div>

                    <div class="form-group">
                        <label for="Description">Description</label>
                        <textarea rows="3" class="form-control" id="description" aria-describedby="Description" placeholder="Description" onChange={this.handleChangeDescription}></textarea>
                    </div>


                    <div class="form-group">
                        <label for="startDate">Start Date</label>
                        <input type="text" class="form-control" id="startDate" aria-describedby="startDate" placeholder="YYYY-MM-DD" onChange={this.handleChangeStartDate}></input>

                        <label for="startTime">Start Time</label>
                        <input type="text" class="form-control" id="startTime" aria-describedby="startTime" placeholder="HH:MM:SS" onChange={this.handleChangeStartTime}></input>

                    </div>
                    <button type="submit" class="btn btn-primary">Submit</button>
                </form>

            </div>
        )
    }
}

export default CreateHeist