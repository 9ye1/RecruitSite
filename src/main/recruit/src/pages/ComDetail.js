import React, { useEffect, useState } from 'react';
import { useNavigate } from 'react-router-dom';
import axios from 'axios';

function ComDetail(props) {

  let navigater = useNavigate();
  let comId = 0; //나중 수정 : props.comId
  let [comData, setcomData] = useState();

  useEffect(()=>{ //렌더링 될 때 마다 실행
    axios.get(`http://localhost:3001/companies`) //회사 id값으로 상세정보 가져오기 
				.then( (data)=>{ 
          setcomData(data.data[comId]);
					console.log(comData.name);
          
				}).catch( ()=>{
					console.log('서버 연결 실패욤');
		    })
      },[]);

  return (
    <>
      <div>
        <h1>{comData.name}</h1>
        <p>채용 직군 : {comData.job_group}</p>
        <p>{comData.info}</p>
        <p>{comData.personnel}</p>
        <p>{comData.salary}</p>
      </div>
    
    
    
    </>
  )
}
export default ComDetail;
