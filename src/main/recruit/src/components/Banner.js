import React from 'react';
import styled from '../css/main.module.scss';
import { Link } from 'react-router-dom';

function Banner({ image, title, Tolink }) {
  console.log(image);
  return (
    <div className={styled.BannerContainer}>
      <Link to={Tolink} target="_blank">
        <img src={image} alt={image} className={styled.bannerImg} />
      </Link>
    </div>
  );
}

export default Banner;
