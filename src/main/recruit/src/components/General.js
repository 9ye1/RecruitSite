import React from 'react';
import styled from '../css/main.module.scss';
import { Link } from 'react-router-dom';

function General(props) {
  return (
    <div>
      <Link to="/comDetail" className={styled.linktocomD}>
        <div className={styled.generalContainer}>
          <img
            src={props.image}
            alt="기업 이미지"
            className={styled.generalCompimg}
          ></img>
          <span>{props.name}</span>
          <span>{props.job_group}</span>
        </div>
      </Link>
    </div>
  );
}

export default General;
