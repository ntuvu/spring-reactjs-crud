import './App.css';
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import FooterComponent from './components/FooterComponent';
import HeaderComponent from './components/HeaderComponent';
import ListEmployeeComponent from './components/ListEmployeeComponent';
import AddComponent from './components/AddComponent';

function App() {
  return (
    <div>
      <Router>
        <HeaderComponent />
        <div className='container'>
          <Routes>
            <Route path='/' element={<ListEmployeeComponent />}></Route>
            <Route
              path='/employees'
              element={<ListEmployeeComponent />}
            ></Route>
            <Route path='/add' element={<AddComponent />}></Route>
            <Route path='/edit/:id' element={<AddComponent />}></Route>
          </Routes>
        </div>
        <FooterComponent />
      </Router>
    </div>
  );
}

export default App;
