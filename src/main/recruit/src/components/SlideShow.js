import React, { useState, useEffect, useMemo } from 'react';
import Banner from './Banner';
import toss_banner from '../img/toss_banner.png';
import styled from '../css/main.module.css';

function Slideshow() {
  const banners = useMemo(
    () => [
      {
        image: toss_banner,
        title: '토스',
        Tolink: 'https://toss.im/career/jobs',
      },
      {
        image:
          'https://daoift3qrrnil.cloudfront.net/content_images/images/000/079/512/original/recruit_01_B_BX_copy.png?1628571409',
        title: '당근',
        Tolink: 'https://about.daangn.com/jobs/',
      },
      {
        image:
          'https://opening-attachments.greetinghr.com/20220324/428d2294-10fa-41fe-81a7-a9fefa8ecbe7/220323_Tech_%EC%B1%84%EC%9A%A9%EB%B0%B0%EB%84%88_1040_434.jpg',
        title: '무신사',
        Tolink: 'https://musinsa.career.greetinghr.com/',
      },
    ],
    []
  );

  const [currentBanner, setCurrentBanner] = useState(0);

  useEffect(() => {
    const interval = setInterval(() => {
      setCurrentBanner((prevBanner) => (prevBanner + 1) % banners.length);
    }, 3000);

    return () => {
      clearInterval(interval);
    };
  }, [banners]);

  return (
    <div className={styled.popular}>
      <div className={styled.popularTite}>
        <h3>인기 채용관</h3>
        <p>현재 가장 인기있는 채용관이에요</p>
      </div>

      <Banner {...banners[currentBanner]} />
      <div className={styled.fakeSelectorContainer}>
        <div className={styled.fakeSelector}></div>
        <div className={styled.fakeSelector}></div>
        <div className={styled.fakeSelector}></div>
      </div>
    </div>
  );
}

export default Slideshow;
