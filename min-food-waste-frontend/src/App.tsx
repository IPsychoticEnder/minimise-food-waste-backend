import { useState } from 'react'
import Header from './components/nav-bar/NavBar'
import HomePage from './pages/home-page/HomePage'
import SignUpPage from './pages/sign-up-page/SignUpPage'

import './App.css'
import './common.css'
import { Route, Routes } from 'react-router-dom'

function App() {
  return (
    <>
      <Header/>
      <Routes>
        <Route path='/' element={<HomePage/>}/>
        <Route path='/signup' element={<SignUpPage/>}/>
      </Routes>
    </>
  )
}

export default App
