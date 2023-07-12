import React, { useEffect, useState } from 'react';
import axios from 'axios';
import styled from '../css/ComDetail.module.css';
import Person from '../components/Person';
import { useNavigate } from 'react-router-dom';


function ComDetail(props) {
  let [comId] = useState(0); //나중 수정 : props.comId
  let [comData, setcomData] = useState({
    "id": "",
    "image": " ",
    "name": " ",
    "job_group": " ",
    "info": " ",
    "personnel": " ",
    "salary": " ",
    "applicant": [
      {
        "id" : "1",
        "image": " ",
        "name": " ",
        "job": " "
      },
      {
        "id" : "2",
        "image": " ",
        "name": " ",
        "job": " "
      }]
  });
  let navigate = useNavigate();
  


  useEffect(() => {
    //렌더링 될 때 마다 실행
    axios
      //.get('http://211.176.69.65:8080/companies') //회사 id값으로 상세정보 가져오기
      .get('http://localhost:3001/companies')
      .then((data) => {
        //setcomData(data.data.postingList[props.comId]);
        console.log(data.data[comId]);
        setcomData(data.data[comId]);
      })
      .catch(() => {
        console.log('서버 연결 실패욤');
      });
  }, []);

  return (
    <>
    <div className={styled.box}></div>
    <div className={styled.ComDetail}>
        <div className={styled.content}>
            {/*<img className={styled.comImg} src={ comData && comData.image} />*/}
            <h1 className={styled.comName}>{comData.name ?? ''}</h1>
            <p>{comData.info ?? ''}</p><br/><br/>
            <p><span>직군</span> : {comData.job_group ?? ''}</p>
            <p><span>인원</span> : {comData.personnel ?? ''}</p>
            <p className={styled.comName} ><span>연봉</span> : {comData.salary  ?? ''}</p>
            <button onClick={ ()=> { navigate('/apply') } } className={styled.apply  ?? ''}>지원하기</button>
        </div>  


        <div className={styled.applicants}>
          <p className={styled.title}>현재 <span>{comData.name ?? ''}</span> 지원자</p>
          {
              comData.applicant && comData.applicant.map( function(a,i){
              //console.log(comData.applicant[i]);
              return <Person id={comData.applicant[i].id} person={comData.applicant[i]} />
              
              })
          }
         
        </div>

        
      
    </div> 

    {/* <div className={styled.qa}>
      <h2>Q/A</h2>
      <div className={styled.question}>
          영어 관련 자격증이 있어야 하나요?
      </div>

      <div className={styled.answer}>
          아니요. 영어 관련 자격증은 필요하지 않습니다.
      </div>
    </div> */}
    
    <div className={styled.qas}>
    <h2>🙌 기업에게 무엇이든 물어보세요!</h2>
    {
      comData.comment && comData.comment.map( function(a,i){
        return(
        //console.log(comData.applicant[i]);
          <div className={styled.qa}>
          
          <div className={styled.question}>
            <span>Q</span> { comData.comment[i].question}
          </div>

          <div className={styled.answer}>
          <span>A</span> { comData.comment[i].answer=='' ? <span className={styled.grey}>아직 답변이 없습니다. 잠시만 기다려 주세요</span> : <span>{comData.comment[i].answer}</span>}
          </div>
          <br/>
          </div>
        
        )
        
        })
    }
    </div>
    

    </>
 );
}

export default ComDetail;

/* 
function PersonDetail(){
  const [modalOpen, setModalOpen] = useState(false);

    // 모달창 노출
    const showModal = () => {
        setModalOpen(true);
    };

    return (
        <div>
            <button onClick={showModal}>모달 띄우기</button>
            {modalOpen && <ModalBasic setModalOpen={setModalOpen} />}
        </div>
    );
} */
/* import React from 'react';

function ComDetail(props) {
  console.log(props.comId);
  return <div>디테일 화면</div>;
}

export default ComDetail;
 */