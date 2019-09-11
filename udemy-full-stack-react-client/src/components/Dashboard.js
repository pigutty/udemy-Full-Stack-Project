import React, { Component } from 'react'
import Projectitem from './Project/Projectitem';
import "bootstrap/dist/css/bootstrap.min.css";

class Dashboard extends Component {
  render() {
    return (
      <div>
        <h1 className="alert alert-warning">Welcome to the Dashboard</h1>
        <Projectitem/>
      </div>
    );
  }
}

export default Dashboard;
