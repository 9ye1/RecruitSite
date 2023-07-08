import { React, useState } from 'react';
import { Routes, Route } from 'react-router-dom';
import Apply from './pages/Apply';
import ComDetail from './pages/ComDetail';
import Main from './pages/Main';
import Offer from './pages/Offer';
import './css/app.css';
import NavBar from './components/NavBar';

function App() {
  const [comId, setComId] = useState(0);

  return (
    <>
    <NavBar></NavBar>
    <div className="App">
      <Routes>
        <Route path="/" element={<Main setComId={setComId} />}></Route>
        <Route path="/offer" element={<Offer />}></Route>
        <Route path="/apply" element={<Apply comId={comId} />}></Route>
        <Route path="/comDetail" element={<ComDetail comId={comId} />}></Route>
      </Routes>
    </div>
    </>
    
  );
}

export default App;
