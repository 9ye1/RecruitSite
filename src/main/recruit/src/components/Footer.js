import React from 'react';
import styled from '../css/nav_footer.module.css';

function Footer() {
  return (
    <div>
      <footer className={styled.footer}>
        <h4 className={styled.who}>(주) 새날을 만들어 가는 사람들</h4>
        <span className={styled.who}>FrontEnd : 구예원 & 조건희</span>
        <span className={styled.who}>BackEnd : 이현정 & 이승준</span>
      </footer>
    </div>
  );
}

export default Footer;
