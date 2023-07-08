import React from 'react';
import styled from '../css/main.module.scss';
import { Link } from 'react-router-dom';

function General() {
  return (
    <div>
      <Link to="/comDetail">
        <div className={styled.generalContainer}></div>
      </Link>
    </div>
  );
}

export default General;
