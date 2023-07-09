import React, { useState, useEffect } from 'react';

import Footer from '../components/Footer';
import SlideShow from '../components/SlideShow';
import General from '../components/General';
import styled from '../css/main.module.css';
import axios from 'axios';

function Main(props) {
  const [Comdata, setComdata] = useState([]);

  function clickGeneral(id) {
    props.setComId(id);
  }

  useEffect(() => {
    axios
      .get('http://localhost:3001/companiesMain')
      .then((response) => {
        setComdata(response.data);
      })
      .catch(() => {
        console.log('서버 연결 실패');
      });
  }, []);

  return (
    <div className={styled.main}>
      {/*<NavBar></NavBar>*/}
      <div className={styled.sizeBox}></div>
      <main className={styled.contents}>
        <SlideShow></SlideShow>

        <div className={styled.general}>
          <h3>일반 채용관</h3>
          <div className={styled.generalBox}>
            {Comdata.map((company) => (
              <General
                key={company.id}
                id={company.id}
                // image={company.image}
                name={company.name}
                job_group={company.job_group}
                onClick={clickGeneral}
              />
            ))}
          </div>
        </div>
      </main>
      <Footer></Footer>
    </div>
  );
}

export default Main;
