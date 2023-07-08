import React, { useState, useEffect } from 'react';
import NavBar from '../components/NavBar';
import Footer from '../components/Footer';
import SlideShow from '../components/SlideShow';
import General from '../components/General';
import styled from '../css/main.module.scss';

function Main(props) {
  return (
    <div className={styled.main}>
      <NavBar></NavBar>
      <div className={styled.sizeBox}></div>
      <main className={styled.contents}>
        {/* 디자인 요소 */}
        <SlideShow></SlideShow>

        {/* 여기서부터가 진짜 우리 데이터 */}
        <div className={styled.general}>
          <h3> 일반 채용관</h3>
          <General></General>
        </div>
      </main>
      <Footer></Footer>
    </div>
  );
}

export default Main;
