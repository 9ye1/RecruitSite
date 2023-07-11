import React from 'react';
import styled from '../css/main.module.css';
import { Link } from 'react-router-dom';

function General(props) {
  function handleClick() {
    props.onClick(props.id);
  }

  return (
    <div>
      <Link to="/comDetail" className={styled.linktocomD}>
        <div className={styled.generalContainer} onClick={handleClick}>
          {/* <img
            src={props.image}
            alt="기업 이미지"
            className={styled.generalCompimg}
          /> */}
          <h2>{props.name}</h2>
          <span>{props.job_group}</span>
        </div>
      </Link>
    </div>
  );
}

export default General;
