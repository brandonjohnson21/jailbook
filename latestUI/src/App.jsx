import './App.css';
import React from 'react'
import CreateHeist from './CreateHeist'
import HeistLookUp from './HeistLookUp'

class App extends React.Component {
    constructor(props) {
        super(props)
        this.state = {
            post: {},
            postPresend: {},
            searchResults: {},
            createHeist: true,
            createHeistStatus: 0,
            heistUpdateStatus: 0,
            registerUserName: '',
            registerUserID: 0,
            showSearch: false,
            searchResultsStatus: 0,
            results: [],
            createdHeistID: ""
        }
    }

    addHeist = (rbody) => {
        this.handleRegisterToggle()
        this.setState({ postPresend: rbody })
        const requestOptions = {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify(rbody)
        };
        fetch('http://localhost:8080/latestHits/heist', requestOptions)
            .then(response => {
                this.setState({ createHeistStatus: response.status })
                this.setState({ post: response })
            })
    }


    updateHeist = (rbody) => {
        this.handleUpdateToggle()
        const requestOptions = {
            method: 'PUT',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify(rbody)
        };
        fetch('http://localhost:8080/latestHits/heist', requestOptions)
            .then(response => {
                this.setState({ heistUpdateStatus: response.status })
                this.setState({ post: response })

            })
    }

    handleRegisterToggle = () => {
        let link = document.getElementById("Register")
        this.setState({ createHeistStatus: 0 })
        this.setState({ heistUpdateStatus: 0 })

        this.setState({ showSearch: false })
        if (this.state.createHeist) {
            this.setState({ createHeist: !this.state.createHeist })
            link.classList.remove("active")
        } else {
            this.setState({ createHeist: !this.state.createHeist })
            link.classList.add("active")
        }
    }


    handleUpdateToggle = () => {
        let link = document.getElementById("Register")
        this.setState({ createHeistStatus: 0 })
        this.setState({ showSearch: false })
    }


    async handleUserSearch(e) {
        e.preventDefault()
        this.setState({ registerUpdateStatus: 0 })
        let link = document.getElementById("Register")
        link.classList.remove("active")
        let searchString = `http://localhost:8080/latestHits/heist/${document.getElementById("search").value}`
        const response = await fetch(searchString)
            .then(response => {
                this.setState({ searchResultsStatus: response.status })
                this.setState({ createHeist: false })
                return response
            }).catch(response => {
                this.setState({ searchResultsStatus: response.status })
                this.setState({ createHeist: false })
                return response
            })
        const json = await response.json()
        this.setState({ createHeist: false })
        this.setState({ results: json })
        this.setState({ showSearch: true })
    }


    render() {
        return (
            <div className="App">

                <nav class="navbar navbar-expand-md navbar-dark bg-dark fixed-top" id="mainNav">
                    <a class="navbar-brand" href="#">Latest Hits</a>
                    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExampleDefault"
                        aria-controls="navbarsExampleDefault" aria-expanded="false" aria-label="Toggle navigation">
                        <span class="navbar-toggler-icon"></span>
                    </button>

                    <div class="collapse navbar-collapse" id="navbarsExampleDefault">
                        <ul class="navbar-nav mr-auto">
                            {/* <li class="nav-item active">
                                <a class="nav-link" href="#">Home <span class="sr-only">(current)</span></a>
                            </li> */}
                            <li class="nav-item">
                                <a class="nav-link active" id="Register" onClick={this.handleRegisterToggle} href="#">Create</a>
                            </li>
                        </ul>
                        <form class="form-inline my-2 my-lg-0">
                            <input class="form-control mr-sm-2" type="text" id="search" placeholder="Search Heists (by ID)" aria-label="Search"></input>
                            <button class="btn btn-secondary my-2 my-sm-0" onClick={this.handleUserSearch.bind(this)} type="submit">Search!</button>
                        </form>
                    </div>
                </nav>

                <main role="main" class="container">
                    <div class="main-App">
                        {/* <h2>Heading </h2> */}

                        {this.state.createHeistStatus === 500 ?
                            <div class="alert alert-danger" role="alert">
                                A server error occurred while adding the heist... A hit was automatically generated against the developer.
                          </div> :
                            <div></div>}

                        {this.state.createHeistStatus === 200 ?
                            <div class="alert alert-success" role="alert">
                                The heist was added successfully!
                          </div> :
                            <div></div>}

                        {this.state.heistUpdateStatus === 200 ?
                            <div class="alert alert-success" role="alert">
                                The heist was updated successfully! 
                          </div> :
                            <div></div>}

                        {this.state.heistUpdateStatus === 500 ?
                            <div class="alert alert-danger" role="alert">
                                A server error occurred while updating the heist... A hit was automatically generated against the developer.
                          </div> :
                            <div></div>}

                        {this.state.heistUpdateStatus === 404 ?
                            <div class="alert alert-danger" role="alert">
                                A server error occurred while updating the heist... A hit was automatically generated against the developer.
                          </div> :
                            <div></div>}
                        {this.state.searchResultsStatus === 400 ?
                            <div class="alert alert-warning" role="alert">
                                The heist was not found...
                                                     </div> :
                            <div></div>}



                        {this.state.createHeist ?
                            <CreateHeist
                            heistId={this.state.heistId}
                            addHeist={this.addHeist}
                            addRole={this.addRole}
                            /> :
                            <div></div>}

                        {this.state.showSearch ?
                            <HeistLookUp
                                results={this.state.results}
                                updateHeist={this.updateHeist} /> :
                            <div></div>}

                        {/* Modify User*/}
                        {/* Add supervisor*/}



                    </div>
                </main>
            </div>
        );
    }
}
export default App;


