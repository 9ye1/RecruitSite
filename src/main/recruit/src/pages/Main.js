import React from 'react';
import NavBar from '../components/NavBar';
import Footer from '../components/Footer';
import styled from '../css/main.module.scss';

function Main() {
  return (
    <div className={styled.main}>
      <NavBar></NavBar>
      <div className={styled.sizeBox}></div>
      <main className={styled.contents}></main>
      <Footer></Footer>
    </div>
  );
}

export default Main;
