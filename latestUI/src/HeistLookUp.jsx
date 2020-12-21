import React from 'react'
const { render } = require("react-dom");
class HeistLookup extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            modify: true,
            showUpdate: false,
            heistId: this.props.results.heistId,
            heistDescription: this.props.results.heistDescription,
            location: this.props.results.location,
            mastermind: this.props.results.mastermind,
            score: this.props.results.score,
            startTimestamp: this.props.results.startTimestamp,
            target: this.props.results.target,
            title: this.props.results.title,
            closeTimestamp: this.props.results.closeTimestamp,
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
    handleChangeStartTimeStamp = (e) => { //in use
        this.setState({ startTimestamp: e.target.value });
    }
    handleChangeEndTimeStamp = (e) => {//in use
        this.setState({ closeTimestamp: e.target.value });
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


    handleClose = (e) => {
        e.preventDefault();
        let body = {
            heistId: this.state.heistId,
            heistDescription: this.state.heistDescription,
            location: this.state.location,
            mastermind: this.state.mastermind,
            score: this.state.score,
            startTimestamp: this.state.startTimestamp,
            closeTimestamp: new Date().toISOString(),
            target: this.state.target,
            title: this.state.title
        }
        this.props.updateHeist(body);
    }
    handleUpdateMode = (e) => {
        this.setState({ modify: !this.state.modify})
        this.setState({ showUpdate: !this.state.showUpdate})
    }

    handleSubmit = (e) => {
        e.preventDefault();
        let body = {
            heistId: this.state.heistId,
            heistDescription: this.state.heistDescription,
            location: this.state.location,
            mastermind: this.state.mastermind,
            score: this.state.score,
            startTimestamp: this.state.startTimestamp,
            closeTimestamp: this.state.closeTimestamp,
            target: this.state.target,
            title: this.state.title
        }
        this.props.updateHeist(body);
    }

    render() {
        return (
            <div>
                <h2> View Heist</h2>
                <form>
                    <div class="form-group">

                        <label for="Title">Title</label>
                        <input type="text" class="form-control" id="title" aria-describedby="Title" placeholder={this.state.title} onChange={this.handleChangeTitle} disabled={this.state.modify}></input>

                        <label for="mastermind">MasterMind</label>
                        <input type="text" class="form-control" id="mastermind" aria-describedby="mastermind" placeholder={this.state.mastermind} onChange={this.handleChangeMastermind} disabled={this.state.modify}></input>

                    </div>
                    <div class="form-group">

                        <label for="Target">Target</label>
                        <input type="text" class="form-control" id="target" aria-describedby="Target" placeholder={this.state.target} onChange={this.handleChangeTarget}disabled={this.state.modify}></input>

                        <label for="location">Location</label>
                        <input type="text" class="form-control" id="location" aria-describedby="Location" placeholder={this.state.location} onChange={this.handleChangeLocation}disabled={this.state.modify}></input>

                        <label for="Score">Score</label>
                        <input type="text" class="form-control" id="score" aria-describedby="Score" placeholder={this.state.score}onChange={this.handleChangeScore}disabled={this.state.modify}></input>


                    </div>

                    <div class="form-group">
                        <label for="Description">Description</label>
                        <textarea rows="3" class="form-control" id="description" aria-describedby="Description"  placeholder={this.state.heistDescription} onChange={this.handleChangeDescription}disabled={this.state.modify}></textarea>
                    </div>


                    <div class="form-group">
                        <label for="starttimestamp">Start Timestamp</label>
                        <input type="text" class="form-control" id="starttimestamp" aria-describedby="starttimestamp" placeholder={this.state.startTimestamp} onChange={this.handleChangeStartTimeStamp}disabled={this.state.modify}></input>

                        <label for="endtimestamp">End Timestamp</label>
                        <input type="text" class="form-control" id="endtimestamp" aria-describedby="endtimestamp" placeholder={this.state.closeTimestamp} onChange={this.handleChangeEndTimeStamp}disabled={this.state.modify}></input>

                    </div>
                    <button type="button" onClick={this.handleUpdateMode} class="btn btn-warning" hidden={this.state.showUpdate}>Modify</button>
                    <button type="button" onClick={this.handleSubmit} class="btn btn-primary" hidden={!this.state.showUpdate}>Update</button>
                    <button type="button"  class="btn btn-danger padme">Delete</button>
                    <button type="button"  onClick={this.handleClose} class="btn btn-success padme">Close</button>
                </form>
            </div>
        );
    };
}

export default HeistLookup