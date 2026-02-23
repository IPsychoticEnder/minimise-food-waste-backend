import { useState } from 'react'
import Header from './components/nav-bar/NavBar'
import HomePage from './pages/home-page/HomePage'

import './App.css'
import './common.css'

function App() {
  return (
    <>
      <Header/>
      <HomePage/>
    </>
  )
}

export default App
