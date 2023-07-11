import React, { useEffect, useState } from 'react';
import styled from '../css/person.module.css';
import axios from 'axios';


function Person(props){

    let [p,setPerson] = useState(
      {
        "id": "1",
        "image": "https://framerusercontent.com/images/y7135TGP0TiQ7gtLbQ0IrWOzww.jpg",
        "name": "토스",
        "age": "23",
        "gender" : "1",
        "introduce" : "안녕하세요 ",
        "school" : "단국대학교",
        "job" : "학생",
        "major" : "소프트웨어학과",
        "phoneNumber" : "010-8282-1110"
      }
    );
    let [modalOpen, setModalOpen] = useState(false);

    useEffect(() => {
    }, []);
      // 모달창 노출
    const showModal = () => {
        setModalOpen(true);
        console.log(modalOpen);
    };

    const closeModal = () => {
        setModalOpen(false);
        console.log(modalOpen);
    };
  
    return(
        <>
        <div onClick={ ()=>{ 
          
          axios
          //.get('http://211.176.69.65:8080/companies') //회사 id값으로 상세정보 가져오기
          .get(`http://localhost:3001/users/${props.id}`)
          .then((data) => {
            //setcomData(data.data.postingList[props.comId]);
            console.log(data.data);
            setPerson(data.data);
            showModal();
          })
          .catch(() => {
            console.log('서버 연결 실패욤');
          });
          
          
          return (showModal)}
          
          
           }  className={styled.person}>
        {/*modalOpen && <ModalBasic modalOpen={modalOpen} setModalOpen={setModalOpen} />*/}
        <img src="https://i.ibb.co/HnF3dKx/person.png"/>
        <div>
        <p className={styled.personName}>{props.person.name}</p>
        <p className={styled.personJob}>{props.person.job}</p>
        </div>
        
      </div>
      {
            modalOpen ? (
                <div className={styled.container}>
                    <button className={styled.close} onClick={ closeModal }>
                         X
                    </button>
                    <div className={styled.contentOne}>

                      <img className={styled.Img}src="https://i.ibb.co/HnF3dKx/person.png"/>
                      <div>
                        <p>이름 : <span>{p.name}</span></p>
                        <p>나이 : <span>{p.age}</span></p>
                        <p>성별 : <span>{p.gender==='0'? <span>남</span> : <span>여</span> }</span></p>
                      </div>
                     
                    </div>
                    <div className={styled.contentTwo}>
                      <p>직업 : <span>{p.job}</span></p>
                      <p>학교 : <span>{p.school}</span></p>
                      <p>전공 : <span>{p.major}</span></p>
                      <p>휴대폰 번호 : <span>{p.phoneNumber}</span></p>
                      <p>자기소개 : <span></span>{p.introduce}</p>
                    </div>
                </div>
              ) : null
        }
        </>
      
    )
  }

 /*  function Popup(){
    return(
        <div className={styled.container}>
            <button className={styled.close} onClick={closeModal}>
                X
            </button>
            <p>모달창입니다.</p>
        </div>
    )
  } */

  export default Person;