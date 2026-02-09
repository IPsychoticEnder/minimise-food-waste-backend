import React from 'react'

import './nav-bar.css'

type Props = {}

function header({}: Props) {
  return (
    <div className='header-container'>
      <div className='header-logo'>
        <p>Min-food-waste</p>
      </div>
      <div className='header-nav-icon'>
        <div className='header-nav'>
          <p>Home</p>
          <p>Browse recipe's</p>
          <p>My recipe's</p>
          <p>This week</p>
          <p>Settings</p>
        </div>
        <div className='user-icon'>
          user icon
        </div>
      </div>
    </div>
  )
}

export default header