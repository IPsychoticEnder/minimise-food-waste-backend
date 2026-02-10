import React from 'react'

import './nav-bar.css'

import { NavLink } from 'react-router-dom'
import { MdAccountCircle } from "react-icons/md";
import ReusableDropdown from '../ReusableDropdown/ReusableDropdown';
import ProfilePopup from '../profile-popup/profile-popup';

type Props = {}

function header({}: Props) {
  return (
    <div className='header'>
      <div className='header-container'>
        <div className='header-logo'>
          <p><NavLink className='header-logo-text' to='/'>Minimise Food Waste</NavLink></p>
        </div>

        <div className='header-nav-icon'>
          <div className='header-nav'>
            <p><NavLink className='link' to='/'>Home</NavLink></p>
            <p><NavLink className='link' to='/'>Browse recipe's</NavLink></p>
            <p><NavLink className='link' to='/'>My recipe's</NavLink></p>
            <p><NavLink className='link' to='/'>This week</NavLink></p>
            <p><NavLink className='link' to='/'>Settings</NavLink></p>
          </div>

          <div className='user-icon'>
            <ReusableDropdown
              trigger={
                <div className="user-icon-trigger">
                  <MdAccountCircle size={32} />
                </div>
              }
            >
              <ProfilePopup />
            </ReusableDropdown>
          </div>
        </div>
      </div>
    </div>
  )
}

export default header