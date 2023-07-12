import React, { useState } from 'react';
import Footer from '../components/Footer';
import styled from '../css/main.module.css';
import offerStyled from '../css/offer.module.css';
import axios from 'axios';

function Offer() {
  const [formData, setFormData] = useState({
    name: '',
    job_group: '',
    info: '',
    personnel: '',
    salary: '',
    image: '',
  });

  const handleChange = (e) => {
    setFormData({
      ...formData,
      [e.target.name]: e.target.value,
    });
  };

  const handleSubmit = (e) => {
    axios
      .post('http://3.39.3.54:8080/companies/posts', JSON.stringify(formData), {
        headers: {
          'Content-Type': 'application/json',
        },
      })
      .then((response) => {
        console.log('채용 공고가 성공적으로 업로드되었습니다.');
        alert('채용 공고가 성공적으로 업로드되었습니다.');
      })
      .catch((error) => {
        console.error('채용 공고 업로드 중 오류가 발생했습니다.', error);
      });
  };

  return (
    <div className={styled.main}>
      {/*<NavBar></NavBar>*/}
      <div className={styled.sizeBox}></div>
      <main className={offerStyled.Offercontents}>
        {/* title */}
        <div className={styled.popular}>
          <div className={styled.popularTite}>
            <h3>기업 채용 공고 올리기</h3>
            <p>함께 세상을 바꿀 동료를 구해보세요!</p>
          </div>
        </div>

        <div className={offerStyled.OfferForm}>
          <form className={offerStyled.fromFlex} onSubmit={handleSubmit}>
            <div className={offerStyled.inputBox}>
              {/* <label className={offerStyled.label}>기업 이름</label> */}
              <input
                className={offerStyled.input}
                type="text"
                name="name"
                value={formData.name}
                onChange={handleChange}
                placeholder="기업 이름"
              />
            </div>
            <div>
              {/* <label>채용 직군</label> */}
              <input
                className={offerStyled.input}
                type="text"
                name="job_group"
                value={formData.job_group}
                onChange={handleChange}
                placeholder="채용 직군"
              />
            </div>
            <div>
              {/* <label>기업 정보</label> */}
              <input
                className={offerStyled.input}
                type="text"
                name="info"
                value={formData.info}
                onChange={handleChange}
                maxLength="300"
                placeholder="간단 기업 정보"
              />
            </div>
            <div>
              {/* <label>채용 인원</label> */}
              <input
                className={offerStyled.input}
                type="number"
                name="personnel"
                value={formData.personnel}
                onChange={handleChange}
                placeholder="채용 인원"
              />
            </div>
            <div>
              {/* <label>연봉 정보</label> */}
              <input
                className={offerStyled.input}
                type="number"
                name="salary"
                value={formData.salary}
                onChange={handleChange}
                placeholder="연봉 정보"
              />
            </div>
            <button type="submit" className={offerStyled.button}>
              채용 공고 업로드
            </button>
          </form>
        </div>
      </main>
      <Footer></Footer>
    </div>
  );
}

export default Offer;
