import React, { Component } from 'react'
import Projectitem from './Project/Projectitem';
import "bootstrap/dist/css/bootstrap.min.css";

class Dashboard extends Component {
  render() {
    return (
      <div className="projects">
      <div className="container">
          <div className="row">
              <div className="col-md-12">
                  <h1 className="display-4 text-center">Projects</h1>
                  <br />
                  <a href="ProjectForm.html" className="btn btn-lg btn-info">
                      Create a Project
                  </a>
                  <br />
                  <hr />

                  {/* <!-- Project Item Component --> */}
                  <Projectitem />
                  {/* <!-- End of Project Item Component --> */}

              </div>
          </div>
      </div>
  </div>
    );
  }
}

export default Dashboard;
