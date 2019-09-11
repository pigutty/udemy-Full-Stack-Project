import React, { Component } from 'react'
import Projectitem from './Project/Projectitem';

class Dashboard extends Component {
  render() {
    return (
      <div className="">
        <h1>Welcome to the Dashboard</h1>
        <Projectitem/>
      </div>
    );
  }
}

export default Dashboard;
