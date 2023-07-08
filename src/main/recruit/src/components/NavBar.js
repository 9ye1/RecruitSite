import React from 'react';
import styled from '../css/nav_footer.module.css';
import { Link } from 'react-router-dom';

function NavBar() {
  return (
    <div>
      <nav className={styled.nav}>
        <div className={styled.slogan}>
          <h1>HIRE</h1>
          <span>노력으로 그린 당신의 오늘, 마침내 빛날 희망의 내일</span>
        </div>
        <div className={styled.fakeLinkBox}>
          <Link
            className={styled.fakeLink}
            to="https://youngwoong.dankook.ac.kr/ptfol/empymn/recomend/findRecomendMngtList.do"
            target="_blank"
          >
            채용 NEWS
          </Link>
          <Link
            className={styled.fakeLink}
            to="https://www.career.go.kr/cnet/front/examen/inspctStd.do"
            target="_blank"
          >
            직업 TEST
          </Link>
          <Link
            className={styled.fakeLink}
            to="https://www.work.go.kr/cyberedu/main.do"
            target="_blank"
          >
            교육
          </Link>
          <Link
            className={styled.fakeLink}
            to="https://job.alio.go.kr/main.do"
            target="_blank"
          >
            공공정보
          </Link>
          <Link
            className={styled.fakeLink}
            to="https://www.dankook.ac.kr/web/kor/-550"
            target="_blank"
          >
            커뮤니티
          </Link>
          <Link to="/offer" className={styled.home_to_offer}>
            <button className={styled.offerButton}>기업 공고 올리기</button>
          </Link>
        </div>
      </nav>
    </div>
  );
}

export default NavBar;
