import React, { useState } from 'react';
import Footer from '../components/Footer';
import styled from '../css/main.module.css';
import offerStyled from '../css/offer.module.css';
import axios from 'axios';

function Apply(prop) {
  const [formData, setFormData] = useState({
    id: `${prop.comId}`,
    name: '',
    age: '',
    gender: '',
    introduce: '',
    school: '',
    job: '',
    major: '',
    phone_number: '',
  });

  const handleChange = (e) => {
    setFormData({
      ...formData,
      [e.target.name]: e.target.value,
    });
  };

  const handleSubmit = (e) => {
    axios
      .post('api 주소', JSON.stringify(formData), {
        headers: {
          'Content-Type': 'application/json',
        },
      })
      .then((response) => {
        console.log(' 성공적으로 업로드되었습니다.');
        alert('지원 완료');
      })
      .catch((error) => {
        console.error(' 오류가 발생했습니다.', error);
      });
    console.log(JSON.stringify(formData));
  };

  return (
    <div className={styled.main}>
      {/*<NavBar></NavBar>*/}
      <div className={styled.sizeBox}></div>
      <main className={offerStyled.Offercontents}>
        {/* title */}
        <div className={styled.popular}>
          <div className={styled.popularTite}>
            <h3>지원 공고 올리기</h3>
            <p>기업에 지원하고 자신을 발전시키세요!</p>
          </div>
        </div>

        <div className={offerStyled.OfferForm}>
          <form
            style={{
              backgroundColor: 'rgb(255, 182, 182)',
            }}
            className={offerStyled.fromFlex}
            onSubmit={handleSubmit}
          >
            <div className={offerStyled.inputBox}>
              <input
                className={offerStyled.input}
                type="text"
                name="name"
                value={formData.name}
                onChange={handleChange}
                placeholder="이름"
              />
            </div>
            <div>
              <input
                className={offerStyled.input}
                type="text"
                name="age"
                value={formData.age}
                onChange={handleChange}
                placeholder="나이"
              />
            </div>
            <div>
              <input
                className={offerStyled.input}
                type="text"
                name="gender"
                value={formData.gender}
                onChange={handleChange}
                placeholder="성별"
              />
            </div>
            <div>
              <input
                className={offerStyled.input}
                type="text"
                name="school"
                value={formData.school}
                onChange={handleChange}
                placeholder="최종 학교"
              />
            </div>
            <div>
              <input
                className={offerStyled.input}
                type="text"
                name="job"
                value={formData.job}
                onChange={handleChange}
                placeholder="현 직장"
              />
            </div>
            <div>
              <input
                className={offerStyled.input}
                type="text"
                name="major"
                value={formData.major}
                onChange={handleChange}
                placeholder="전공"
              />
            </div>
            <div>
              <input
                className={offerStyled.input}
                type="text"
                name="phone_number"
                value={formData.phone_number}
                onChange={handleChange}
                placeholder="전화번호"
              />
            </div>
            <div>
              <input
                className={offerStyled.input}
                type="text"
                name="introduce"
                value={formData.introduce}
                onChange={handleChange}
                maxLength={300}
                placeholder="짧은 자기소개"
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

export default Apply;
