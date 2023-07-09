import React, { useEffect, useState } from 'react';
import { useNavigate } from 'react-router-dom';
import axios from 'axios';
import styled from '../css/ComDetail.module.css';

function ComDetail(props) {
  let navigater = useNavigate();
  let comId = 0; //나중 수정 : props.comId
  let [comData, setcomData] = useState({});

  function setDate() {
    var newArr = [...comData]; //deepcopy
    newArr[0] = 'state 수정법';
    setcomData(newArr);
  }

  useEffect(() => {
    //렌더링 될 때 마다 실행
    axios
      .get(`http://localhost:3001/companies`) //회사 id값으로 상세정보 가져오기
      .then((data) => {
        setcomData(data.data[comId]);
        console.log(comData.name);
      })
      .catch(() => {
        console.log('서버 연결 실패욤');
      });
  }, []);

  return (
    <div className={styled.ComDetail}>
      <div className={styled.sizeBox}></div>
      <div className={styled.content}>
        <div className={styled.box}>
          <img className={styled.comImg} src="" />
          <h1 className={styled.comName}>{comData.name}</h1>
        </div>

        <div>
          <p>{comData.info}</p>
          <br />
          <br />
          <p>직군 : {comData.job_group}</p>
          <p>인원 : {comData.personnel}</p>
          <p className={styled.comName}>연봉 : {comData.salary}</p>
        </div>
      </div>
    </div>
  );
}
export default ComDetail;
